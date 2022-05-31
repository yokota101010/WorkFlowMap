package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private SuccessHandler successHandler;

	@Autowired
	private PasswordEncoder encoder;

	/**セキュリティの対象外を設定*/
	@Override
	public void configure(WebSecurity web) throws Exception {

		//セキュリティを適用しない
		web.ignoring()
			.antMatchers("/webjars/**")
			.antMatchers("/css/**")
			.antMatchers("/js/**")
			.antMatchers("/h2-console/**");
	}

	/**セキュリティの各種設定*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//ログイン不要ページの設定
		http.authorizeRequests()
			.antMatchers("/signin").permitAll() //直リンクOK
			.antMatchers("/signup").permitAll() //直リンクOK
			.anyRequest().authenticated(); //それ以外は直リンクNG

		//ログイン処理
		http.formLogin()
			.loginProcessingUrl("/signin") //ログイン処理のパス
			.loginPage("/signin") //ログインページの指定
			.failureUrl("/signin?error") //ログイン失敗時の遷移先
			.usernameParameter("userId") //ログインページのユーザID
			.passwordParameter("password") //ログインページのパスワード
			//.defaultSuccessUrl("/division/list",true); //成功時の遷移先（今回はハンドラへ遷移するのでコメントアウト）
			.successHandler(successHandler);//認証成功時に呼ばれるハンドラクラスを設定

		//ログアウト処理
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			//.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout");

	}

	/**認証の設定*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//ユーザーデータで認証
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(encoder);
	}
}
