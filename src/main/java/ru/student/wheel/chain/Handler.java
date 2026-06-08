package ru.student.wheel.chain;

import ru.student.wheel.Player;

public abstract class Handler {

    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public String handle(String result, Player player) {

        if (canHandle(result)) {
            return process(player);
        }

        if (next != null) {
            return next.handle(result, player);
        }

        return "Неизвестный результат.";
    }

    protected abstract boolean canHandle(String result);

    protected abstract String process(Player player);
}