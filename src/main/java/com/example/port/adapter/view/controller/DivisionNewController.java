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

import com.example.application.DivisionService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.port.adapter.view.dpo.DivisionNewDpo;

@Controller
@RequestMapping("/division")
public class DivisionNewController {

	@Autowired
	private DivisionService service;

	/*部署（新規）画面を表示*/
	@GetMapping("/new")
	public String getDivisionNew(DivisionNewDpo dpo, Model model) {

		dpo.setDivision(service.newDivision());

		//部署（新規）画面を表示
		return "division/new";
	}

	/*部署を作成*/
	@PostMapping("/new")
	public String postDivisionNew(
			@Validated DivisionNewDpo dpo,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			return "division/new";
		}

		//バリデーションチェック＋処理実行
		try {
			service.registerDivision(dpo.getDivision());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "division/new";
		}

		redirectAttributes.addFlashAttribute("processingResult", "登録が完了しました。");
		return "redirect:/division/list";
	}
}
