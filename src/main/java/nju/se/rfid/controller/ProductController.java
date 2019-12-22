package nju.se.rfid.controller;

import nju.se.rfid.bean.Company;
import nju.se.rfid.bean.Product;
import nju.se.rfid.mapper.CompanyMapper;
import nju.se.rfid.mapper.ProductMapper;
import nju.se.rfid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    @Autowired
    ProductMapper productMapper;

    @Resource
    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    private ProductService productService;

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
    public String addProduct(Product product){
        System.out.println("=================");
        System.out.println("输出添加的药物信息："+product);
        System.out.println("=================");
        productMapper.insertProduct(product);
        productService.addProduct(product);
        return "main.html";
    }


}
