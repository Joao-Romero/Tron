package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public final class Grid {

    private int BORDER_SIZE = 0;
    private int cellSize;
    private int cols;
    private int rows;
    private Rectangle field;
    private Cell[] cells;


    public Grid(int cellSize, int width, int height) {
        this.cellSize = cellSize;

        cols = width / cellSize;
        rows = height / cellSize;

        cells = new Cell[cols * rows];
    }

    public Rectangle getField() {
        return field;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getWidth() {
        return cols * cellSize;
    }

    public int getHeight() {
        return rows * cellSize;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    //initializes the game field, with the grid
    public void init() {

        field = new Rectangle(BORDER_SIZE, BORDER_SIZE, getWidth(), getHeight());
        field.setColor(Color.BLACK);
        field.fill();

        createGrid();
    }

    //creates the grid shown on the game field
    private void createGrid() {

        Cell cell;
        int count = 0;

        // run every column and row and draw cells
        for (int i = 0; i < cols; i++) {
            int x = BORDER_SIZE + cellSize * i;
            for (int j = 0; j < rows; j++) {
                int y = BORDER_SIZE + cellSize * j;
                cell = new Cell(x, y, cellSize);
                cell.draw();
                cells[count] = cell;
                count++;
            }
        }
    }

    public void visitCell(int col, int row) {
        getCellFromIndex(col, row).visit();
    }

    // TODO: make indexOf(col,row) private method

    //returns cell state: visited or !visited (T/F)
    public boolean isCellVisited(int col, int row) {
        return getCellFromIndex(col, row).isVisited();
    }

    private Cell getCellFromIndex(int col, int row) {
        return cells[col * rows + row];
    }

}

