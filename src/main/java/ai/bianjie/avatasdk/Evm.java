package ai.bianjie.avatasdk;

import ai.bianjie.avatasdk.proxy.evm.contract.impl.Contract;
import ai.bianjie.avatasdk.proxy.evm.nft.impl.Nft;
import ai.bianjie.avatasdk.proxy.evm.ns.impl.Ns;
import ai.bianjie.avatasdk.proxy.evm.tx.impl.Tx;
import ai.bianjie.avatasdk.util.HttpClient;

public class Evm {

    public Nft nft;
    public Tx tx;
    public Contract contract;
    public Ns ns;

    /**
     * SDK initialization method
     */
    public Evm(HttpClient httpClient) {
        this.nft = new Nft(httpClient);
        this.tx = new Tx(httpClient);
        this.contract = new Contract(httpClient);
        this.ns = new Ns(httpClient);
    }
}