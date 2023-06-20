package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询链账户操作记录正确返回值
 */
@NoArgsConstructor
@Data
public class QueryAccountsHistoryRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "next_page_key")
        private String nextPageKey;// 下一页数据的Key， Avata会根据该值进行上一页数据的查询

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
            private Integer module;// 功能模块；Enum: "nft"

            @JSONField(name = "operation")
            private Integer operation;// 操作类型： module = 1 时： 1：issue_class； 2：transfer_class 3：mint； 4：edit； 5：transfer； 6：burn；

            @JSONField(name = "signer")
            private String signer;// Tx 签名者地址

            @JSONField(name = "timestamp")
            private String timestamp;// 操作时间戳（UTC 时间）

            @JSONField(name = "nft_msg")
            private String nftMsg;// 具体参考接口文档
//            @NoArgsConstructor
//            @Data
//            public static class NftMsgDTO {
//
//                @JSONField(name = "issue_class")
//                private IssueClassDTO IssueClass; //该字段实际不返回
//
//                @JSONField(name = "transfer_class")
//                private TransferclassDTO Transferclass; //该字段实际不返回
//
//                @JSONField(name = "mint")
//                private MintDTO mint; //该字段实际不返回
//
//                @JSONField(name = "edit")
//                private EditDTO Edit; //该字段实际不返回
//
//                @JSONField(name = "transfer")
//                private TransferDTO Transfer; //该字段实际不返回
//
//                @JSONField(name = "burn")
//                private BurnDTO Burn; //该字段实际不返回
//            }
//
//            public static class IssueClassDTO {
//
//                @JSONField(name = "id")
//                private String id; // NFT 合约地址
//
//                @JSONField(name = "name")
//                private String name; // NFT 类别名称
//
//                @JSONField(name = "uri")
//                private String uri; // 链外数据链接
//
//                @JSONField(name = "uri_hash")
//                private String uriHash; // 链外数据链接 Hash
//
//                @JSONField(name = "symbol")
//                private String symbol; // NFT 类别标识
//
//                @JSONField(name = "editable_by_owner")
//                private Integer editableByOwner; // NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT 1：可编辑 0：不可编辑（默认）
//
//                @JSONField(name = "editable_by_class_owner")
//                private Integer editableByClassOwner; // NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT 1：可编辑 0：不可编辑（默认）
//
//                @JSONField(name = "recipient")
//                private String recipient; // 接收者地址
//            }
//
//            public static class TransferclassDTO {
//
//                @JSONField(name = "id")
//                private String id; // NFT 合约地址
//
//                @JSONField(name = "name")
//                private String name; // NFT 类别名称
//
//                @JSONField(name = "uri")
//                private String uri; // 链外数据链接
//
//                @JSONField(name = "uri_hash")
//                private String uriHash; // 链外数据链接 Hash
//
//                @JSONField(name = "symbol")
//                private String symbol; // NFT 类别标识
//
//                @JSONField(name = "editable_by_owner")
//                private Integer editableByOwner; // NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT 1：可编辑 0：不可编辑（默认）
//
//                @JSONField(name = "editable_by_class_owner")
//                private Integer editableByClassOwner; // NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT 1：可编辑 0：不可编辑（默认）
//
//                @JSONField(name = "recipient")
//                private String recipient; // 接收者地址
//            }
//
//            public static class MintDTO {
//
//                @JSONField(name = "id")
//                private Integer id; // NFT ID
//
//                @JSONField(name = "class_id")
//                private String classId; // NFT 合约地址
//
//                @JSONField(name = "class_name")
//                private String className; // NFT 类别名称
//
//                @JSONField(name = "class_symbol")
//                private String classSymbol; // NFT 类别标识
//
//                @JSONField(name = "uri")
//                private String uri; // 链外数据链接
//
//                @JSONField(name = "uri_hash")
//                private String uriHash; // 链外数据链接 Hash
//
//                @JSONField(name = "recipient")
//                private String recipient; // 接收者地址
//            }
//
//            public static class EditDTO {
//
//                @JSONField(name = "id")
//                private Integer id; // NFT ID
//
//                @JSONField(name = "class_id")
//                private String classId; // NFT 合约地址
//
//                @JSONField(name = "class_name")
//                private String className; // NFT 类别名称
//
//                @JSONField(name = "class_symbol")
//                private String classSymbol; // NFT 类别标识
//
//                @JSONField(name = "uri")
//                private String uri; // 链外数据链接
//
//                @JSONField(name = "uri_hash")
//                private String uriHash; // 链外数据链接 Hash
//            }
//
//            public static class TransferDTO {
//
//                @JSONField(name = "id")
//                private Integer id; // NFT ID
//
//                @JSONField(name = "class_id")
//                private String classId; // NFT 合约地址
//
//                @JSONField(name = "class_name")
//                private String className; // NFT 类别名称
//
//                @JSONField(name = "class_symbol")
//                private String classSymbol; // NFT 类别标识
//
//                @JSONField(name = "uri")
//                private String uri; // 链外数据链接
//
//                @JSONField(name = "uri_hash")
//                private String uriHash; // 链外数据链接 Hash
//
//                @JSONField(name = "recipient")
//                private String recipient; // 接收者地址
//            }
//
//            public static class BurnDTO {
//
//                @JSONField(name = "id")
//                private Integer id; // NFT ID
//
//                @JSONField(name = "class_id")
//                private String classId; // NFT 合约地址
//
//                @JSONField(name = "class_name")
//                private String className; // NFT 类别名称
//
//                @JSONField(name = "class_symbol")
//                private String classSymbol; // NFT 类别标识
//
//                @JSONField(name = "uri")
//                private String uri; // 链外数据链接
//
//                @JSONField(name = "uri_hash")
//                private String uriHash; // 链外数据链接 Hash
//            }
        }
    }
}
