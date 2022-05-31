package com.example.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.domain.model.employee.Employee;
import com.example.domain.model.employee.EmployeeRepository;
import com.example.domain.model.loginuser.Loginuser;
import com.example.domain.model.loginuser.LoginuserRepository;
import com.example.domain.model.loginuser.UserId;
import com.example.domain.model.organization.Organization;
import com.example.domain.model.organization.OrganizationRepository;
import com.example.utilities.SessionInfo;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private LoginuserRepository usrRepository;

	@Autowired
	private OrganizationRepository orgRepository;

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private SessionInfo sessionInfo;

	/**認証成功時にセッション情報を設定*/
	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		//OrganizationIdをsessionInfoに登録
		String organizationId = null;

		Loginuser loginuser = usrRepository.findLoginUser(new UserId(authentication.getName()));
		if(loginuser.getRole().equals("ROLE_ADMIN")) {

			Organization organization = orgRepository.findOneByUserId(new UserId(authentication.getName()));
			organizationId = organization.getOrganizationId().getId();
		} else {

			Employee employee = empRepository.findOneByUserId(new UserId(authentication.getName()));
			organizationId = employee.getOrganizationId().getId();
		}

		sessionInfo.setOrganizationId(organizationId);

		//"/division/list"にリダイレクトする
		response.sendRedirect(request.getContextPath() + "/division/list");
	}
}
