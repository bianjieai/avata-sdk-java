import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void TestCreateAccount() {
        Client client = new Client.Builder()
                .setAvataGateway("")
                .setApiKey("")
                .setApiSecret("")
                .init();
        client.accountClient.createAccount();
    }
}
