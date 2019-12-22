package nju.se.rfid.service;

import nju.se.rfid.bean.Product;
import nju.se.rfid.bean.rfidInfo;
import org.springframework.core.annotation.Order;

public interface ProductService {
    void addProduct(rfidInfo rfidInfo);
}
