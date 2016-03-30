package org.academiadecodigo.joaoromero;

import org.academiadecodigo.joaoromero.cars.Direction;

/**
 * Created by João Romero on 08/03/16.
 */
public enum KeyList {

    KEY_UP(Direction.NORTH),
    KEY_DOWN(Direction.SOUTH),
    KEY_LEFT(Direction.WEST),
    KEY_RIGHT(Direction.EAST),

    KEY_W(Direction.NORTH),
    KEY_S(Direction.SOUTH),
    KEY_A(Direction.WEST),
    KEY_D(Direction.EAST);


    private Direction direction;

    KeyList(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }


}
