package Servlet;

import Service.ProvinceService;
import Service.impl.ProvinceServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProvinceServlet")
public class findProvinceServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
                //调用service查询
        ProvinceService provinceService=new ProvinceServiceImp();
      /*  List<Province> all = provinceService.findAll();
        //序列化list为json
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(all);*/
        String allJson = provinceService.findAllJson();

        System.out.println(allJson);
        //响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(allJson);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
