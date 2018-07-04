package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class CurrentMoveControllerTest {
    @Test
    public void currentMoveWhenAllPointsOccupied() throws Exception {
        Field field = new Field(new Figure[3][3]);
        MoveController moveController = new MoveController();
        CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                moveController.applyFigure(field,Figure.X,new Point(i,j));
            }
        }

        assertNull(currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveWhenAllPointsFree() throws Exception {
        Field field = new Field(new Figure[3][3]);
       // MoveController moveController = new MoveController();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveWhenMoveO() throws Exception {
        Field field = new Field(new Figure[3][3]);
        MoveController moveController = new MoveController();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        moveController.applyFigure(field, Figure.X, new Point(1,1));
        moveController.applyFigure(field, Figure.O, new Point(0,0));
        moveController.applyFigure(field, Figure.X, new Point(1,0));

        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }
    @Test
    public void currentMoveWhenMoveX() throws Exception {
        Field field = new Field(new Figure[3][3]);
        MoveController moveController = new MoveController();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        moveController.applyFigure(field, Figure.X, new Point(1,1));
        moveController.applyFigure(field, Figure.O, new Point(0,0));
        moveController.applyFigure(field, Figure.X, new Point(1,0));
        moveController.applyFigure(field, Figure.O, new Point(2,0));

        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

}