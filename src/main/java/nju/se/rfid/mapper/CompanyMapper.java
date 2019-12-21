package nju.se.rfid.mapper;

import nju.se.rfid.bean.Company;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CompanyMapper {
    public Company getCompanyById(Integer companyId);


    public Company getCompanyByName(String companyName);

    public List<Company> getAllCompanies();

}
