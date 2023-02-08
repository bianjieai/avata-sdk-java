import model.order.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    @Test
        //请求购买能量值/业务费接口示例
    void TestCreateOrder() {
        CreateOrderReq req = new CreateOrderReq();
        req.setOrderId("sxjtesto_rde2rid0w2");
        req.setAccount("iaa1d3fmeputf2h3takuyz68sl42v3r5s3szdx8y80");
        req.setAmount(100);
        req.setOrderType("gas");
        try {
            OrderRes res = client.orderClient.CreateOrder(req);
            System.out.println(res.getData().getOrderId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询能量值/业务费购买结果接口示例
    void TestQueryOrder() {
        try {
            QueryOrderRes res = client.orderClient.QueryOrder("sxjtesto_rde2rid0w2");
            System.out.println(res.getData());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询能量值/业务费购买结果列表接口示例
    void TestQueryOrders() {
        QueryOrdersReq req = new QueryOrdersReq();
        req.setStatus("success");
        try {
            QueryOrdersRes res = client.orderClient.QueryOrders(req);
            System.out.println(res.getData());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求批量购买能量值接口示例
    void TestBatchCreatrOrders() {
        BatchCreateOrderReq req = new BatchCreateOrderReq();
        List<BatchCreateOrderReq.ListDTO> list = new ArrayList<>();
        BatchCreateOrderReq.ListDTO dto1 = new BatchCreateOrderReq.ListDTO();
        dto1.setAccount("iaa1d3fmeputf2h3takuyz68sl42v3r5s3szdx8y80");
        dto1.setAmount(200);
        list.add(dto1);
        req.setList(list);
        req.setOrderId("gaisbc3_b1627");
        try {
            OrderRes res = client.orderClient.BatchCreatrOrders(req);
            System.out.println(res.getData().getOrderId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
