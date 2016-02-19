package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by João Romero on 16/02/16.
 */
public class Cell {

    private boolean visited;
    private Rectangle square;

    public Cell (int x, int y, int cellSize) {
        square = new Rectangle(x, y, cellSize, cellSize);
        square.setColor(Color.DARK_GRAY);
    }

    public void visit() {
        this.visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public void draw() {
        square.draw();
    }


}
