package subway.domain;

import java.util.List;
import java.util.stream.Collectors;
import subway.constant.PathCommand;

public class Subway {
    private final String ERROR_MESSAGE_SAME_STATION = "[ERROR] 출발역과 도착역은 달라야 합니다.";

    public Subway() {
        initStation();
        initLine();
        initPathGraph();
    }

    public PathResult getPathResult(PathCommand pathCommand, String startStationName, String endStationName) {
        validateSameStationName(startStationName, endStationName);
        Station startStation = StationRepository.getStationByName(startStationName);
        Station endStation = StationRepository.getStationByName(endStationName);
        List<Station> stationsOfPath = PathGraphRepository.getStationsOfPath(
                pathCommand, startStation, endStation
        );
        List<String> stationNames = stationsOfPath.stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());
        int distance = PathGraphRepository.getDistanceThrough(stationsOfPath);
        int time = PathGraphRepository.getTimeThrough(stationsOfPath);
        return new PathResult(distance, time, stationNames);
    }

    private void validateSameStationName(String startStationName, String endStationName) {
        if (startStationName.equals(endStationName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SAME_STATION);
        }
    }

    private void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void initPathGraph() {
        PathGraphRepository.addPathGraph(new PathGraph(PathCommand.MINIMUM_DISTANCE));
        PathGraphRepository.addPathGraph(new PathGraph(PathCommand.MINIMUM_TIME));
        addVertexInitOfDistance();
        addVertexInitOfTime();
        initPathsOfDistanceFirst();
        initPathsOfDistanceSecond();
        initPathsOfTimeFirst();
        initPathsOfTimeSecond();

    }

    private static void addVertexInitOfDistance() {
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("교대역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("강남역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("역삼역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("남부터미널역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("양재역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("매봉역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_DISTANCE, StationRepository.getStationByName("양재시민의숲역"));
    }

    private static void addVertexInitOfTime() {
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("교대역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("강남역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("역삼역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("남부터미널역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("양재역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("매봉역"));
        PathGraphRepository.addVertex(PathCommand.MINIMUM_TIME, StationRepository.getStationByName("양재시민의숲역"));
    }

    private void initPathsOfDistanceFirst() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_DISTANCE);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("강남역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("역삼역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("남부터미널역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("남부터미널역"), StationRepository.getStationByName("양재역"), 6);
        PathGraphRepository.setEdgeWeight(pathInfo);

    }

    private void initPathsOfDistanceSecond() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_DISTANCE);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("매봉역"), 1);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("양재역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("양재시민의숲역"), 10);
        PathGraphRepository.setEdgeWeight(pathInfo);
    }

    private void initPathsOfTimeFirst() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_TIME);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("강남역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("역삼역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("남부터미널역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("남부터미널역"), StationRepository.getStationByName("양재역"), 5);
        PathGraphRepository.setEdgeWeight(pathInfo);
    }

    private void initPathsOfTimeSecond() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_TIME);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("매봉역"), 1);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("양재역"), 8);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("양재시민의숲역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
    }
}
