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

import com.example.application.EmployeeService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.domain.model.employee.EmployeeId;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.view.dpo.EmployeeDetailDpo;
import com.example.utilities.SessionInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeDetailController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SessionInfo sessionInfo;

	/*従業員（詳細）画面を表示*/
	@RequestMapping(value = "/detail", params = "btn-detail", method = RequestMethod.POST)
	public String postEmployeeDetail(
				@RequestParam("selectedEmployeeId") String selectedEmployeeId,
				EmployeeDetailDpo dpo,
				Model model) {

		//従業員をdpoに設定
		dpo.setEmployee(employeeService.getEmployee(
				new OrganizationId(sessionInfo.getOrganizationId()),
				new EmployeeId(selectedEmployeeId)));

		return "employee/detail";
	}

	/*従業員を削除*/
	@RequestMapping(value = "/detail", params = "btn-delete", method = RequestMethod.POST)
	public String postEmployeeDelete(
			EmployeeDetailDpo dpo,
			Model model,
			RedirectAttributes redirectAttributes) {

		//バリデーションチェック＋処理実行
		try {
			employeeService.deleteEmployee(dpo.getEmployee());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "employee/detail";
		}

		redirectAttributes.addFlashAttribute("processingResult", "削除が完了しました。");
		return "redirect:/employee/list";
	}

	/*従業員を更新*/
	@RequestMapping(value = "/detail", params = "btn-update", method = RequestMethod.POST)
	public String postEmployeeUpdate(
				@Validated EmployeeDetailDpo dpo,
				BindingResult bindingResult,
				Model model,
				RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "employee/detail";
		}

		//バリデーションチェック＋処理実行
		try {
			employeeService.updateEmployee(dpo.getEmployee());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "employee/detail";
		}

		redirectAttributes.addFlashAttribute("processingResult", "更新が完了しました。");
		return "redirect:/employee/list";
	}
}
