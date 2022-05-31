package com.example.port.adapter.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.EmployeeService;
import com.example.domain.model.EntityIntegrityViolationException;
import com.example.port.adapter.view.dpo.EmployeeNewDpo;

@Controller
@RequestMapping("/employee")
public class EmployeeNewController {

	@Autowired
	private EmployeeService service;

	/*従業員（新規）画面を表示*/
	@GetMapping("/new")
	public String getEmployeeNew(EmployeeNewDpo dpo, Model model) {

		dpo.setEmployee(service.newEmployee());

		//部署（新規）画面①を表示
		return "Employee/new";
	}

	/*従業員を作成*/
	@RequestMapping(value = "/new", params = "btn-new", method = RequestMethod.POST)
	public String postEmployeeNew_middle(
			@Validated EmployeeNewDpo dpo,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes redirectAttributes) {

		//入力チェック結果確認
		if(bindingResult.hasErrors()) {
			return "Employee/new";
		}

		//バリデーションチェック＋処理実行
		try {
			service.registerEmployee(dpo.getEmployee());

		} catch(EntityIntegrityViolationException e) {

			model.addAttribute("processingResult", e.getMessage());
			return "Employee/new";
		}

		redirectAttributes.addFlashAttribute("processingResult", "登録が完了しました。");
		return "redirect:/employee/list";
	}
}
