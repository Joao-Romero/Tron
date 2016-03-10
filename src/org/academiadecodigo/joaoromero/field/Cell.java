package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.joaoromero.cars.Movable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by João Romero on 16/02/16.
 */
public class Cell {

    private Movable visitor;
    private Rectangle square;

    public Cell(int x, int y, int cellSize) {
        square = new Rectangle(x, y, cellSize, cellSize);
        square.setColor(Color.DARK_GRAY);
    }

    public boolean visit(Movable visitor) {
        if (!isVisited()) {
            this.visitor = visitor;
            square.setColor(visitor.getColor());
            square.fill();
            return true;
        }

        return false;
    }

    public boolean isVisited() {
        return visitor != null;
    }

    public void draw() {
        square.draw();
    }


}
