package ui;

import static constant.BlackjackRule.DEALER_STANDARD;

import java.util.List;

public class OutputView {
    private final String REQUEST_PLAYER_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final String REQUEST_BETTING_MONEY = "%s의 배팅 금액은?";
    private final String ANNOUNCEMENT_DISTRIBUTION = "딜러와 %s에게 2장을 나누었습니다.";
    private final String REQUEST_COMMAND_GET_CARD = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private final String ANNOUNCEMENT_DEALER_GET_CARD = "딜러는 %d이하라 한장의 카드를 더 받았습니다.";
    private final String ANNOUNCEMENT_REVENUE = "## 최종 수익";
    private final String ANNOUNCEMENT_REVENUE_OF_PLAYER = "%s: %.0f";
    private final String ANNOUNCEMENT_REVENUE_OF_DEALER = "딜러: %.0f";
    private final String ANNOUNCEMENT_RESULT = "%s - 결과: %d";

    public void requestPlayerNames() {
        System.out.println(REQUEST_PLAYER_NAMES);
    }

    public void requestBettingMoney(String name) {
        System.out.println();
        System.out.printf(REQUEST_BETTING_MONEY, name);
        System.out.println();
    }

    public void announceDistribution(List<String> playerNames) {
        System.out.println();
        String playerNamesJoined = String.join(", ", playerNames);
        System.out.printf(ANNOUNCEMENT_DISTRIBUTION, playerNamesJoined);
        System.out.println();
    }

    public void printCards(String cardValues) {
        System.out.println(cardValues);
    }

    public void requestWhetherGetCard(String name) {
        System.out.println();
        System.out.printf(REQUEST_COMMAND_GET_CARD, name);
        System.out.println();
    }

    public void announceDealerGetCard() {
        System.out.println();
        System.out.printf(ANNOUNCEMENT_DEALER_GET_CARD, DEALER_STANDARD);
        System.out.println();
        System.out.println();
    }

    public void announceFinalRevenue() {
        System.out.println();
        System.out.println(ANNOUNCEMENT_REVENUE);
    }

    public void printRevenue(String name, double money) {
        System.out.printf(ANNOUNCEMENT_REVENUE_OF_PLAYER, name, money);
        System.out.println();
    }

    public void printRevenueOfDealer(double money) {
        System.out.printf(ANNOUNCEMENT_REVENUE_OF_DEALER, money);
        System.out.println();
    }

    public void printResult(String cardValues, int score) {
        System.out.printf(ANNOUNCEMENT_RESULT, cardValues, score);
        System.out.println();
    }
}
