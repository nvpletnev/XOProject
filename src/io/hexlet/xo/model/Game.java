package io.hexlet.xo.model;


public class Game {

    private final Player[] players;

    private final Field field;

    private final String name;

    public Game(final Player[] players, final Field field, final String name) {
        this.field = field;
        this.name = name;
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }
}
