package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IUserService;
import com.itheima.service.iml.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    IUserService userService=new UserServiceImpl();
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> all = userService.findAll();
        mv.addObject("usersList",all);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }


    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(value = "id",required = true) String userId){
        UserInfo user=userService.findById(userId);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
   public ModelAndView findUserByIdAndAllRole(String id){
        UserInfo userInfo = userService.findById(id);
        List<Role> roles = userService.findUserByIdAndAllRole(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }


/**
 * 为用户添加角色
 */
    @RequestMapping("/addRoleToUser")
    @Secured("ROLE_ADMIN")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll";
    }

}
