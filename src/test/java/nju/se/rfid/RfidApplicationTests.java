package nju.se.rfid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class RfidApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception{
        System.out.println("获取数据库连接为："+dataSource.getConnection());
    }

    @Test
    void test() throws Exception{
        System.out.println("获取数据库连接为："+dataSource.getConnection());
    }

}
