package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountsHistoryRes {


    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;// 游标
        @JSONField(name = "limit")
        private Integer limit;// 每页记录数
        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数
        @JSONField(name = "operation_records")
        private List<OperationRecordsDTO> operationRecords;// 操作记录列表

        @NoArgsConstructor
        @Data
        public static class OperationRecordsDTO {
            @JSONField(name = "tx_hash")
            private String txHash;// 操作 Tx Hash
            @JSONField(name = "module")
            private String module;// 功能模块；Enum: "nft" "mt"
            @JSONField(name = "operation")
            private String operation;// 操作类型；Enum: "issue_class" "transfer_class" "mint" "edit" "transfer" "burn" "issue"
            @JSONField(name = "signer")
            private String signer;// Tx 签名者地址
            @JSONField(name = "timestamp")
            private String timestamp;// 操作时间戳（UTC 时间）
            @JSONField(name = "gas_fee")
            private Integer gasFee;// 链上交易消耗的能量值；当前支持查询 2022 年 08 月 18 日 11:00:00(UTC 时间) 底层链升级固定 Gas 之后的数据，其它历史数据已归档，暂不支持查询对应结果
            @JSONField(name = "business_fee")
            private Integer businessFee;// 链上交易消耗的业务费
            @JSONField(name = "nft_msg")
            private DataDTO.OperationRecordsDTO.NftMsgDTO nftMsg;// 具体参考接口文档
            @JSONField(name = "mt_msg")
            private DataDTO.OperationRecordsDTO.MtMsgDTO mtMsg;// 具体参考接口文档

            @NoArgsConstructor
            @Data
            public static class NftMsgDTO {
                @JSONField(name = "id")
                private String id;
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "class_id")
                private String classId;
                @JSONField(name = "class_name")
                private String className;
                @JSONField(name = "class_symbol")
                private String classSymbol;
                @JSONField(name = "symbol")
                private String symbol;
                @JSONField(name = "uri")
                private String uri;
                @JSONField(name = "recipient")
                private String recipient;
            }

            @NoArgsConstructor
            @Data
            public static class MtMsgDTO {
                @JSONField(name = "id")
                private String id;
                @JSONField(name = "class_id")
                private String classId;
                @JSONField(name = "class_name")
                private String className;
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "recipient")
                private String recipient;
                @JSONField(name = "amount")
                private Integer amount;
            }
        }
    }
}
