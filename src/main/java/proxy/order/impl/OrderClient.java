package proxy.order.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.AvataException;
import model.BaseResponse;
import model.ErrorResponse;
import model.order.*;
import proxy.order.OrderProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

public class OrderClient implements OrderProxy {
    private static final String CREATE_ORDER = "/v1beta1/orders";
    private static final String BATCH_CREATE_ORDER = "/v1beta1/orders/batch";
    private static final String QUERY_ORDER = "/v1beta1/orders/%s";
    private static final String QUERY_ORDERS = "/v1beta1/orders";

    @Override
    public OrderRes CreateOrder(CreateOrderReq req) {
        // check params
        if (StringUtils.isEmpty(req.getOrderId())) {
            throw new AvataException(ErrorMessage.ORDER_ID_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getAccount())) {
            throw new AvataException(ErrorMessage.ACCOUNT_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOrderType())) {
            throw new AvataException(ErrorMessage.ORDER_TYPE_ERROR, null, null);
        }
        if (req.getAmount() == null) {
            throw new AvataException(ErrorMessage.AMOUNT_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(CREATE_ORDER, JSONObject.toJSONString(req));

        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        OrderRes res = JSONObject.parseObject(result, OrderRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public OrderRes BatchCreatrOrders(BatchCreateOrderReq req) {
        // check params
        if (StringUtils.isEmpty(req.getOrderId())) {
            throw new AvataException(ErrorMessage.ORDER_ID_ERROR, null, null);
        }
        if (req.getList() == null) {
            throw new AvataException(ErrorMessage.ORDER_LIST_ERROR, null, null);
        }
        req.getList().forEach(l -> {
            if (StringUtils.isEmpty(l.getAccount())) {
                throw new AvataException(ErrorMessage.ACCOUNT_ERROR, null, null);
            }
            if (l.getAmount() == null) {
                throw new AvataException(ErrorMessage.AMOUNT_ERROR, null, null);
            }
        });

        ForestResponse response = HttpClient.Post(BATCH_CREATE_ORDER, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        OrderRes res = JSONObject.parseObject(result, OrderRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryOrderRes QueryOrder(String orderId) {
        String path = String.format(QUERY_ORDER, orderId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryOrderRes res = JSONObject.parseObject(result, QueryOrderRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryOrdersRes QueryOrders(QueryOrdersReq req) {
        ForestResponse response = HttpClient.Get(QUERY_ORDERS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryOrdersRes res = JSONObject.parseObject(result, QueryOrdersRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
