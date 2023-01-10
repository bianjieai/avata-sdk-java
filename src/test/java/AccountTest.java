import model.account.AccountResponse;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void TestCreateAccount() {
        Client client = new Client.Builder()
                .setDoMain("")
                .setApiKey("")
                .setApiSecret("")
                .init();
        AccountResponse account = client.accountClient.createAccount("", "");
        System.out.println("");
    }
}
