package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }
    @Test
        //请求购买能量值接口示例
    void TestCreateOrder() {
        CreateOrderReq req = new CreateOrderReq();
        req.setAccount("");
        req.setAmount(100);
        req.setOrderType(1);
        req.setOperationId("buygas");
        try {
            PublicResponse res = client.order.createOrder(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询能量值/业务费购买结果接口示例
    void TestQueryOrder() {
        try {
            QueryOrderRes res = client.order.queryOrder(
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询能量值购买结果列表接口示例
    void TestQueryOrders() {
        QueryOrdersReq req = new QueryOrdersReq();
        req.setPageKey("");
        req.setLimit("1");
        req.setStatus("2");
        req.setStartDate("2023-04-26");
        //req.setEndDate("");
        //req.setSortBy("");
        req.setCountTotal("1");
        try {
            QueryOrdersRes res = client.order.queryOrders(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
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
        dto1.setAccount("");
        dto1.setAmount(100);
        list.add(dto1);

        BatchCreateOrderReq.ListDTO dto2 = new BatchCreateOrderReq.ListDTO();
        dto2.setAccount("");
        dto2.setAmount(100);
        list.add(dto2);

        req.setList(list);
        req.setOperationId("batchcreateorder");
        try {
            PublicResponse res = client.order.batchCreateOrders(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
