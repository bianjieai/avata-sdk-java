package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 设置域名解析接口请求体
 */
@NoArgsConstructor
@Data
public class ResolveDomainReq {

    @JSONField(name = "resolve_type")
    private Integer resolveType;// 域名解析类型 1：链账户 2：文本

    @JSONField(name = "addr")
    private AddrDTO addrDTO; // 链账户,resolve_type 为 1 时必填

    @JSONField(name = "text")
    private TextDTO textDTO; // 文本数据,resolve_type为 2 时必填

    @JSONField(name = "operation_id")
    private String operationId;// 保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成并自行维护、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串


    @NoArgsConstructor
    @Data
    public static class AddrDTO {

        @JSONField(name = "addr_value")
        private String addrValue; // 链账户地址，默认值为当前域名 owner

        @JSONField(name = "block_chain")
        private Integer blockChain;// 底层区块链 1000：天舟链  1001：天和链 1002: 神舟链 https://docs.ens.domains/ens-improvement-proposals/ensip-9-multichain-address-resolution
    }

    @NoArgsConstructor
    @Data
    public static class TextDTO {

        @JSONField(name = "key")
        private String key; //文本数据 key,key可选的标准值有：email(电子邮箱地址),url(网址),avatar(用作头像或标识的图像的网址),description(域名的描述信息),notice(关于域名的通知),keywords(逗号分隔的关键字列表，按重要性由高到低排列，与此字段有交互的客户端可以通过设置一个阈值来选择忽略哪些内容) https://learnblockchain.cn/docs/ens/contract-api-reference/publicresolver.html#%E8%8E%B7%E5%8F%96%E6%96%87%E6%9C%AC%E6%95%B0%E6%8D%AE

        @JSONField(name = "text_value")
        private String textValue; // 文本数据值
    }
}
