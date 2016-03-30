package org.academiadecodigo.joaoromero;

import org.academiadecodigo.joaoromero.cars.Car;
import org.academiadecodigo.joaoromero.cars.Movable;
import org.academiadecodigo.joaoromero.cars.PlayableCar;
import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.joaoromero.field.PlayerColor;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {

    //public static int NUMB_CARS_CREATED = 10;

    int delay;

    private ArrayList<Movable> cars;
    private PlayableCar myCar;
    private Grid grid;

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

        cars = new ArrayList<>();
        myCar = new PlayableCar(1, Color.YELLOW, grid);


        for (int i = 0; i < numbCarsCreated; i++) {
            Car c = new Car(1, grid);
            c.draw();

            // fazer este metodo funcionar
            // c.giveRandomColor();

            cars.add(c);
        }

        myCar.draw();
        cars.add(myCar);

    }

    //start animation
    public void start() throws InterruptedException {

        myCar.initKeyboard();

        Iterator<Movable> carIterator;

        while (true) {
            carIterator = cars.iterator();
            Thread.sleep(delay);

            while (carIterator.hasNext()) {
                checkCollisions(cars);
                carIterator.next().move();

            }

        }
    }

    //compare with cells visited
    public void checkCollisions(ArrayList<Movable> cars) {

        Iterator<Movable> mIterator1 = cars.iterator();
        Iterator<Movable> mIterator2;
        Movable m1;
        Movable m2;

        while (mIterator1.hasNext()) {
            m1 = mIterator1.next();

            if (m1.isCrashed()) {
                continue;
            }

            System.out.println(m1.getPosition().getCol() + " " + m1.getPosition().getRow());
            if (grid.isCellVisited(m1.getPosition())) {
                System.out.println("CRASHED");
                m1.crash();
            }

            mIterator2 = cars.iterator();
            while (mIterator2.hasNext()) {
                m2 = mIterator2.next();

                if (m2 == m1) {
                    continue;
                }

                if (m1.getPosition().equals(m2.getPosition())) {
                    m1.crash();
                    m2.crash();
                }
            }


        }



        /*int myCarCol = myCar.getRepresentation().getCol();
        int myCarRow = myCar.getRepresentation().getRow();

        if (grid.isCellVisited(myCarCol, myCarRow)) {
            System.out.println("CRASHED");
            myCar.crash();
        } else {
            grid.visitCell(myCarCol, myCarRow);
        }*/

    }


}


