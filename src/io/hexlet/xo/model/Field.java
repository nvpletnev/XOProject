package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private final Figure[][] figures;

    public Field(final Figure[][] figures) {
        this.figures = figures;
    }

    public int getSize() {

        return figures.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {

        if (!(checkPoint(point))) throw new InvalidPointException();

        return figures[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {

            throw new InvalidPointException();
        }

        figures[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {

        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int x) {

        return x >= 0 && x < getSize();
    }
}
