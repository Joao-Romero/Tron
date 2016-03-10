package org.academiadecodigo.joaoromero.cars;

import org.academiadecodigo.joaoromero.field.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by João Romero on 08/03/16.
 */
public interface Movable {


    public void move();

    public boolean isCrashed();

    public void crash();

    public Color getColor();

    public GridPosition getPosition();
}
