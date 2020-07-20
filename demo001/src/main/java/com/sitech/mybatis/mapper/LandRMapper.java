package com.sitech.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sitech.mybatis.dao.User;

@Mapper
public interface LandRMapper {
	
    @Select("select u.email,u.password from user u where email=#{email} and password=#{password}")
    @Results(id="user",value= {
    		@Result(column="email",property="email"),
    		@Result(column="password",property="password")
    })
    List<User> login(String email,String password);
}
