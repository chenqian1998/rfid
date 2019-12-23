package nju.se.rfid.controller;

import nju.se.rfid.bean.Company;
import nju.se.rfid.bean.Orders;
import nju.se.rfid.bean.Product;
import nju.se.rfid.bean.rfidInfo;
import nju.se.rfid.mapper.CompanyMapper;
import nju.se.rfid.mapper.OrdersMapper;
import nju.se.rfid.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrdersController {
    @Resource
    @Autowired
    OrdersMapper ordersMapper;

    @Resource
    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    OrderService orderService;

    public List<Company> getAllCompanies(){
        List<Company> companies = companyMapper.getAllCompanies();
        return companies;
    }

    public List<Orders> getOrdersByCompanyId(Integer id){
        return ordersMapper.getOrdersByCompanyId(id);
    }


    public void printAllOrders(){
        List<Orders> ordersList = ordersMapper.getOrdersByProductId(1);
        for(Orders o : ordersList){
            System.out.println(o);
        }
    }


    // 跳转页面
    @GetMapping("/orders")
    public String toReceivePage(Model model){
        List<Company> companies = getAllCompanies();
        model.addAttribute("companies",companies);
        return "orders/receive";
    }

    //提交这个接收信息
    @PostMapping("/orders")
    public String addOrders(Orders orders, Model model, HttpSession session){
        System.out.println("=================");
        System.out.println("输出添加的药物信息："+orders);
        System.out.println("=================");
        ordersMapper.insertOrders(orders);
        System.out.println("插入："+orders);

        Integer companyId = (Integer) session.getAttribute("companyId");
        List<Orders> ordersList = getOrdersByCompanyId(companyId);
        model.addAttribute("ordersList",ordersList);
        return "/main.html";
    }

    @GetMapping("/send")
    public String toSendPage(Model model){
        List<Company> companies = getAllCompanies();

        //读取到RFID里面的信息
//        rfidInfo rfidInfo = getProductInfo();
        //rfidInfo rfidInfo = orderService.getProductInfo();

        //model.addAttribute("rfidInfo",rfidInfo);
        model.addAttribute("companies",companies);
        return "orders/send";
    }

    @PostMapping("/send")
    public String sendOrders(Orders orders,Model model, HttpSession session){
        Integer companyId = (Integer) session.getAttribute("companyId");
        List<Orders> ordersList = getOrdersByCompanyId(companyId);
        model.addAttribute("ordersList",ordersList);

        ordersMapper.insertOrders(orders);
        return "/main.html";
    }


    public rfidInfo getProductInfo(){
        //  这个需要调用软件接口这个需要调用软件接口
        // 得到：cas_id、batch_id、【公司编号、weight】*n
        // rfidInfo
        return new rfidInfo();

    }

    @RequestMapping(value = "/orders/getRfidInfo")
    @ResponseBody
    public Object getRfidInfo(){
        HashMap<Object,Object> map = new HashMap<>(1);
        rfidInfo rfidInfo = orderService.getProductInfo();
        map.put("casId",rfidInfo.getCas_id());
        map.put("weight",rfidInfo.getOperateInfo().get(1));
        return map;
    }




}
