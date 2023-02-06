# avata-sdk-java

## 快速开始

### 引入依赖

```
        <dependency>
            <groupId></groupId>
            <artifactId></artifactId>
            <version></version>
        </dependency>
```

### 创建和使用客户端

```
Client client = new Client.Builder()
            .setDoMain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();
```

- [链账户接口示例代码](./test/java/AccountTest.java)
- [交易结果查询接口示例代码](./test/java/TxTest)
- [NFT 接口示例代码](./test/java/NftTest)
- [MT 接口示例代码](./test/java/MtTest)
- [充值接口示例代码](./test/java/OrderTest)
- [存证接口示例代码](./test/java/RecordTest)