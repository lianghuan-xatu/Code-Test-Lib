package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController
{
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有员工，返回列表页面
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        //thymeleaf默认会拼串
        //classpath;/templates/
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //来到添加页面,查出所有部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";

    }

    //员工添加
    //SpringMvc自动将请求参数和入参对象的属性进行一一绑定；要求了请求参数的名字和JavaBean入参的对象里面的属性名一一对应
        @PostMapping("/emp")
        public String addEmp(Employee employee){
        employeeDao.save(employee);
            return "redirect:/emps";
    }
}
