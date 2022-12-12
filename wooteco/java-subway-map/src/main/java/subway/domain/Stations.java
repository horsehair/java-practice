package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Stations {
    private List<Station> stations;
    private final String ERROR_MESSAGE_NOT_EXIST_STATION_NAME = "[ERROR] 존재하지 않는 역 이름입니다.";
    private final String ERROR_MESSAGE_EXIST_STATION_NAME = "[ERROR] 이미 존재하는 역 이름입니다.";

    public Stations() {
        this.stations = new ArrayList<>();
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
    }

    public Station getStationByName(String stationName) {
        return stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_STATION_NAME));
    }

    public void register(String stationName) {
        validateDuplication(stationName);
        stations.add(new Station(stationName));
    }

    private void validateDuplication(String stationName) {
        for (Station station: stations) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_EXIST_STATION_NAME)
            }
        }
    }
}
