import com.alibaba.fastjson.JSONObject;
import model.account.AccountResponse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AccountTest {
    @Test
    void TestCreateAccount() {
        Client client = new Client.Builder()
                .setDoMain("http://192.168.150.41:18081")
                .setApiKey("000001")
                .setApiSecret("ceshi")
                .init();
        try {
            AccountResponse account = client.accountClient.createAccount("sxjtest", "sxjcreateaccount004");
            System.out.println(account.getData());
            System.out.println("no exception");
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("exception");
        }
    }
}
