package io.hexlet.xo.model;


public class Player {

    private final Figure figure;
    private final String name;

    public Player(final Figure figure, final String name) {
        this.figure = figure;
        this.name = name;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getName() {
        return name;
    }
}

