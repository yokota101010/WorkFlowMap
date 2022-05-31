package com.example.port.adapter.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskListController {

	/*タスク（一覧）画面を表示*/
	@GetMapping("/list")
	public String getTaskList() {
		return "task/list";
	}

}
