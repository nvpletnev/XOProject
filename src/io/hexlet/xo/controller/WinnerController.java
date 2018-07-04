package io.hexlet.xo.controller;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAllreadyOccupiedException;

import java.awt.*;
import java.util.ArrayList;

public class WinnerController {
    //Имплементировать метод проверки по столбцам и строкам
    //Доп метод проверки по ряду
    //Имплементировать метод проверки по диагоналям

    public Figure getWinner(final Field field) {
        final int fieldSize = field.getSize();
        try {
            for (int i = 0; i < fieldSize; i++)
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i, 0));

            for (int i = 0; i < fieldSize; i++)
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0, i));

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, fieldSize - 1), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(0, fieldSize - 1));

        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null)
                return false;

            nextFigure = field.getFigure(nextPoint);
        }
        catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure)
            return false;

        return check(field, nextPoint, pointGenerator);

    }

    private interface IPointGenerator {
        Point next(final Point point);
    }


}
