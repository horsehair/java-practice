package controller;

import domain.Blackjack;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ui.InputView;
import ui.OutputView;

public class BlackjackController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Blackjack blackjack;
    private final Dealer dealer;
    private final List<Player> players;

    public BlackjackController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.blackjack = new Blackjack();
        this.dealer = new Dealer();
        this.players = new ArrayList<>();
    }

    public void start() {
        generatePlayers();
        startGame();
        if (!checkBlackjack()) {
            redistribute();
            checkDealerScore();
            calculateResultOfEachPlayer();
        }
        printResult();
    }

    private void generatePlayers() {
        outputView.requestPlayerNames();
        List<String> playerNames = inputView.readPlayerNames();
        playerNames.stream().forEach(name -> {
            outputView.requestBettingMoney(name);
            double bettingMoney = inputView.readBettingMoney();
            players.add(new Player(name, bettingMoney));
        });
    }

    private void startGame() {
        outputView.announceDistribution(getPlayerNames());
        IntStream.range(0, 2).forEach(number -> {
            dealer.addCard(blackjack.getNewCard());
            addCardToEachPlayers();
        });
        printStatus();
    }

    private void printStatus() {
        outputView.printCards(dealer.getCardsToPrint());
        printCardsOfEachPlayers();
    }

    private void printStatusWithScore() {
        outputView.printResult(dealer.getCardsToPrint(), dealer.getScore());
        printResultOfEachPlayers();
    }

    private List<String> getPlayerNames() {
        List<String> playerNames = new ArrayList<>();
        players.forEach(player -> {
            playerNames.add(player.getName());
        });
        return playerNames;
    }

    private void addCardToEachPlayers() {
        players.forEach(player -> {
            player.addCard(blackjack.getNewCard());
        });
    }

    private void printCardsOfEachPlayers() {
        players.forEach(player -> {
            outputView.printCards(player.getCardsToPrint());
        });
    }

    private void printResultOfEachPlayers() {
        players.forEach(player -> {
            outputView.printResult(player.getCardsToPrint(), player.getScore());
        });
    }

    private boolean checkBlackjack() {
        if (dealer.isBlackJack()) {
            players.forEach(Player::calculateResultWhenDealerIsBlackjack);
            return true;
        }
        return false;
    }

    private void redistribute() {
        players.forEach(this::redistributeAfterCheck);
    }

    private void redistributeAfterCheck(Player player) {
        int count = 0;
        while (player.isUnderBlackjack()) {
            boolean isGetCard = isGetCard(player);
            if (!isGetCard) {
                break;
            }
            player.addCard(blackjack.getNewCard());
            count += 1;
            outputView.printCards(player.getCardsToPrint());
        }
        if (count == 0) {
            outputView.printCards(player.getCardsToPrint());
        }
    }

    private boolean isGetCard(Player player) {
        outputView.requestWhetherGetCard(player.getName());
        String getCardCommand = inputView.readGetCardCommand();
        boolean isGetCard = player.judgeRedistribution(getCardCommand);
        return isGetCard;
    }

    private void checkDealerScore() {
        if (dealer.isUnderStandard()) {
            outputView.announceDealerGetCard();
            dealer.addCard(blackjack.getNewCard());
        }
    }

    private void calculateResultOfEachPlayer() {
        players.forEach(player -> {
            player.calculateResultWithDealerScore(dealer.getScore());
        });
    }

    private void printResult() {
        printStatusWithScore();
        outputView.announceFinalRevenue();
        double dealerMoney = (-1) * players.stream()
                .mapToDouble(Player::getMoney)
                .sum();
        outputView.printRevenueOfDealer(dealerMoney);
        players.forEach(player -> {
            outputView.printRevenue(player.getName(), player.getMoney());
        });
    }
}
