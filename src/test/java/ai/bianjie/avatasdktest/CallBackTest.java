package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallBackUtils;
import org.junit.jupiter.api.Test;

public class CallBackTest {

    @Test
    public String callBack() {
        // 应用方业务逻辑请写在 businessFunction() 匿名内部类中
        CallBackUtils.callBackV1("", "", "", new CallBackUtils.business() {
            @Override
            public void businessFunction() {
                System.out.println("");
            }
        });
        return "SUCCESS";
    }

}
