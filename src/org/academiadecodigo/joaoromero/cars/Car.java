package org.academiadecodigo.joaoromero.cars;

import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.joaoromero.field.Representation;


public class Car {

    private Representation representation;
    private int speed;
    private boolean crashed;
    private Direction direction;


    public Car(int speed, Grid grid) {
        this.speed = speed;
        this.representation = new Representation(grid);
        this.direction = Direction.getRandomDirection();
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void crash() {
        this.crashed = true;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void chooseNewDir() {

        Direction newDir;

        if (Math.random() > 0.9) {
            newDir = Direction.getRandomDirection();

            //car behaviour: doesn't turn 180º
            while (newDir == direction.getOppositeDirection()) {
                newDir = Direction.getRandomDirection();
            }
            direction = newDir;
        }

        if (representation.isOnEdge(direction)) {
            toOppositeDirection();
        }

    }

    public void move() {

        if (isCrashed() || this.direction == null) {
            return;
        }
        System.out.println("On column: " + representation.getCol() + " ; " + "On row: " + representation.getRow());
        chooseNewDir();

        System.out.println("Dir taken: " + this.direction.name());
        accelerate();
    }

    //makes model move in certain direction at given speed
    private void accelerate() {

        switch (this.direction) {
            case NORTH:
                representation.moveNorth(speed);
                break;
            case SOUTH:
                representation.moveSouth(speed);
                break;
            case EAST:
                representation.moveEast(speed);
                break;
            case WEST:
                representation.moveWest(speed);
                break;
        }
    }

    private void toOppositeDirection() {
        direction = direction.getOppositeDirection();
    }
}


