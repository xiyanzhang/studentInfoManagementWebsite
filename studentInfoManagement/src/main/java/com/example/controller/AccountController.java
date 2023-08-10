package com.example.controller;

import com.example.mapper.LogInStatusMapper;
import com.example.pojo.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    LogInStatusMapper logInStatusMapper;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
    @PostMapping("/checkAccountExistence")
    public String checkAccountExistence(@RequestBody Account account, HttpSession session) {

        int count = accountService.checkAccountExistence(account, session);
        System.out.println(count);
        String token = "";
        Map<String, Object> tokenData = null;
        if (count > 0) {
            // Generate a UUID token
            token = UUID.randomUUID().toString();

            System.out.println(token);
            logInStatusMapper.logInInfo(account.getUsername(), token);
        }
        return token;
    }

}
