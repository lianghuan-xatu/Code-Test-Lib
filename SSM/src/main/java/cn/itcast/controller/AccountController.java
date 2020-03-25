package cn.itcast.controller;

import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户web层
 */
@Controller
@RequestMapping("user")
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @RequestMapping("/testSSM")
    public String testSSM(){
        return "success";
    }
}
