package ai.bianjie.avatasdk.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class onCallbackRes {

    // 验证签名时传入的 API 版本号
    public static final String APIVersionV1 = "v1"; // V1 版本 AVATA Open API
    public static final String APIVersionsOther = "";// 其它版本 AVATA Open API

    // 区分调用不同服务模块的接口
    public static final String Native = "native";
    public static final String EVM = "evm";

    // OnCallbackResV1 AVATA Open API V1 版本回调服务参数
    @Data
    @NoArgsConstructor
    public static class onCallbackResV1 {

        @JSONField(name = "operation_id")
        private String operationId;// 操作 ID

        @JSONField(name = "module")
        private String module;// 交易模块

        @JSONField(name = "type")
        private String type;// 用户操作类型

        @JSONField(name = "status")
        private Integer status;// 交易状态，1 成功; 2 失败

        @JSONField(name = "tx_hash")
        private String txHash;// 交易哈希

        @JSONField(name = "message")
        private String message;// 交易失败的错误描述信息

        @JSONField(name = "block_height")
        private Integer blockHeight;// 交易上链的区块高度

        @JSONField(name = "timestamp")
        private String timestamp;// 交易上链时间（UTC 时间）

        @JSONField(name = "nft")
        private String nft;//对应不同操作类型的消息体

        @JSONField(name = "mt")
        private String mt;// 对应不同操作类型的消息体

        @JSONField(name = "record")
        private String record;// 对应不同操作类型的消息体
    }


    @Data
    @NoArgsConstructor
    public static class onCallbackResNative {

        @JSONField(name = "kind")
        private String kind;// 区分服务，native / evm

        @JSONField(name = "operation_id")
        private String operationId;// 操作 ID

        @JSONField(name = "module")
        private Integer module;// 交易模块

        @JSONField(name = "operation")
        private Integer operation;// 用户操作类型

        @JSONField(name = "tx_hash")
        private String txHash;// 交易哈希

        @JSONField(name = "status")
        private Integer status;// 交易状态，1 成功; 2 失败

        @JSONField(name = "message")
        private String message;// 交易失败的错误描述信息

        @JSONField(name = "block_height")
        private Integer blockHeight;// 交易上链的区块高度

        @JSONField(name = "timestamp")
        private String timestamp;// 交易上链时间（UTC 时间）

        @JSONField(name = "nft")
        private NftNative nft;//对应不同操作类型的消息体

        @JSONField(name = "mt")
        private Mt mt;// 对应不同操作类型的消息体

        @JSONField(name = "record")
        private Record record;// 对应不同操作类型的消息体
    }


    @Data
    @NoArgsConstructor
    public static class onCallbackResEVM {

        @JSONField(name = "kind")
        private String kind;// 区分服务，native / evm

        @JSONField(name = "operation_id")
        private String operationId;// 操作 ID

        @JSONField(name = "module")
        private Integer module;// 交易模块

        @JSONField(name = "operation")
        private Integer operation;// 用户操作类型

        @JSONField(name = "tx_hash")
        private String txHash;// 交易哈希

        @JSONField(name = "status")
        private Integer status;// 交易状态，1 成功; 2 失败

        @JSONField(name = "message")
        private String message;// 交易失败的错误描述信息

        @JSONField(name = "block_height")
        private Integer blockHeight;// 交易上链的区块高度

        @JSONField(name = "timestamp")
        private String timestamp;// 交易上链时间（UTC 时间）

        @JSONField(name = "nft")
        private NftEVM nft;//对应不同操作类型的消息体
    }

    @Data
    public static class NftNative {
        @JSONField(name = "class_id")
        private String classId;// 类别 ID

        @JSONField(name = "id")
        private String Id;// NFT ID
    }

    @Data
    public static class NftEVM {
        @JSONField(name = "class_id")
        private String classId;// 类别 ID

        @JSONField(name = "id")
        private Integer Id;// NFT ID
    }

    @Data
    public static class Mt {
        @JSONField(name = "class_id")
        private String classId;// MT 类别 ID

        @JSONField(name = "mt_id")
        private String mtId;// MT ID
    }

    @Data
    public static class Record {
        @JSONField(name = "record_id")
        private String recordId;// 区块链存证 ID

        @JSONField(name = "certificate_url")
        private String certificateUrl;// 区块链存证证书的下载链接；证书下载链接并非长期有效，请您尽快将证书文件下载至本地并妥善保管。
    }

    @Data
    public static class Kind {
        @JSONField(name = "kind")
        private String kind;//区分服务，native / evm
    }
}