package model.records;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数字作品存证接口请求参数
 */
@NoArgsConstructor
@Data
public class CreateRecordReq {

    @JSONField(name = "identity_type")
    private Integer identityType;// 存证主体；1:个人；2:企业
    @JSONField(name = "identity_name")
    private String identityName;// 个人姓名或企业名称，规范如下：个人姓名：长度限制 1-16 个字符（UTF-8 编码），首字符不能是特殊符号；企业名称：长度限制 1-50 个字符（UTF-8 编码），首字符不能是特殊符号；未传入存证主体字段时，不支持此字段；传入存证主体字段时，此字段必填
    @JSONField(name = "identity_num")
    private String identityNum;// 个人为身份证号码，企业为统一社会信用代码； 未传入存证主体字段时，不支持此字段；传入存证主体字段时，此字段选填
    @JSONField(name = "type")
    private Integer type;// 作品类型: Enum: 1 2 3 4 5 6 7 8 9 10 11 12 13 14，具体参考接口文档
    @JSONField(name = "name")
    private String name;// 作品名称
    @JSONField(name = "description")
    private String description;// 作品描述
    @JSONField(name = "hash")
    private String hash;// 作品哈希；将单个作品源文件使用单向散列函数（如 MD5，SHA 等）进行一次 Hash 计算；将多个作品源文件分别进行一次 Hash 计算，再将得到的 Hash 值进行二次 Hash 计算
    @JSONField(name = "hash_type")
    private Integer hashType;// 作品哈希类型 1:其它； 2:SHA256；3:MD5；4:SHA256-PFV；
    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
