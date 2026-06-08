package ru.student.wheel.chain.handlers;

import ru.student.wheel.Player;
import ru.student.wheel.chain.Handler;

public class MediumWinHandler extends Handler {

    @Override
    protected boolean canHandle(String result) {
        return "MEDIUM".equals(result);
    }

    @Override
    protected String process(Player player) {

        player.addCoins(8);

        return "Средний приз: +8 монет";
    }
}