package org.academiadecodigo.joaoromero.cars;

import org.academiadecodigo.joaoromero.KeyList;
import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by João Romero on 08/03/16.
 */
// before: implemented Playable
public class PlayableCar extends Car implements KeyboardHandler {


    private Keyboard k;
    private KeyList keys;


    public PlayableCar(int speed, Color color, Grid grid/*, KeyList keys*/) {
        super(speed, grid);
        setColor(color);
        //this.keys = keys;
    }

    public void initKeyboard() {
        keyConfig();
    }


    public void keyConfig() {

        k = new Keyboard(this);

        KeyboardEvent eventUP = new KeyboardEvent();
        eventUP.setKey(KeyboardEvent.KEY_UP); //eventUP.setKey(keys.upKey());
        eventUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventUP);

        KeyboardEvent eventLEFT = new KeyboardEvent();
        eventLEFT.setKey(KeyboardEvent.KEY_LEFT); //eventLEFT.setKey(keys.leftKey());
        eventLEFT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventLEFT);

        KeyboardEvent eventRIGHT = new KeyboardEvent();
        eventRIGHT.setKey(KeyboardEvent.KEY_RIGHT); //eventRIGHT.setKey(keys.rightKey());
        eventRIGHT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventRIGHT);

        KeyboardEvent eventDOWN = new KeyboardEvent();
        eventDOWN.setKey(KeyboardEvent.KEY_DOWN); //eventDOWN.setKey(keys.downKey());
        eventDOWN.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventDOWN);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (isCrashed() || getDirection() == null) {
            return;
        }
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                setDirection(Direction.NORTH);
                break;
            case KeyboardEvent.KEY_DOWN:
                setDirection(Direction.SOUTH);
                break;
            case KeyboardEvent.KEY_LEFT:
                setDirection(Direction.WEST);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setDirection(Direction.EAST);
                break;
        }

    }


    @Override
    public void move() {
        if (isCrashed() || getPosition().isOnEdge(getDirection())) {
            return;
        }

        visitCell();
        getRepresentation().move(getSpeed(),getDirection());
    }

    public boolean outOfField() {
        return (getRepresentation().isOnEdge(getDirection()));
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


   /*
    public void move() {
        //setDirection(direction);
    }

    @Override
    public KeyList getKeys() {
        return keys;
    }*/
}


