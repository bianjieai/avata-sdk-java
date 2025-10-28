package ai.bianjie.avatasdk.proxy.order;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.order.*;

public interface OrderProxy {
    /**
     * 购买能量值
     *
     * @param req 购买能量值请求实体
     * @return
     */
    PublicResponse createOrder(CreateOrderReq req);

    /**
     * 批量购买能量值
     *
     * @param req 批量购买能量值请求实体
     * @return
     */
    PublicResponse batchCreateOrders(BatchCreateOrderReq req);

    /**
     * 查询能量值购买结果
     *
     * @param operationId 操作id
     * @return
     */
    QueryOrderRes queryOrder(String operationId);

    /**
     * 查询能量值购买结果列表
     *
     * @param req 查询能量值购买结果列表请求实体
     * @return
     */
    QueryOrdersRes queryOrders(QueryOrdersReq req);
}
