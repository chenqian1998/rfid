package nju.se.rfid.controller;

import nju.se.rfid.bean.Company;
import nju.se.rfid.bean.Orders;
import nju.se.rfid.bean.Product;
import nju.se.rfid.bean.rfidInfo;
import nju.se.rfid.mapper.CompanyMapper;
import nju.se.rfid.mapper.OrdersMapper;
import nju.se.rfid.mapper.ProductMapper;
import nju.se.rfid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.relational.core.sql.In;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    @Autowired
    ProductMapper productMapper;

    @Resource
    @Autowired
    CompanyMapper companyMapper;

    @Resource
    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    ProductService productService;

    public List<Company> getAllCompanies(){
        List<Company> companies = companyMapper.getAllCompanies();
        return companies;
    }

    // 跳转到添加商品页面
    @GetMapping("/product")
    public String toAddPage(Model model, HttpSession session){
        List<Company> companies = getAllCompanies();
        model.addAttribute("companies",companies);
        return "products/add";
    }

    //添加商品页面
    @PostMapping("/product")
    public String addProduct(Product product,double weight){
        System.out.println("=================");
        System.out.println("输出添加的药物信息："+product);
        System.out.println("=================");
        System.out.println(product.getCasId()+"   "+weight);
        productMapper.insertProduct(product);

        //通过cas_id查询该商品的product_id
        String cas_id = product.getCasId();
        Product p = productMapper.getProductByCasId(cas_id);

        Orders orderAdd = new Orders();
        orderAdd.setProductId(p.getProductId());
        orderAdd.setWeight(weight);
        orderAdd.setCreateDate(p.getCreateDate());
        orderAdd.setStatus(0);
        orderAdd.setCreateCompany(p.getCompanyId());

        ordersMapper.insertOrders(orderAdd);

        // rfid设备写入数据
        rfidInfo rfidInfo = new rfidInfo();
        rfidInfo.setBatch_id(p.getBatchId());
        rfidInfo.setCas_id(p.getCasId());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(p.getCompanyId());
        list.add(orderAdd.getWeight().intValue());
        rfidInfo.setOperateInfo(list);
        productService.addProduct(rfidInfo);
        return "main.html";
    }

    @GetMapping("/test")
    public String test(){
        // 通过cas_id查询该商品的product_id
        String cas_id = "2222-22-2";
        Product p = productMapper.getProductByCasId(cas_id);
        System.out.println(p);
        return "test";
    }
}
