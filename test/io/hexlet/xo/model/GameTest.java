package io.hexlet.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class GameTest {
    @Test
    public void getPlayers() throws Exception {

        Field field = new Field(new Figure[3][3]);
        final Player[] players = new Player[2];
        players[0] = new Player(Figure.X, "Slava");
        players[1] = new Player(Figure.O, "Oleg");

        Game game = new Game(players, field, "XO");

        Point point = new Point(0,0);

        String expectedName = "XO";

        assertEquals(expectedName, game.getName());

        field.setFigure(point, Figure.X);

        Figure expectedFigure = field.getFigure(point);

        Figure actualFigure = game.getField().getFigure(point);
        //Figure actualFigure = Figure.O;

        assertEquals(expectedFigure, actualFigure);

        System.out.println(actualFigure + " " + expectedFigure);

    }

    @Test
    public void getField() throws Exception {

    }

}