package com.example.port.adapter.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {

	/*サインイン画面を表示*/
	@GetMapping("/signin")
	public String getSignin() {
		return "certification/signin";
	}

	/*タスク実行（一覧）画面にリダイレクト*/
	//Springセキュリティが実施
}
