package nju.se.rfid.mapper;

import nju.se.rfid.bean.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    public List<Orders> getOrdersByProductId(Integer id);

    public void insertOrders(Orders orders);
}
