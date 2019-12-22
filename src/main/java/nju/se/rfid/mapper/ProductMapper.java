package nju.se.rfid.mapper;

import nju.se.rfid.bean.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {
    public Product getProductById(Integer id);

    public Product getProductByCasId(String casId);

    public void insertProduct(Product product);

}
