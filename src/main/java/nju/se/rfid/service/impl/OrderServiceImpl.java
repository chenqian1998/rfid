package nju.se.rfid.service.impl;

import nju.se.rfid.bean.rfidInfo;
import nju.se.rfid.common.CN9X.RfidDeviceUtil;
import nju.se.rfid.service.OrderService;
import nju.se.rfid.service.ProductService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public rfidInfo getProductInfo() {
        RfidDeviceUtil.setConnector("COM3",115200);

        String data = RfidDeviceUtil.read().replaceAll("00","").trim();
        rfidInfo rfidInfo = new rfidInfo();
        String[] dataArray = data.split(" ");

        // 转为十进制
        for (int i = 0;i < dataArray.length; i++){
            dataArray[i] = Integer.parseInt(dataArray[i],16)+"";
        }

        StringBuffer sb = new StringBuffer();
        sb.append(dataArray[0]).append(dataArray[1]).append("-").append(dataArray[2]).append("-").append(dataArray[3].charAt(0));
        rfidInfo.setCas_id(sb.toString());
        rfidInfo.setBatch_id(Integer.parseInt(sb.delete(0,sb.length()).append(dataArray[3].charAt(1)).toString()));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(dataArray[dataArray.length-2]));
        list.add(Integer.parseInt(dataArray[dataArray.length-1]));
        rfidInfo.setOperateInfo(list);

        return rfidInfo;

    }
}
