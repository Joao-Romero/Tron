package org.academiadecodigo.joaoromero;

import org.academiadecodigo.joaoromero.cars.Car;
import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

    //public static int NUMB_CARS_CREATED = 10;

    int delay;

    Car[] cars;

    Grid grid;

    public Game (int width, int height, int cellSize, int delay) {
        grid = new Grid(cellSize, width, height);
        this.delay = delay;
    }

    public void init (int numbCarsCreated) {
        grid.init();

        cars =  new Car[numbCarsCreated];

        for (int i = 0; i < cars.length; i++) {
            //cars[i] = CarFactory.getNewCar();
            cars[i] = new Car(1, grid);
        }
    }

    //start animation
    public void start() throws InterruptedException {
         while (true) {
             Thread.sleep(delay);

             for (int i = 0; i < cars.length; i++) {
                 cars[i].move();


                 checkCollisions(cars[i]);
             }
         }
    }

    //compare with cells visited
    public void checkCollisions (Car car) {
        for (Car cc : cars) {

            //System.out.println("test");
            if (car.getRepresentation().getGrid().isCellVisited(car.getRepresentation().getCol(), car.getRepresentation().getRow())) {
                car.crash();
                car.getRepresentation().getModel().setColor(Color.RED);
            }
            //no point checking with self
            if (cc == car) {
                continue;
            }
            if (cc.getRepresentation().samePos(car.getRepresentation())) {
                //make both crash
                cc.crash();
                cc.getRepresentation().getModel().setColor(Color.RED);

                car.crash();
                car.getRepresentation().getModel().setColor(Color.RED);
            }


        }
    }


}


