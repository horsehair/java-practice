package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.domain.GameCommand.QUIT;
import static bridge.domain.GameStatus.END_FAIL;
import static bridge.domain.GameStatus.END_SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryCount;
    private GameStatus gameStatus;
    private final BridgeReferee bridgeReferee;
    private BridgePicture bridgePicture;

    public BridgeGame(int bridgeSize) {
        this.tryCount = 1;
        this.gameStatus = GameStatus.ON_WAY;
        this.bridgeReferee = new BridgeReferee(generateBridge(bridgeSize));
        this.bridgePicture = new BridgePicture();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Moving moving) {
        int location = bridgePicture.getLocation();
        boolean canCross = bridgeReferee.judge(moving, location);
        bridgePicture.record(moving, canCross);
        checkIsSuccess();
    }

    private void checkIsSuccess() {
        int location = bridgePicture.getLocation();
        boolean isEndLocation = bridgeReferee.isEndLocation(location);
        if (!bridgePicture.isFail() && isEndLocation) {
            gameStatus = END_SUCCESS;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand gameCommand) {
        if (gameCommand.equals(QUIT)) {
            gameStatus = END_FAIL;
            return;
        }
        resetGame();
    }

    private void resetGame() {
        this.bridgePicture = new BridgePicture();
        tryCount += 1;
    }

    public boolean isOnWay() {
        return this.gameStatus.isOnWay();
    }

    public BridgePicture getPicture() {
        return bridgePicture;
    }

    public int getTryCount() {
        return tryCount;
    }

    private List<Moving> generateBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeRaw = bridgeMaker.makeBridge(bridgeSize);
        return bridgeRaw.stream()
            .map(Moving::getByCommand)
            .collect(Collectors.toList());
    }
}
