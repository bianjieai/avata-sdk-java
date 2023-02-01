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
        Map<String, Object> map = JSONObject.parseObject(JSONObject.toJSONString(req));
        System.out.println(map.toString());

    }

    @Test
    public void post() {

    }

    @Test
    public void stringFormat() {
        String str = "/v1beta1/mt/classes/%s/%s/history";
        String path = String.format(str, "sjdkfljasl", "mtId");
        System.out.println(path);
    }
}
