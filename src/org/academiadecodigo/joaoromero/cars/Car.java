package org.academiadecodigo.joaoromero.cars;

import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.joaoromero.field.GridPosition;
import org.academiadecodigo.joaoromero.field.Representation;
import org.academiadecodigo.simplegraphics.graphics.Color;


public class Car implements Movable {

    private Representation representation;
    private Grid grid;
    private int speed;
    private boolean crashed;
    private Direction direction;


    public Car(int speed, Grid grid) {

        this.grid = grid;
        this.speed = speed;
        this.representation = new Representation(grid);
        this.direction = Direction.getRandomDirection();
    }

    @Override
    public boolean isCrashed() {
        return crashed;
    }

    public void crash() {

        if (isCrashed()) {
            return;
        }


        this.crashed = true;
        getRepresentation().getModel().setColor(Color.RED);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Representation getRepresentation() {
        return representation;
    }

    private void chooseNewDir() {

        Direction newDir;

        if (Math.random() > 0.7) {
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

    @Override
    public void move() {

        if (isCrashed() || this.direction == null) {
            return;
        }

        visitCell();
        accelerate();
    }

    //makes model move in certain direction at given speed
    private void accelerate() {
        chooseNewDir();
        representation.move(speed, direction);
    }

    public void setColor(Color color) {
        representation.setColor(color);
    }

    public void draw() {
        representation.draw();
    }

    private void toOppositeDirection() {
        direction = direction.getOppositeDirection();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void giveRandomColor() {
        getRepresentation().setColor(Color.RED);
    }

    public GridPosition getPosition() {
        return getRepresentation().getPosition();
    }

    void visitCell() {
        grid.visitCell(this);
   }

    @Override
    public Color getColor() {
        return getRepresentation().getColor();
    }
}


