package ru.student.wheel;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import ru.student.wheel.chain.ActionChain;

import java.util.Random;

public class Controller {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private ImageView wheelImage;

    @FXML
    private Button spinButton;

    private final Player player = new Player();

    private final Random random = new Random();

    private final ActionChain chain = new ActionChain();

    @FXML
    public void initialize() {
        updateBalance();
    }

    @FXML
    private void spinWheel() {

        if (player.getCoins() <= 0) {
            resultLabel.setText(
                    "Монет нет. Пополните баланс или сбросьте игру.");
            return;
        }

        player.removeCoin();
        updateBalance();

        RotateTransition rotate =
                new RotateTransition(Duration.seconds(2), wheelImage);

        rotate.setByAngle(1080 + random.nextInt(360));

        rotate.setOnFinished(event -> {

            int chance = random.nextInt(100);

            String result;

            if (chance < 40) {
                result = "SMALL";
            } else if (chance < 65) {
                result = "MEDIUM";
            } else if (chance < 80) {
                result = "LOSS";
            } else if (chance < 95) {
                result = "BIG";
            } else {
                result = "JACKPOT";
            }

            String message = chain.process(result, player);

            resultLabel.setText(message);
            updateBalance();
        });

        rotate.play();
    }

    @FXML
    private void refillCoins() {
        player.addCoins(5);
        updateBalance();
        resultLabel.setText("Баланс пополнен на 5 монет.");
    }

    @FXML
    private void resetGame() {
        player.reset();
        updateBalance();
        resultLabel.setText("Игра сброшена.");
    }

    private void updateBalance() {
        balanceLabel.setText("Монеты: " + player.getCoins());
    }
}