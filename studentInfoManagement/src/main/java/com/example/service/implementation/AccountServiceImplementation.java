package com.example.service.implementation;

import com.example.mapper.AccountMapper;
import com.example.pojo.Account;
import com.example.service.AccountService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@MapperScan("com.example.mapper")
public class AccountServiceImplementation implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public int checkAccountExistence(Account account, HttpSession session) {
        String username = account.getUsername();
        String password = account.getPassword();

        return accountMapper.checkAccountExistence(username, password);
    }
}
