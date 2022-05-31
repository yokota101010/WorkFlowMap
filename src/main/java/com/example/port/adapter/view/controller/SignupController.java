package com.example.port.adapter.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.OrganizationService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.port.adapter.view.dpo.SignupDpo;

@Controller
public class SignupController {

	@Autowired
	private OrganizationService service;

	/*サインアップ画面を表示*/
	@GetMapping("/signup")
	public String getSignup(SignupDpo dpo, Model model) {

		dpo.setOrganization(service.newOrganization());

		return "certification/signup";
	}

	/*サインアップ処理*/
	@PostMapping("/signup")
	public String postSignup(
			@Validated SignupDpo dpo,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			return "certification/signup";
		}

		//バリデーションチェック＋処理実行
		try {
			service.registerOrganization(dpo.getOrganization());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "certification/signup";
		}

		redirectAttributes.addFlashAttribute("processingResult", "登録が完了しました。");
		return "redirect:/signin";
	}
}
