package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAllreadyOccupiedException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field(new Figure[3][3]);
        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(new Figure[3][3]);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test public void testGetFigureWhenXLessThenZero() {
        final Field field = new Field(new Figure[3][3]);
        final Point inputPoint = new Point(-1,0);
        final Figure inputFigure = Figure.X;
        try {

            field.getFigure(inputPoint);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test public void testGetFigureWhenXMoreThenSize() {
        final Field field = new Field(new Figure[3][3]);
        final Point inputPoint = new Point(field.getSize() + 1,0);
        final Figure inputFigure = Figure.X;
        try {

            field.getFigure(inputPoint);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test public void testGetFigureWhenYLessThenZero() {
        final Field field = new Field(new Figure[3][3]);
        final Point inputPoint = new Point(0,-1);
        final Figure inputFigure = Figure.X;
        try {

            field.getFigure(inputPoint);
            fail();
        }
        catch (InvalidPointException e) {}
    }

    @Test public void testGetFigureWhenYMoreThenSize() {
        final Field field = new Field(new Figure[3][3]);
        final Point inputPoint = new Point(0,field.getSize() + 1);
        final Figure inputFigure = Figure.X;
        try {

            field.getFigure(inputPoint);
            fail();
        }
        catch (InvalidPointException e) {}
    }


}
