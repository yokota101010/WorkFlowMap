package com.example.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.model.EntityNotExistsException;
import com.example.domain.model.loginuser.Loginuser;
import com.example.domain.model.loginuser.LoginuserRepository;
import com.example.domain.model.loginuser.UserId;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginuserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*システム利用者取得*/
		Loginuser loginUser;
		try {
			loginUser = repository.findLoginUser(new UserId(username));

		} catch(EntityNotExistsException e) {
			throw new UsernameNotFoundException("user not found");
		}

		/*権限List作成*/
		GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getRole());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);

		/*UserDetails生成*/
		UserDetails userDetails = (UserDetails) new User(loginUser.getUserId().getId(), loginUser.getPassword(), authorities);

		return userDetails;
	}
}
