import model.account.CreateAccountRes;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void TestCreateAccount() {
        Client client = new Client.Builder()
                .setAvataGateway("")
                .setApiKey("")
                .setApiSecret("")
                .init();
        CreateAccountRes account = client.accountClient.createAccount("", "");
        System.out.println("");
    }
}
