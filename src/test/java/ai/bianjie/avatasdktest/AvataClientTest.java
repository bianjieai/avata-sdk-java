package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.AvataClient;

public class AvataClientTest {

    public static  AvataClient getAvataClient() {
        return new AvataClient.Builder()
                .setDomain("域名，不同环境对应不同的域名，如测试环境: https://stage.apis.avata.bianjie.ai")
                .setApiKey("项目参数 API KEY")
                .setApiSecret("项目参数 API SECRET")
                .setHttpTimeout(10000)
                .init();
    }
}
