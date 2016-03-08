package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.joaoromero.cars.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Representation {

    private Grid grid;
    private Cell cell; //
    private int col;
    private int row;
    private Rectangle model;
    private Color color;

    //boolean[][] visited;

    public Rectangle getModel() {
        return model;
    }

    // constructs movable object (model) & gives it a random location on the grid
    public Representation(Grid grid) {

        //array of arrays with all the cells set to false (default): NUNO
        //visited = new boolean[grid.getWidth()][grid.getHeight()];

        this.grid = grid;
        col = (int) (Math.random() * grid.getCols());
        row = (int) (Math.random() * grid.getRows());

        model = new Rectangle(getX(), getY(), grid.getCellSize(), grid.getCellSize());

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

    public void draw() {
        model.setColor(color);
        model.fill();
    }

    public Grid getGrid() {
        return grid;
    }

    //tests if models have the same position
    public boolean samePos(Representation representation) {
        return col == representation.getCol() && row == representation.getRow();
    }


    public void moveNorth(int speed) {
        row -= speed;
        //add 1 to account for the turn image glitch
        model = new Rectangle(getX(), getY() - speed + 1, grid.getCellSize(), grid.getCellSize());
        //visited(getCol(), getRow()); NUNOs method
        leaveTrail();
    }

    public void moveSouth(int speed) {
        row += speed;
        //subtract 1 to account for the turn image glitch
        model = new Rectangle(getX(), getY() + speed - 1, grid.getCellSize(), grid.getCellSize());
        //visited(getCol(), getRow()); NUNOs method\
        leaveTrail();
    }

    public void moveEast(int speed) {
        col += speed;
        //subtract 1 to account for the turn image glitch
        model = new Rectangle(getX() + speed - 1, getY(), grid.getCellSize(), grid.getCellSize());
        //visited(getCol(), getRow()); NUNOs method
        leaveTrail();
    }

    public void moveWest(int speed) {
        col -= speed;
        //add 1 to account for the turn image glitch
        model = new Rectangle(getX() - speed + 1, getY(), grid.getCellSize(), grid.getCellSize());
        System.out.println("MOVE WEST - X = " + getX() + " SPEED = " + speed);
        //visited(getCol(), getRow()); NUNOs method
        leaveTrail();
    }

    private void leaveTrail() {
        model.setColor(color);
        model.fill();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //checks if model is on an edge && intends to get out of the field
    public boolean isOnEdge(Direction direction) {

        return (row == 0 && direction == Direction.NORTH ||
                row == grid.getRows() - 1 && direction == Direction.SOUTH ||
                col == grid.getCols() - 1 && direction == Direction.EAST ||
                col == 0 && direction == Direction.WEST);
    }

    //sets the visited cells to true (NUNOs method)
    /*private void visited(int x, int y){
        System.out.println(x + "---x    y--- " + y);
        this.visited[x][y] = true;
    }*/
}

