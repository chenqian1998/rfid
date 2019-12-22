package nju.se.rfid.controller;

import nju.se.rfid.bean.Company;
import nju.se.rfid.bean.Orders;
import nju.se.rfid.mapper.CompanyMapper;
import nju.se.rfid.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    @Autowired
    OrdersMapper ordersMapper;

    @Resource
    @Autowired
    CompanyMapper companyMapper;


    public List<Orders> getOrdersByCompanyId(Integer id){
        return ordersMapper.getOrdersByCompanyId(id);
    }

    public Integer getCompanyId(String name){
        Company company =  companyMapper.getCompanyByName(name);
        return company.getCompanyId();
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session,
                        Model model){

        // 登陆：company_name + 123456(默认密码）
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            // loginUser代表这个公司的name
            session.setAttribute("companyName",username);
            System.out.println(username);

            // 找到对应的companyId
            Integer companyId = getCompanyId(username);
            session.setAttribute("companyId",companyId);

            // 通过companyID查询到有关的记录
            List<Orders> ordersList = getOrdersByCompanyId(companyId);
            model.addAttribute("ordersList",ordersList);

            return "/main.html";
        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }

    }


    @GetMapping("/success.html")
    public String index(Model model,HttpSession session){
        Integer companyId = (Integer) session.getAttribute("companyId");
        List<Orders> ordersList = getOrdersByCompanyId(companyId);
        model.addAttribute("ordersList",ordersList);
        return "main";
    }


}
