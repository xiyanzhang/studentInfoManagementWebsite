package com.example.pojo;

public class Result {
  private String token;
  private String status;
  private Integer code;
  public Result(String token, String status, Integer code) {
    this.token = token;
    this.status = status;
    this.code = code;
  }
}
