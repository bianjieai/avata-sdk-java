package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.AvataClient;

public class AvataClientTest {

    public static  AvataClient getAvataClient() {
        return new AvataClient.Builder()
                .setDomain("")
                .setApiKey("")
                .setApiSecret("")
                .setHttpTimeout(10000)
                .init();
    }
}
