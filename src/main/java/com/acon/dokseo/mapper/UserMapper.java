package com.acon.dokseo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.acon.dokseo.dto.User;

@Mapper
public interface UserMapper {
	User selectOneForLogin(@Param("user_id") String user_id,@Param("user_pw") String user_pw);
	User selectOneById(String user_id);
	User selectOneByEmail(String user_email);
}
