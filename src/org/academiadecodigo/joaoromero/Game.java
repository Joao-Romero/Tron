package org.academiadecodigo.joaoromero;

import org.academiadecodigo.joaoromero.cars.Car;
import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.joaoromero.field.PlayerColor;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

    //public static int NUMB_CARS_CREATED = 10;

    int delay;

    Car[] cars;

    Grid grid;

    public Game(int width, int height, int cellSize, int delay) {
        grid = new Grid(cellSize, width, height);
        this.delay = delay;
    }

    //pass number of players (1 or 2) ? resolve more with if
    public void init(int numbCarsCreated) {
        grid.init();

        if (numbCarsCreated > 10) {
            numbCarsCreated = 10;
        }
        /*
        if(numbPlayersCreated > 2) {
            numbPlayersCreated = 2;
        }
         */

        cars = new Car[numbCarsCreated];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(1, grid);
            cars[i].setColor(getPlayerColor(i));
            cars[i].draw();
        }
    }

    private Color getPlayerColor(int number) {
        Color color = Color.GREEN;
        switch (number) {
            case 1:
                color = Color.BLUE;
                break;
            case 2:
                color = Color.YELLOW;
                break;
            case 3:
                color = Color.ORANGE;
                break;
            case 4:
                color = Color.CYAN;
                break;
            case 5:
                color = Color.RED;
                break;
            case 6:
                color = Color.MAGENTA;
                break;
            case 7:
                color = Color.WHITE;
                break;
            case 8:
                color = Color.LIGHT_GRAY;
                break;
            case 9:
                color = Color.PINK;
                break;
            default:
                break;
        }
        return color;
    }

    //start animation
    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(delay);

            for (int i = 0; i < cars.length; i++) {
                checkCollisions(cars[i]);
                ((Car)cars[i]).accelerate();
            }
        }
    }

    //compare with cells visited
    public void checkCollisions(Car car) {

        if(car.isCrashed()) {
            return;
        }

        int cCol = car.getRepresentation().getCol();
        int cRow = car.getRepresentation().getRow();


        if (grid.isCellVisited(cCol, cRow)) {
            System.out.println("CRASHED");
            car.crash();
        } else {
            grid.visitCell(cCol,cRow);
        }

        for (Car c : cars) {

            if (c == car) {
                continue;
            }
            //no point checking with self
            // TODO: override equals
            if (c.getRepresentation().samePos(car.getRepresentation())) {

                //make both crash
                c.crash();
                car.crash();
            }


        }
    }


}


