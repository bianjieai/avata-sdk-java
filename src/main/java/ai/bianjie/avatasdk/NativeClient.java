package ai.bianjie.avatasdk;

import ai.bianjie.avatasdk.proxy.nat.mt.impl.MtClient;
import ai.bianjie.avatasdk.proxy.nat.nft.impl.NftClient;
import ai.bianjie.avatasdk.proxy.nat.records.impl.RecordsClient;
import ai.bianjie.avatasdk.proxy.nat.tx.impl.TxClient;
import ai.bianjie.avatasdk.util.HttpClient;

public class NativeClient {

    public NftClient nftClient;
    public MtClient mtClient;
    public RecordsClient recordsClient;
    public TxClient txClient;

    /**
     * SDK initialization method
     */
    public NativeClient(HttpClient httpClient) {
        this.nftClient = new NftClient(httpClient);
        this.mtClient = new MtClient(httpClient);
        this.recordsClient = new RecordsClient(httpClient);
        this.txClient = new TxClient(httpClient);
    }
}
