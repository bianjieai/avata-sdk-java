package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量编辑 NFT ：request
 */
@NoArgsConstructor
@Data
public class BatchEditNftReq {
    @JSONField(name = "nfts")
    private List<NftsDTO> nfts;

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串

    @NoArgsConstructor
    @Data
    public static class NftsDTO {
        @JSONField(name = "class_id")
        private String classId;// NFT 类别 ID
        @JSONField(name = "nft_id")
        private String nftId;// NFT ID
        @JSONField(name = "name")
        private String name;// NFT 名称
        @JSONField(name = "uri")
        private String uri;// 链外数据链接
        @JSONField(name = "data")
        private String data;// 自定义链上元数据
    }
}
