package ru.student.wheel.chain.handlers;

import ru.student.wheel.Player;
import ru.student.wheel.chain.Handler;

public class SmallWinHandler extends Handler {

    @Override
    protected boolean canHandle(String result) {
        return "SMALL".equals(result);
    }

    @Override
    protected String process(Player player) {

        player.addCoins(2);

        return "Маленький приз: +2 монеты";
    }
}