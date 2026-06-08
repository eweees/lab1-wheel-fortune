package ru.student.wheel.chain.handlers;

import ru.student.wheel.Player;
import ru.student.wheel.chain.Handler;

public class BigWinHandler extends Handler {

    @Override
    protected boolean canHandle(String result) {
        return "BIG".equals(result);
    }

    @Override
    protected String process(Player player) {

        player.addCoins(20);

        return "Большой приз: +20 монет";
    }
}