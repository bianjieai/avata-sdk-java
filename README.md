# avata-sdk-java

## 快速开始

### SDK 介绍

该 SDK 为 Avata v3 版本,AVATA V3 是基于 V1,V2 两个版本，在产品架构、接口功能、核心服务、整体性能等方面都做了较大提升，同时兼容 AVATA V1 及 V2 版本接口；为 AVATA 平台用户提供多种功能与服务的组合使用，助力广大企业及开发者通过 AVATA 平台更加灵活便捷地对接底层链平台，打造开放多元的分布式商业应用。

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
公共接口：

- [链账户接口示例代码](./src/test/java/AccountTest.java)
- [钱包用户接口示例代码](./src/test/java/UserTest.java)
- [充值接口示例代码](./src/test/java/OrderTest.java)

原生接口：

- [NFT 接口示例代码](./src/test/java/nat/NftTest.java)
- [MT 接口示例代码](./src/test/java/nat/MtTest.java)
- [存证接口示例代码](./src/test/java/nat/RecordsTest.java)
- [交易结果查询接口示例代码](./src/test/java/nat/TxTest.java)

智能合约接口：

- [NFT 接口示例代码](./src/test/java/evm/NftTest.java)
- [Web3 域名服务接口示例代码](./src/test/java/evm/NsTest.java)
- [智能合约服务接口示例代码](./src/test/java/evm/ContractTest.java)
- [交易结果查询接口示例代码](./src/test/java/evm/TxTest.java)
