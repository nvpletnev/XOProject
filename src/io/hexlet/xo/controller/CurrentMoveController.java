package io.hexlet.xo.controller;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {

        int counter = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {

                try {
                    if (field.getFigure(new Point(i, j)) != null)
                        counter++;
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }


        }
        if (counter == field.getSize()*field.getSize()){
            return null;
        }
        if (counter % 2 == 0) {
            return Figure.X;
        }
        return Figure.O;
    }
}
