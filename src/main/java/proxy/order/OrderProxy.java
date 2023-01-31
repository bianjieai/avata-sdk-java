package proxy.order;

import model.PublicResponse;
import model.order.*;

public interface OrderProxy {
    /**
     * 购买能量值/业务费
     *
     * @return
     */
    PublicOrderRes CreatrOrder(CreateOrderReq req);

    /**
     * 批量购买能量值
     *
     * @return
     */
    PublicOrderRes BatchCreatrOrders(BatchCreateOrdersReq req);

    /**
     * 查询能量值/业务费购买结果
     *
     * @return
     */
    QueryOrderRes QueryOrder(QueryOrderReq req, String orderId);

    /**
     * 查询能量值/业务费购买结果列表
     *
     * @return
     */
    QueryOrdersRes QueryOrders(QueryOrdersReq req);
}
