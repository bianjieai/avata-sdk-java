# avata-sdk-java

## 快速开始

### SDK 介绍

该 SDK 为 Avata v3 版本

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

公共接口：

- [链账户接口示例代码](./src/test/java/AccountTest.java)
- [充值接口示例代码](./src/test/java/OrderTest.java)

原生接口：

- [NFT 接口示例代码](./src/test/java/nat/NftTest.java)
- [存证接口示例代码](./src/test/java/nat/RecordTest.java)
- [交易结果查询接口示例代码](./src/test/java/nat/TxTest.java)

智能合约接口：

- [NFT 接口示例代码](./src/test/java/evm/NftTest.java)
- [Web3 域名服务接口示例代码](./src/test/java/evm/NsTest.java)
- [智能合约服务接口示例代码](./src/test/java/evm/ContractTest.java)
- [钱包用户管理接口示例代码](./src/test/java/evm/UserTest.java)
- [交易结果查询接口示例代码](./src/test/java/evm/TxTest.java)
