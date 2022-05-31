package com.example.port.adapter.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.AbilityService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.domain.model.ability.Ability;
import com.example.domain.model.ability.AbilityId;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.view.dpo.AbilityDetailDpo;
import com.example.utilities.SessionInfo;

@Controller
@RequestMapping("/ability")
public class AbilityDetailController {

	@Autowired
	private AbilityService service;

	@Autowired
	private SessionInfo sessionInfo;

	/*職能（詳細）画面を表示*/
	@RequestMapping(value = "/detail", params = "btn-detail", method = RequestMethod.POST)
	public String postAbilityDetail(
				@RequestParam("selectedAbilityId") String selectedAbilityId,
				AbilityDetailDpo dpo,
				Model model,
				RedirectAttributes redirectAttributes) {

		Ability ability;
		try {
			ability = service.getAbility(
						new OrganizationId(sessionInfo.getOrganizationId()),
						new AbilityId(selectedAbilityId));

		} catch(Exception e) {

			redirectAttributes.addFlashAttribute("processingResult", e.getMessage());
			return "redirect:/ability/list";
		}

		dpo.setAbility(ability);
		return "ability/detail";
	}

	/*職能を削除*/
	@RequestMapping(value = "/detail", params = "btn-delete", method = RequestMethod.POST)
	public String postAbilityDelete(
			AbilityDetailDpo dpo,
			Model model,
			RedirectAttributes redirectAttributes) {

		//バリデーションチェック＋処理実行
		try {
			service.deleteAbility(dpo.getAbility());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "ability/detail";
		}

		redirectAttributes.addFlashAttribute("processingResult", "削除が完了しました。");
		return "redirect:/ability/list";
	}

	/*職能を更新*/
	@RequestMapping(value = "/detail", params = "btn-update", method = RequestMethod.POST)
	public String postAbilityUpdate(
				@Validated AbilityDetailDpo dpo,
				BindingResult bindingResult,
				Model model,
				RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			return "ability/detail";
		}

		//バリデーションチェック＋処理実行
		try {
			service.updateAbility(dpo.getAbility());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "ability/detail";
		}

		redirectAttributes.addFlashAttribute("processingResult", "更新が完了しました。");
		return "redirect:/ability/list";
	}
}
