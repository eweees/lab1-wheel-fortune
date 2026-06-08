package ru.student.wheel.chain;

import ru.student.wheel.Player;
import ru.student.wheel.chain.handlers.BigWinHandler;
import ru.student.wheel.chain.handlers.JackpotHandler;
import ru.student.wheel.chain.handlers.LossHandler;
import ru.student.wheel.chain.handlers.MediumWinHandler;
import ru.student.wheel.chain.handlers.SmallWinHandler;

public class ActionChain {

    private final Handler chain;

    public ActionChain() {

        Handler loss = new LossHandler();
        Handler small = new SmallWinHandler();
        Handler medium = new MediumWinHandler();
        Handler big = new BigWinHandler();
        Handler jackpot = new JackpotHandler();

        loss.setNext(small)
                .setNext(medium)
                .setNext(big)
                .setNext(jackpot);

        chain = loss;
    }

    public String process(String result, Player player) {
        return chain.handle(result, player);
    }
}