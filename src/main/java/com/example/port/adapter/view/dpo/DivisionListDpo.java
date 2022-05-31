package com.example.port.adapter.view.dpo;

import java.util.List;

import com.example.domain.model.division.Division;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class DivisionListDpo {

	/*部署情報一覧*/
	private List<Division> divisionList;
}
