package com.example.port.adapter.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.loginuser.Loginuser;
import com.example.domain.model.loginuser.UserId;

@Mapper
public interface LoginuserMapper {

	/*システム利用者作成（１件）*/
	public void insertOne(@Param("_Loginuser") Loginuser user);

	/*システム利用者更新（１件）*/
	public int updateOne(@Param("_Loginuser") Loginuser user);

	/*システム利用者削除（１件）*/
	public int deleteOne(@Param("_Loginuser") Loginuser user);

	/*システム利用者取得（１件）*/
	public Loginuser findOne(@Param("_UserId") UserId userId);
}
