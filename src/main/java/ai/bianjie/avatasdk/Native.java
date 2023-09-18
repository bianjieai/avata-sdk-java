package ai.bianjie.avatasdk;

import ai.bianjie.avatasdk.proxy.nat.mt.impl.Mt;
import ai.bianjie.avatasdk.proxy.nat.nft.impl.Nft;
import ai.bianjie.avatasdk.proxy.nat.records.impl.Records;
import ai.bianjie.avatasdk.proxy.nat.tx.impl.Tx;
import ai.bianjie.avatasdk.util.HttpClient;

public class Native {

    public Nft nft;
    public Mt mt;
    public Records records;
    public Tx tx;

    /**
     * SDK initialization method
     */
    public Native(HttpClient httpClient) {
        this.nft = new Nft(httpClient);
        this.mt = new Mt(httpClient);
        this.records = new Records(httpClient);
        this.tx = new Tx(httpClient);
    }
}
