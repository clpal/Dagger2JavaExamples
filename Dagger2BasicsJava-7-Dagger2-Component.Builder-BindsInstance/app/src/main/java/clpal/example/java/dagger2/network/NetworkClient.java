package clpal.example.java.dagger2.network;


import javax.inject.Inject;

public class NetworkClient {

    private final Connection mConnection;

    @Inject
    public NetworkClient(Connection connection) {
        this.mConnection = connection;
    }

    @Inject
    public void attachToNetworkTester(NetworkTester tester) {
        tester.attachToNetwork(this);
    }

    public String fetchData(){
        return mConnection.doReq();
    }
}