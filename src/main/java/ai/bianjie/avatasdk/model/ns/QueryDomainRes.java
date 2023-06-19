package ai.bianjie.avatasdk.model.ns;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询域名接口正确返回值
 */
@NoArgsConstructor
@Data
public class QueryDomainRes {

    @JSONField(name = "data")
    private dataDTO data;

    @NoArgsConstructor
    @Data
    public static class dataDTO {
        @JSONField(name = "domains")
        private List<DomainsDTO> domainsDTO;
    }

    @NoArgsConstructor
    @Data
    public static class DomainsDTO {

        @JSONField(name = "name")
        private String name;// 一级域名 ：如 test.wallet

        @JSONField(name = "status")
        private Integer status;// 当前域名状态 0 ：未注册； 1： 已注册； 2： 不符合规则

        @JSONField(name = "owner")
        private String owner;// 当前域名拥有者的链账户地址

        @JSONField(name = "expire")
        private Integer expire;// 过期状态： 0：未过期；1：已过期

        @JSONField(name = "expire_timestamp")
        private String expireTimestamp;// 当前域名过期时间戳

        @JSONField(name = "msg")
        private String msg;// 提示信息
    }
}
