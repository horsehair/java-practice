package subway.ui;

import java.util.Scanner;
import subway.constant.MainCommand;
import subway.constant.PathCommand;

public class InputView {
    private Scanner scanner;
    private final String REQUEST_MAIN_COMMAND = "## 원하는 기능을 선택하세요.";
    private final String REQUEST_START_STATION = "## 출발역을 입력하세요.";
    private final String REQUEST_END_STATION = "## 도착역을 입력하세요.";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainCommand readMainCommand() {
        System.out.println(REQUEST_MAIN_COMMAND);
        MainCommand mainCommand = MainCommand.get(scanner.nextLine());
        System.out.println();
        return mainCommand;
    }

    public PathCommand readPathCommand() {
        System.out.println(REQUEST_MAIN_COMMAND);
        PathCommand pathCommand = PathCommand.get(scanner.nextLine());
        System.out.println();
        return pathCommand;
    }

    public String readStartStation() {
        System.out.println(REQUEST_START_STATION);
        String stationName = scanner.nextLine();
        System.out.println();
        return stationName;
    }

    public String readEndStation() {
        System.out.println(REQUEST_END_STATION);
        String stationName = scanner.nextLine();
        System.out.println();
        return stationName;
    }
}
