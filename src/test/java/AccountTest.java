import model.account.AccountResponse;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void TestCreateAccount() {
        Client client = new Client.Builder()
                .setAvataGateway("http://192.168.150.41:18081")
                .setApiKey("000001")
                .setApiSecret("ceshi")
                .init();
        AccountResponse account = client.accountClient.createAccount("lmhtestsdk", "lmhtestsdkaccount");
        System.out.println("");
    }
}
