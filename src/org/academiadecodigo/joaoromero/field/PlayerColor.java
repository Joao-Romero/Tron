package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by João Romero on 28/02/16.
 */
public enum PlayerColor {

    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    YELLOW(Color.YELLOW),
    ORANGE(Color.ORANGE),
    CYAN(Color.CYAN),
    RED(Color.RED),
    MAGENTA(Color.MAGENTA),
    WHITE(Color.WHITE),
    LIGHT_GRAY(Color.LIGHT_GRAY),
    PINK(Color.PINK);

    private Color color;

    PlayerColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}
