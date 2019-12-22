package nju.se.rfid.service.impl;

import nju.se.rfid.bean.Product;
import nju.se.rfid.bean.rfidInfo;
import nju.se.rfid.common.CN9X.RfidDeviceUtil;
import nju.se.rfid.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(rfidInfo rfidInfo) {
        //设置连接器
        RfidDeviceUtil.setConnector("COM3",115200);

        Map<String,String> map = new HashMap();
        map.put("batch_id",rfidInfo.getBatch_id()+"");
        map.put("cas_id",rfidInfo.getCas_id());
        map.put("company_id",rfidInfo.getOperateInfo().get(0)+"");
        map.put("weight",rfidInfo.getOperateInfo().get(1)+"");
        RfidDeviceUtil.write(map,"01",6);
    }
}
