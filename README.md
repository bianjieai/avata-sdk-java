# avata-sdk-java

## 快速开始

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
- [交易结果查询接口示例代码](./src/test/java/TxTest.java)
- [NFT 接口示例代码](./src/test/java/NftTest.java)
- [MT 接口示例代码](./src/test/java/MtTest.java)
- [充值接口示例代码](./src/test/java/OrderTest.java)
- [存证接口示例代码](./src/test/java/RecordTest.java)