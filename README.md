# avata-sdk-java

## 快速开始

### SDK 介绍

该 SDK 为 Avata v3 版本。 Avata v3 是基于 v1 和 v2 两个版本，在产品架构、接口功能、核心服务、整体性能等方面都做了较大提升，同时兼容原生模块和智能合约模块；为 Avata 平台用户提供多种功能与服务的组合使用，助力广大企业及开发者通过 Avata 平台更加灵活便捷地对接底层链平台，打造开放多元的分布式商业应用。

### 引入依赖

```
        <dependency>
            <groupId>io.github.bianjieai</groupId>
            <artifactId>avata-sdk</artifactId>
            <version>${version}</version>
        </dependency>
```

### 创建和使用客户端

```
public class AvataClientTest {

    public static  AvataClient getAvataClient() {
        return new AvataClient.Builder()
                .setDomain("域名，不同环境对应不同的域名，如测试环境: https://stage.apis.avata.bianjie.ai")
                .setApiKey("项目参数 API KEY")
                .setApiSecret("项目参数 API SECRET")
                .setHttpTimeout(10000)
                .init();
    }
}
```

- [回调服务示例代码](src/test/java/ai/bianjie/avatasdktest/CallbackTest.java)

- [链账户接口示例代码](src/test/java/ai/bianjie/avatasdktest/AccountTest.java)

- 原生模块：
  - [NFT 接口示例代码](src/test/java/ai/bianjie/avatasdktest/nat/NftTest.java)
  - [MT 接口示例代码](src/test/java/ai/bianjie/avatasdktest/nat/MtTest.java)
  - [区块链存证接口示例代码](src/test/java/ai/bianjie/avatasdktest/nat/RecordsTest.java)
  - [查询上链交易结果接口示例代码](src/test/java/ai/bianjie/avatasdktest/nat/TxTest.java)
  - [查询链账户操作记录接口示例代码](src/test/java/ai/bianjie/avatasdktest/AccountTest.java)
  - [查询枚举值列表接口示例代码](src/test/java/ai/bianjie/avatasdktest/nat/TxTest.java)

- 智能合约模块：
  - [NFT 接口示例代码](src/test/java/ai/bianjie/avatasdktest/evm/NftTest.java)
  - [Web3 域名服务接口示例代码](src/test/java/ai/bianjie/avatasdktest/evm/NsTest.java)
  - [合约服务接口示例代码](src/test/java/ai/bianjie/avatasdktest/evm/ContractTest.java)
  - [查询上链交易结果接口示例代码](src/test/java/ai/bianjie/avatasdktest/evm/TxTest.java)
  - [查询链账户操作记录接口示例代码](src/test/java/ai/bianjie/avatasdktest/AccountTest.java)
  - [查询枚举值列表接口示例代码](src/test/java/ai/bianjie/avatasdktest/evm/TxTest.java)
    
- [购买能量值接口示例代码](src/test/java/ai/bianjie/avatasdktest/OrderTest.java)
- [钱包服务接口示例代码](src/test/java/ai/bianjie/avatasdktest/UserTest.java)

