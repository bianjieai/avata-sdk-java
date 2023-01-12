import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.*;
import com.dtflys.forest.config.*;
import com.dtflys.forest.http.ForestAsyncMode;
import com.dtflys.forest.retryer.BackOffRetryer;
import com.dtflys.forest.ssl.SSLUtils;
import model.account.QueryAccountsHistoryReq;
import model.tx.QueryQueueResponse;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ForestTest {



    @Test
    public void get() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        req.setOffset("1");
        req.setLimit("2");
        req.setStartDate("2022-01-01");
        Map<String,Object> map = JSONObject.parseObject(JSONObject.toJSONString(req));
        System.out.println(map.toString());
//        QueryQueueResponse res = Forest.get("http://192.168.150.41:18081/v1beta1/tx/queue/info").addHeader("x-api-key","000001").execute(QueryQueueResponse.class);
//        System.out.println(res.getData());
    }

    @Test
    public void post() {

    }
}
