package model.tx;

import java.util.Map;

public class Data {

    /**
     * 用户操作类型
     */
    private String type;

    /**
     * 交易hash
     */
    private String txHash;

    /**
     * 交易状态, 0 处理中; 1 成功; 2 失败; 3 未处理
     */
    private Integer status;

    /**
     * 类别id
     */
    private String classId;

    /**
     * NFT ID
     */
    private String nftId;

    /**
     * 错误描述
     */
    private String message;

    /**
     * 交易上链的区块高度
     */
    private String blockHeight;

    /**
     * 交易标签, 自定义 key：支持大小写英文字母和汉字和数字，长度6-12位，自定义 value：长度限制在64位字符，支持大小写字母和数字
     */
    private Map<String, Object> tag;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getNftId() {
        return nftId;
    }

    public void setNftId(String nftId) {
        this.nftId = nftId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(String blockHeight) {
        this.blockHeight = blockHeight;
    }

    public Map<String, Object> getTag() {
        return tag;
    }

    public void setTag(Map<String, Object> tag) {
        this.tag = tag;
    }
}
