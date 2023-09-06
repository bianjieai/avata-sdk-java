package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallBackUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static ai.bianjie.avatasdk.util.CallBackUtils.APIVersionV1;

public class CallBackTest {
    public void callBack(HttpServletRequest r) throws IOException {
        String result = CallBackUtils.onCallback(APIVersionV1, "", null, r, new CallBackUtils.APP() {
            @Override
            public void app(HttpServletRequest r, String version, String apiSecret, String path) {
                System.out.println(version);
                System.out.println(apiSecret);
                System.out.println(path);
                System.out.println(r.getHeader("X-Signature"));
                System.out.println(r.getHeader("X-Timestamp"));
            }
        });
        System.out.println(result);
    }
}


