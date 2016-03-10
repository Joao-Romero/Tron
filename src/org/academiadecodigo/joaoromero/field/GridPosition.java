package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.joaoromero.cars.Direction;

/**
 * Created by João Romero on 09/03/16.
 */
public class GridPosition {

    private int col;
    private int row;
    private Grid grid;


    public GridPosition(int col, int row, Grid grid) {
        this.grid = grid;

        this.col = col;
        this.row = row;
    }

    public GridPosition(Grid grid) {
        this.grid = grid;

        col = (int) (Math.random() * grid.getCols());
        row = (int) (Math.random() * grid.getRows());

        System.out.println("BORN IN COL " + col);
        System.out.println("BORN IN ROW " + row);
    }

    public boolean equals(GridPosition pos) {
        return (col == pos.getCol() &&
                row == pos.getRow());
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getX() {
        return col * grid.getCellSize();
    }

    public int getY() {
        return row * grid.getCellSize();
    }

    public void update(int speed, Direction direction) {
        switch (direction) {
            case NORTH:
                row -= speed;
                break;
            case SOUTH:
                row += speed;
                break;
            case EAST:
                col += speed;
                break;
            case WEST:
                col -= speed;
                break;
        }
    }

    //checks if model is on an edge && intends to get out of the field
    public boolean isOnEdge(Direction direction) {

        return (row == 0 && direction == Direction.NORTH ||
                row == grid.getRows() - 1 && direction == Direction.SOUTH ||
                col == grid.getCols() - 1 && direction == Direction.EAST ||
                col == 0 && direction == Direction.WEST);
    }
}
