package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.Date;

@Mapper
public interface LogInStatusMapper {

  @Insert("INSERT INTO logIn_data (username, token, creationTime, expirationTime) " +
      "VALUES (#{username}, #{token}, SYSDATE(), DATE_ADD(SYSDATE(), INTERVAL 20 MINUTE))")
  void logInInfo(String username, String token);

  @Select("SELECT expirationTime FROM logIn_data WHERE token = #{token}")
  LocalDateTime expirationTime(String token);
}
