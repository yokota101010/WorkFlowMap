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

import com.example.application.DivisionService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.domain.model.division.Division;
import com.example.domain.model.division.DivisionId;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.view.dpo.DivisionDetailDpo;
import com.example.utilities.SessionInfo;

@Controller
@RequestMapping("/division")
public class DivisionDetailController {

	@Autowired
	private DivisionService service;

	@Autowired
	private SessionInfo sessionInfo;

	/*部署（詳細）画面を表示*/
	@RequestMapping(value = "/detail", params = "btn-detail", method = RequestMethod.POST)
	public String postDivisionDetail(
				@RequestParam("selectedDivisionId") String selectedDivisionId,
				DivisionDetailDpo dpo,
				Model model) {

		//部署をdpoに設定
		Division division
			= service.getDivision(
					new OrganizationId(sessionInfo.getOrganizationId()),
					new DivisionId(selectedDivisionId));
		dpo.setDivision(division);

		return "division/detail";
	}

	/*部署を削除*/
	@RequestMapping(value = "/detail", params = "btn-delete", method = RequestMethod.POST)
	public String postDivisionDelete(
			DivisionDetailDpo dpo,
			Model model,
			RedirectAttributes redirectAttributes) {

		//バリデーションチェック＋処理実行
		try {
			service.deleteDivision(dpo.getDivision());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "division/detail";
		}

		redirectAttributes.addFlashAttribute("processingResult", "削除が完了しました。");
		return "redirect:/division/list";
	}

	/*部署を更新*/
	@RequestMapping(value = "/detail", params = "btn-update", method = RequestMethod.POST)
	public String postDivisionUpdate(
				@Validated DivisionDetailDpo dpo,
				BindingResult bindingResult,
				Model model,
				RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			return "division/detail";
		}

		//バリデーションチェック＋処理実行
		try {
			service.updateDivision(dpo.getDivision());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "division/detail";
		}

		redirectAttributes.addFlashAttribute("processingResult", "更新が完了しました。");
		return "redirect:/division/list";
	}
}
