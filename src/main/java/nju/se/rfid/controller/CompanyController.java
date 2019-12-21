package nju.se.rfid.controller;

import nju.se.rfid.bean.Company;
import nju.se.rfid.mapper.CompanyMapper;
import org.apache.ibatis.annotations.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    CompanyMapper companyMapper;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    public List<Company> getAllCompanies(){
        List<Company> companies = companyMapper.getAllCompanies();
        for(Company c:companies){
            System.out.println(c.getCompanyId()+c.getCompanyName());
        }
        return companies;
    }

}
