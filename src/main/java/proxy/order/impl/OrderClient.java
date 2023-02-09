package proxy.order.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import model.BaseResponse;
import model.order.*;
import proxy.order.OrderProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

@Slf4j
public class OrderClient implements OrderProxy {
    private static final String CREATE_ORDER = "/v1beta1/orders";
    private static final String BATCH_CREATE_ORDER = "/v1beta1/orders/batch";
    private static final String QUERY_ORDER = "/v1beta1/orders/%s";
    private static final String QUERY_ORDERS = "/v1beta1/orders";

    @Override
    public OrderRes createOrder(CreateOrderReq req) {
        log.debug("CreateOrderReq {}", req);
        log.info("createOrder start");
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
        if (req.getAmount()%100 != 0){
            throw AvataException.InvalidParamException(AvataException.ErrAmount);
        }
        ForestResponse response = HttpClient.Post(CREATE_ORDER, JSONObject.toJSONString(req));

        String result = response.readAsString();
        
        OrderRes res = JSONObject.parseObject(result, OrderRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("createOrder end");
        return res;
    }

    @Override
    public OrderRes batchCreateOrders(BatchCreateOrderReq req) {
        log.debug("BatchCreateOrderReq {}", req);
        log.info("createClass start");
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
            if (l.getAmount()%100 != 0) {
                throw AvataException.InvalidParamException(AvataException.ErrAmount);
            }
        });

        ForestResponse response = HttpClient.Post(BATCH_CREATE_ORDER, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        OrderRes res = JSONObject.parseObject(result, OrderRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("batchCreatrOrders end");
        return res;
    }

    @Override
    public QueryOrderRes queryOrder(String orderId) {
        log.debug("orderId {}", orderId);
        log.info("createClass start");
        String path = String.format(QUERY_ORDER, orderId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        
        QueryOrderRes res = JSONObject.parseObject(result, QueryOrderRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryOrder end");
        return res;
    }

    @Override
    public QueryOrdersRes queryOrders(QueryOrdersReq req) {
        log.debug("QueryOrdersReq {}", req);
        log.info("createClass start");
        ForestResponse response = HttpClient.Get(QUERY_ORDERS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryOrdersRes res = JSONObject.parseObject(result, QueryOrdersRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryOrders end");
        return res;
    }
}
