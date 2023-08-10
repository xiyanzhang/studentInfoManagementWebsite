package com.example.service;

import com.example.pojo.Account;

import javax.servlet.http.HttpSession;

public interface AccountService {
    int checkAccountExistence(Account account, HttpSession session);
}
