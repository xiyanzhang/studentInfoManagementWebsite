package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Select("SELECT COUNT(*) FROM useraccount_data WHERE username = #{username} AND password = #{password}")
    int checkAccountExistence(String username, String password);
}

