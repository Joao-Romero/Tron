package org.academiadecodigo.joaoromero;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Grid g = new Grid(15, 600, 300);
        //g.init();

        Game g = new Game(800, 800, 40, 100);
        g.init(1);
        g.start();


    }
}
