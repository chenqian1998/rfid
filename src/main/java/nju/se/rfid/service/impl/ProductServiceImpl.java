package nju.se.rfid.service.impl;

import com.module.interaction.ReaderHelper;
import nju.se.rfid.bean.Product;
import nju.se.rfid.common.CN9X.RfidDeviceUtil;
import nju.se.rfid.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(Product product) {
        Map<String,String> map = new HashMap();
        map.put("batch_id",product.getBatchId()+"");
        map.put("cas_id",product.getBatchId()+"");
        map.put("company_id",product.getCompanyId()+"");
        map.put("cas_id",product.getBatchId()+"");

    }
}
