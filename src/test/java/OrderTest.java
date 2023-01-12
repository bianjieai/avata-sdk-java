import model.account.CreateAccountReq;
import model.account.CreateAccountRes;
import model.order.CreateOrderReq;
import model.order.PublicOrderRes;
import org.junit.jupiter.api.Test;

public class OrderTest {
    Client client = new Client.Builder()
            .setDoMain("http://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("ceshi")
            .init();

    @Test
    void TestCreateOrder() {
        CreateOrderReq req = new CreateOrderReq();
        req.setOrderId("sxjtestorderid001");
        req.setAccount("account");
        req.setAmount(100);
        req.setOrderType("gas");// todo 提供枚举
        try {
            PublicOrderRes res = client.orderClient.CreatrOrder(req);
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
