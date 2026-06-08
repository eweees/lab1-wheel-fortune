package ru.student.wheel.chain.handlers;

import ru.student.wheel.Player;
import ru.student.wheel.chain.Handler;

public class LossHandler extends Handler {

    @Override
    protected boolean canHandle(String result) {
        return "LOSS".equals(result);
    }

    @Override
    protected String process(Player player) {
        return "Пусто. Вы ничего не выиграли.";
    }
}