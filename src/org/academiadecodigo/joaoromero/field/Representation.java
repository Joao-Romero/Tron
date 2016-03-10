package org.academiadecodigo.joaoromero.field;

import org.academiadecodigo.joaoromero.cars.Car;
import org.academiadecodigo.joaoromero.cars.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Representation {

    public static final Color DEFAULT_COLOR = Color.BLUE;

    private GridPosition position;
    private Rectangle model;
    private Color currentColor;

    //boolean[][] visited;

    public Rectangle getModel() {
        return model;
    }

    // constructs movable object (model) & gives it a random location on the grid
    public Representation(Grid grid) {

        //array of arrays with all the cells set to false (default): NUNO
        //visited = new boolean[grid.getWidth()][grid.getHeight()];

        position = new GridPosition(grid);
        model = new Rectangle(position.getX(), position.getY(), grid.getCellSize(), grid.getCellSize());
        setColor(DEFAULT_COLOR);
    }

    public void draw() {
        model.fill();
    }

    //tests if models have the same position
    public boolean equals(Representation representation) {
        return position.equals(representation.getPosition());
    }

    public void move(int speed, Direction direction) {
        position.update(speed, direction);

        int dx = position.getX() - model.getX();
        int dy = position.getY() - model.getY();

        model.translate(dx, dy);
    }
    

    public void setColor(Color color) {
        currentColor = color;
        model.setColor(color);
    }

    public boolean isOnEdge(Direction direction) {
        return position.isOnEdge(direction);
    }

    public GridPosition getPosition() {
        return position;
    }

    public Color getColor() {
        return currentColor;
    }


    //sets the visited cells to true (NUNOs method)
    /*private void visited(int x, int y){
        System.out.println(x + "---x    y--- " + y);
        this.visited[x][y] = true;
    }*/
}

