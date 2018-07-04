package io.hexlet.xo.controller;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAllreadyOccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Figure figure, final Point point)
                                            throws PointAllreadyOccupiedException,
                                                            InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new PointAllreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
