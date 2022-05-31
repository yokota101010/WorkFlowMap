package com.example.port.adapter.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.AbilityService;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.view.dpo.AbilityListDpo;
import com.example.utilities.SessionInfo;

@Controller
@RequestMapping("/ability")
public class AbilityListController {

	@Autowired
	private AbilityService service;

	@Autowired
	private SessionInfo sessionInfo;

	/*職能（一覧）画面を表示*/
	@GetMapping("/list")
	public String getAbilityList(AbilityListDpo dpo, Model model) {

		//職能リストをdpoに設定
		dpo.setAbilityList(service.getAbilities(new OrganizationId(sessionInfo.getOrganizationId())));

		//部署（一覧）画面を表示
		return "ability/list";
	}
}
