package ai.bianjie.avatasdk;

import ai.bianjie.avatasdk.proxy.evm.contract.impl.ContractClient;
import ai.bianjie.avatasdk.proxy.evm.nft.impl.NftClient;
import ai.bianjie.avatasdk.proxy.evm.ns.impl.NsClient;
import ai.bianjie.avatasdk.proxy.evm.tx.impl.TxClient;
import ai.bianjie.avatasdk.util.HttpClient;

public class EvmClient {

    public NftClient nftClient;
    public TxClient txClient;
    public ContractClient contractClient;
    public NsClient nsClient;

    /**
     * SDK initialization method
     */
    public EvmClient(HttpClient httpClient) {
        this.nftClient = new NftClient(httpClient);
        this.txClient = new TxClient(httpClient);
        this.contractClient = new ContractClient(httpClient);
        this.nsClient = new NsClient(httpClient);
    }
}