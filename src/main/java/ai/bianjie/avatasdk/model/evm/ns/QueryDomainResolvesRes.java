package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询域名解析接口正确返回值
 */
@NoArgsConstructor
@Data
public class QueryDomainResolvesRes {


    @JSONField(name = "data")
    private dataDTO data;

    @NoArgsConstructor
    @Data
    public static class dataDTO {


        @JSONField(name = "addrs")
        private List<AddrsDTO> addrsDTO; // 链账户,resolve_type 为 1 时必填

        @JSONField(name = "texts")
        private List<TextsDTO> textsDTO; // 文本数据,resolve_type为 2 时必填
    }
    @NoArgsConstructor
    @Data
    public static class AddrsDTO {

        @JSONField(name = "block_chain")
        private Integer blockChain;// 地址链类型

        @JSONField(name = "addr_value")
        private String addrValue; // 链账户地址
    }

    @NoArgsConstructor
    @Data
    public static class TextsDTO {

        @JSONField(name = "key")
        private String key; // 内容 key

        @JSONField(name = "text_value")
        private String textValue; // 内容 value
    }
}