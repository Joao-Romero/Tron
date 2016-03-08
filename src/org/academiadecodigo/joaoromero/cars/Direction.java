package org.academiadecodigo.joaoromero.cars;

/**
 * Created by João Romero on 04/02/16.
 */
public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;


    public static Direction getRandomDirection() {

        int randomNr = (int)(Math.random() * Direction.values().length);
        return Direction.values()[randomNr];
    }

    //TODO: to prevent always crashing when hitting edges, create method that chooses other 3 dirs
    public Direction getOppositeDirection() {

        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                System.out.println("error getting opposite direction");
                return null;
        }
    }
}
