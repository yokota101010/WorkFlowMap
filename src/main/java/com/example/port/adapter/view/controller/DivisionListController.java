package com.example.port.adapter.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.DivisionService;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.view.dpo.DivisionListDpo;
import com.example.utilities.SessionInfo;

@Controller
@RequestMapping("/division")
public class DivisionListController {

	@Autowired
	private DivisionService service;

	@Autowired
	private SessionInfo sessionInfo;

	/*部署（一覧）画面を表示*/
	@GetMapping("/list")
	public String getDivisionList(DivisionListDpo dpo, Model model) {

		//部署リストをdpoに設定
		dpo.setDivisionList(service.getDivisions(new OrganizationId(sessionInfo.getOrganizationId())));

		//部署（一覧）画面を表示
		return "division/list";
	}
}
