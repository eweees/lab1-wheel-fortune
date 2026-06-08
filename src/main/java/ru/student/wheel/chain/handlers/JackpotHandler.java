package ru.student.wheel.chain.handlers;

import ru.student.wheel.Player;
import ru.student.wheel.chain.Handler;

public class JackpotHandler extends Handler {

    @Override
    protected boolean canHandle(String result) {
        return "JACKPOT".equals(result);
    }

    @Override
    protected String process(Player player) {

        player.addCoins(50);

        return "ДЖЕКПОТ! +50 монет";
    }
}