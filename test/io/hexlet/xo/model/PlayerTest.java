package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nikolaypletnev on 05.06.18.
 */
public class PlayerTest {
    @Test
    public void getFigure() throws Exception {

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void getName() throws Exception {

        final String inputValue = "Kolya";

        final String expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);

    }

}