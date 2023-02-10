package model.tx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 上链交易结果查询返回值
 *
 * 交易状态说明：
 * status 为 3（未处理），上链请求还在等待处理，请稍等；
 * status 为 0（处理中），上链请求正在处理，请等待处理完成；
 * status 为 1（成功），交易已上链并执行成功；
 * status 为 2（失败），说明该交易执行失败。请在业务侧做容错处理。可以参考接口返回的 message（交易失败的错误描述信息） 对 NFT / MT / 业务接口的请求参数做适当调整后，使用「新的 Operation ID 」重新发起 NFT / MT / 业务接口请求。
 */
@NoArgsConstructor
@Data
public class QueryTxRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "type")
        private String type;// 用户操作类型；Enum: "issue_class" "transfer_class" "mint_nft" "edit_nft" "burn_nft" "transfer_nft" "issue_class_mt" "transfer_class_mt" "issue_mt" "mint_mt" "edit_mt" "burn_mt" "transfer_mt" "mint_nft_batch" "edit_nft_batch" "burn_nft_batch" "transfer_nft_batch" "create_record"
        @JSONField(name = "module")
        private String module;// 交易模块；Enum: "nft" "mt" "record"
        @JSONField(name = "tx_hash")
        private String txHash;// 交易哈希
        @JSONField(name = "status")
        private Integer status;// 交易状态， 0 处理中； 1 成功； 2 失败； 3 未处理；Enum: 0 1 2 3
        @JSONField(name = "message")
        private String message;// 交易失败的错误描述信息
        @JSONField(name = "block_height")
        private Integer blockHeight;// 交易上链的区块高度
        @JSONField(name = "timestamp")
        private String timestamp;// 交易上链时间（UTC 时间）
        @JSONField(name = "nft")
        private Nft nft;// 具体参考接口文档
        @JSONField(name = "mt")
        private Mt mt;// 具体参考接口文档
        @JSONField(name = "record")
        private Record record;// 具体参考接口文档

        @NoArgsConstructor
        @Data
        public static class Nft {
            @JSONField(name = "class_id")
            private String classId;
            @JSONField(name = "nft_id")
            private String nftId;
        }

        @NoArgsConstructor
        @Data
        public static class Mt {
            @JSONField(name = "class_id")
            private String classId;
            @JSONField(name = "mt_id")
            private String mtId;
        }

        @NoArgsConstructor
        @Data
        public static class Record {
            @JSONField(name = "record_id")
            private String recordId;
            @JSONField(name = "certificate_url")
            private String certificateUrl;
        }
    }
}

