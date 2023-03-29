package ai.bianjie.avatasdk.model.account;

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
        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询
        @JSONField(name = "next_page_key")
        private String nextPageKey;//下一页数据的Key， Avata会根据该值进行下一页数据的查询
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
            @JSONField(name = "nft_msg")
            private DataDTO.OperationRecordsDTO.NftMsgDTO nftMsg;// 具体参考接口文档

            @NoArgsConstructor
            @Data
            public static class NftMsgDTO {
                /**
                 * 该字段实际不展示，仅展示内部数据
                 */
                @JSONField(name = "burn")
                private Burn burn;
                /**
                 * 该字段实际不展示，仅展示内部数据
                 */
                @JSONField(name = "edit")
                private Edit edit;
                /**
                 * 该字段实际不展示，仅展示内部数据
                 */
                @JSONField(name = "issue_class")
                private IssueClass issueClass;
                /**
                 * 该字段实际不展示，仅展示内部数据
                 */
                @JSONField(name = "mint")
                private Mint mint;
                /**
                 * 该字段实际不展示，仅展示内部数据
                 */
                @JSONField(name = "transfer")
                private Transfer transfer;
                /**
                 * 该字段实际不展示，仅展示内部数据
                 */
                @JSONField(name = "transfer_class")
                private TransferClass transferClass;
            }


            /**
             * 该字段实际不展示，仅展示内部数据
             */
            @lombok.Data
            @NoArgsConstructor
            public static class Burn {
                /**
                 * NFT 合约地址
                 */
                @JSONField(name = "class_id")
                private String classid;
                /**
                 * NFT 类别名称
                 */
                @JSONField(name = "class_name")
                private String className;
                /**
                 * NFT 类别标识
                 */
                @JSONField(name = "class_symbol")
                private String classSymbol;
                /**
                 * NFT ID
                 */
                @JSONField(name = "id")
                private String id;
                /**
                 * 链外数据链接 Hash
                 */
                @JSONField(name = "uri")
                private String uri;
                /**
                 * 接收者地址
                 */
                @JSONField(name = "uri_hash")
                private String uriHash;
            }


            /**
             * 该字段实际不展示，仅展示内部数据
             */
            @lombok.Data
            @NoArgsConstructor
            public static class Edit {
                /**
                 * NFT 合约地址
                 */
                private String classid;
                /**
                 * NFT 类别名称
                 */
                private String className;
                /**
                 * NFT 类别标识
                 */
                private String classSymbol;
                /**
                 * NFT ID
                 */
                private String id;
                /**
                 * 链外数据链接
                 */
                private String uri;
                /**
                 * 链外数据链接 Hash
                 */
                private String uriHash;
            }


            /**
             * 该字段实际不展示，仅展示内部数据
             */
            @lombok.Data
            @NoArgsConstructor
            public static class IssueClass {
                /**
                 * NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT  1：可编辑  0：不可编辑（默认）
                 */
                @JSONField(name = "editable_by_class_owner")
                private long editableByClassOwner;
                /**
                 * NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT  1：可编辑  0：不可编辑（默认）
                 */
                @JSONField(name = "editable_by_owner")
                private long editableByOwner;
                /**
                 * NFT 合约地址
                 */
                @JSONField(name = "id")
                private String id;
                /**
                 * NFT 类别名称
                 */
                @JSONField(name = "name")
                private String name;
                /**
                 * 接收者地址
                 */
                @JSONField(name = "recipient")
                private String recipient;
                /**
                 * NFT 类别标识
                 */
                @JSONField(name = "symbol")
                private String symbol;
                /**
                 * 链外数据链接
                 */
                @JSONField(name = "uri")
                private String uri;
                /**
                 * 链外数据链接 Hash
                 */
                @JSONField(name = "uri_hash")
                private String uriHash;
            }


            /**
             * 该字段实际不展示，仅展示内部数据
             */
            @lombok.Data
            @NoArgsConstructor
            public static class Mint {
                /**
                 * NFT 合约地址
                 */
                @JSONField(name = "class_id")
                private String classid;
                /**
                 * NFT 类别名称
                 */
                @JSONField(name = "class_name")
                private String className;
                /**
                 * NFT 类别标识
                 */
                @JSONField(name = "class_symbol")
                private String classSymbol;
                /**
                 * NFT ID
                 */
                @JSONField(name = "id")
                private String id;
                /**
                 * 接收者地址
                 */
                @JSONField(name = "recipient")
                private String recipient;
                /**
                 * 链外数据链接
                 */
                @JSONField(name = "uri")
                private String uri;
                /**
                 * 链外数据链接 Hash
                 */
                @JSONField(name = "uri_hash")
                private String uriHash;
            }


            /**
             * 该字段实际不展示，仅展示内部数据
             */
            @lombok.Data
            @NoArgsConstructor
            public static class Transfer {
                /**
                 * NFT 合约地址
                 */
                @JSONField(name = "class_id")
                private String classid;
                /**
                 * NFT 类别名称
                 */
                @JSONField(name = "class_name")
                private String className;
                /**
                 * NFT 类别标识
                 */
                @JSONField(name = "class_symbol")
                private String classSymbol;
                /**
                 * NFT ID
                 */
                @JSONField(name = "id")
                private String id;
                /**
                 * 接收者地址
                 */
                @JSONField(name = "recipient")
                private String recipient;
                /**
                 * 链外数据链接
                 */
                @JSONField(name = "uri")
                private String uri;
                /**
                 * 链外数据链接 Hash
                 */
                @JSONField(name = "uri_hash")
                private String uriHash;
            }


            /**
             * 该字段实际不展示，仅展示内部数据
             */
            @lombok.Data
            @NoArgsConstructor
            public static class TransferClass {
                /**
                 * NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT  1：可编辑  0：不可编辑（默认）
                 */
                @JSONField(name = "editable_by_class_owner")
                private long editableByClassOwner;
                /**
                 * NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT  1：可编辑  0：不可编辑（默认）
                 */
                @JSONField(name = "editable_by_owner")
                private long editableByOwner;
                /**
                 * NFT 合约地址
                 */
                @JSONField(name = "id")
                private String id;
                /**
                 * NFT 类别名称
                 */
                @JSONField(name = "name")
                private String name;
                /**
                 * 接收者地址
                 */
                @JSONField(name = "recipient")
                private String recipient;
                /**
                 * NFT 类别标识
                 */
                @JSONField(name = "symbol")
                private String symbol;
                /**
                 * 链外数据链接
                 */
                @JSONField(name = "uri")
                private String uri;
                /**
                 * 链外数据链接 Hash
                 */
                @JSONField(name = "uri_hash")
                private String uriHash;
            }

        }
    }
}
