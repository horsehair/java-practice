package bridge.domain;

import java.util.List;

public class BridgeReferee {
    private List<Moving> bridge;

    public BridgeReferee(List<Moving> bridge) {
        this.bridge = bridge;
    }

    public boolean judge(Moving moving, int location) {
        Moving movingNow = bridge.get(location);
        return movingNow.equals(moving);
    }
}
