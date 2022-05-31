package com.example.port.adapter.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.AbilityService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.port.adapter.view.dpo.AbilityNewDpo;

@Controller
@RequestMapping("/ability")
public class AbilityNewController {

	@Autowired
	private AbilityService service;

	/*職能（新規）画面を表示*/
	@GetMapping("/new")
	public String getAbilityNew(AbilityNewDpo dpo, Model model) {

		dpo.setAbility(service.newAbility());

		//部署（新規）画面を表示
		return "ability/new";
	}

	/*職能を作成*/
	@PostMapping("/new")
	public String postAbilityNew(
				@Validated AbilityNewDpo dpo,
				BindingResult bindingResult,
				Model model,
				RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			return "ability/new";
		}

		//バリデーションチェック＋処理実行
		try {
			service.registerAbility(dpo.getAbility());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "ability/new";
		}

		redirectAttributes.addFlashAttribute("processingResult", "登録が完了しました。");
		return "redirect:/ability/list";
	}
}
