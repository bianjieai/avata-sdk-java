# avata-sdk-java

## 快速开始

### SDK 介绍
该 SDK 为 Avata v2 版本，基于标准化的 EVM 合约发行 NFT 资产，更加方便灵活地实现资产数字化业务需求。后期还将扩展适配其他标准化合约，充分满足 NFT 的可扩展性和可流动性场景。

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
ai.bianjie.avatasdk.AvataClient client = new ai.bianjie.avatasdk.AvataClient.Builder()
            .setDoMain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();
```

- [链账户接口示例代码](./src/test/java/AccountTest.java)
- [NFT 接口示例代码](./src/test/java/NftTest.java)
- [交易结果查询接口示例代码](./src/test/java/TxTest.java)
- [存证接口示例代码](./src/test/java/RecordTest.java)
- [充值接口示例代码](./src/test/java/OrderTest.java)
- [Web3 域名服务接口示例代码](./src/test/java/NsTest.java)
- [智能合约服务接口示例代码](./src/test/java/ContractTest.java)
- [钱包用户管理接口示例代码](./src/test/java/UserTest.java)
  
