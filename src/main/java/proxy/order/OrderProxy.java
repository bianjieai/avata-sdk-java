package proxy.order;

import model.PublicResponse;
import model.order.*;

public interface OrderProxy {
    PublicOrderRes CreatrOrder(CreateOrderReq req);

    PublicOrderRes BatchCreatrOrders(BatchCreateOrdersReq req);

    QueryOrderRes QueryOrder(QueryOrderReq req, String orderId);

    QueryOrdersRes QueryOrders(QueryOrdersReq req);
}
