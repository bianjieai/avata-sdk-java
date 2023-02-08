package proxy.order;

import model.order.*;

public interface OrderProxy {
    /**
     * 购买能量值/业务费
     *
     * @param req 购买能量值/业务费请求实体
     * @return
     */
    OrderRes CreateOrder(CreateOrderReq req);

    /**
     * 批量购买能量值
     *
     * @param req 批量购买能量值请求实体
     * @return
     */
    OrderRes BatchCreatrOrders(BatchCreateOrderReq req);

    /**
     * 查询能量值/业务费购买结果
     *
     * @param orderId Order ID
     * @return
     */
    QueryOrderRes QueryOrder(String orderId);

    /**
     * 查询能量值/业务费购买结果列表
     *
     * @param req 查询能量值/业务费购买结果列表请求实体
     * @return
     */
    QueryOrdersRes QueryOrders(QueryOrdersReq req);
}
