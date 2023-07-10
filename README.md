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

公共接口：
```
ai.bianjie.avatasdk.AvataClient client = new ai.bianjie.avatasdk.AvataClient.Builder()
            .setDoMain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();
```

原生接口：
```
ai.bianjie.avatasdk.AvataNativeClient client = new ai.bianjie.avatasdk.AvataNativeClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

```


智能合约接口：
```
ai.bianjie.avatasdk.AvataEvmClient client = new ai.bianjie.avatasdk.AvataEvmClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

```


公共接口：

- [链账户接口示例代码](./src/test/java/AccountTest.java)
- [充值接口示例代码](./src/test/java/OrderTest.java)
- [存证接口示例代码](./src/test/java/RecordsTest.java)

原生接口：

- [NFT 接口示例代码](./src/test/java/nat/NftTest.java)
- [交易结果查询接口示例代码](./src/test/java/nat/TxTest.java)
- [MT 接口示例代码](./src/test/java/nat/MtTest.java)

智能合约接口：

- [NFT 接口示例代码](./src/test/java/evm/NftTest.java)
- [Web3 域名服务接口示例代码](./src/test/java/evm/NsTest.java)
- [智能合约服务接口示例代码](./src/test/java/evm/ContractTest.java)
- [交易结果查询接口示例代码](./src/test/java/evm/TxTest.java)
