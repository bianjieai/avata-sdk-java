package ai.bianjie.avatasdk.proxy.order.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.order.*;
import ai.bianjie.avatasdk.proxy.order.OrderProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderClient implements OrderProxy {
    private static final String CREATE_ORDER = "/v2/orders";
    private static final String BATCH_CREATE_ORDER = "/v2/orders/batch";
    private static final String QUERY_ORDER = "/v2/orders/%s";
    private static final String QUERY_ORDERS = "/v2/orders";

    private ConfigInfo configInfo;

    public OrderClient(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }

    @Override
    public OrderRes createOrder(CreateOrderReq req) {
        log.debug("CreateOrderReq {}", req);
        log.debug("createOrder start");
        // check params
        if (StringUtils.isEmpty(req.getOrderId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "order_id"));
        }
        if (StringUtils.isEmpty(req.getAccount())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "account"));
        }
        if (StringUtils.isEmpty(req.getOrderType())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "order_type"));
        }
        if (req.getAmount() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "amount"));
        }
        if (req.getAmount() % 100 != 0) {
            throw AvataException.InvalidParamException(AvataException.ErrAmount);
        }
        ForestResponse response = HttpClient.Post(CREATE_ORDER, JSONObject.toJSONString(req), configInfo);

        String result = response.readAsString();

        OrderRes res = JSONObject.parseObject(result, OrderRes.class);

        log.debug("createOrder end");
        return res;
    }

    @Override
    public OrderRes batchCreateOrders(BatchCreateOrderReq req) {
        log.debug("BatchCreateOrderReq {}", req);
        log.debug("createClass start");
        // check params
        if (StringUtils.isEmpty(req.getOrderId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "order_id"));
        }
        if (req.getList() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "order_list"));
        }
        req.getList().forEach(l -> {
            if (StringUtils.isEmpty(l.getAccount())) {
                throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "account"));
            }
            if (l.getAmount() == null) {
                throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "amount"));
            }
            if (l.getAmount() % 100 != 0) {
                throw AvataException.InvalidParamException(AvataException.ErrAmount);
            }
        });

        ForestResponse response = HttpClient.Post(BATCH_CREATE_ORDER, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();

        OrderRes res = JSONObject.parseObject(result, OrderRes.class);

        log.debug("batchCreatrOrders end");
        return res;
    }

    @Override
    public QueryOrderRes queryOrder(String orderId) {
        log.debug("orderId {}", orderId);
        log.debug("createClass start");
        String path = String.format(QUERY_ORDER, orderId);
        ForestResponse response = HttpClient.Get(path, "", configInfo);
        String result = response.readAsString();

        QueryOrderRes res = JSONObject.parseObject(result, QueryOrderRes.class);

        log.debug("queryOrder end");
        return res;
    }

    @Override
    public QueryOrdersRes queryOrders(QueryOrdersReq req) {
        log.debug("QueryOrdersReq {}", req);
        log.debug("createClass start");
        ForestResponse response = HttpClient.Get(QUERY_ORDERS, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();

        QueryOrdersRes res = JSONObject.parseObject(result, QueryOrdersRes.class);

        log.debug("queryOrders end");
        return res;
    }
}
