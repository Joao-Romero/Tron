package org.academiadecodigo.joaoromero;

import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.joaoromero.field.Representation;
import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by João Romero on 12/02/16.
 */
public class Tester {

    public static void main(String[] args) {

        Grid g = new Grid(10, 100, 100);
        Representation r = new Representation(g);
        System.out.println("Row: " + r.getRow() + ";    Col: " + r.getCol() + ";     rect y: " + r.getModel().getY() + ";     rect x: " + r.getModel().getX() + "\n");

        r.moveNorth(1);
        System.out.println("Go North 1");
        System.out.println("Row: " + r.getRow() + ";    Col: " + r.getCol() + ";     rect y: " + r.getModel().getY() + ";     rect x: " + r.getModel().getX() + "\n");

        r.moveNorth(1000);
        System.out.println("Go North 1000");
        System.out.println("Row: " + r.getRow() + ";    Col: " + r.getCol() + ";     rect y: " + r.getModel().getY() + ";     rect x: " + r.getModel().getX() + "\n");



    }
}
