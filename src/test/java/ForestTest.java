import com.alibaba.fastjson.JSONObject;
import model.account.QueryAccountsHistoryReq;
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
