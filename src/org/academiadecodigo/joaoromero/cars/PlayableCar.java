package org.academiadecodigo.joaoromero.cars;

import org.academiadecodigo.joaoromero.KeyList;
import org.academiadecodigo.joaoromero.Playable;
import org.academiadecodigo.joaoromero.field.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

/**
 * Created by João Romero on 08/03/16.
 */
public class PlayableCar extends Car implements Playable {


    private Keyboard k;
    private KeyList keys;


    public PlayableCar(int speed, Grid grid, KeyList keys) {
        super(speed, grid);
        this.keys = keys;
    }

    public void keyConfig() {

        /*k = new Keyboard(this);

        KeyboardEvent eventUP = new KeyboardEvent();
        eventUP.setKey(keys.upKey());
        eventUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventUP);

        KeyboardEvent eventLEFT = new KeyboardEvent();
        eventLEFT.setKey(keys.leftKey());
        eventLEFT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventLEFT);

        KeyboardEvent eventRIGHT = new KeyboardEvent();
        eventRIGHT.setKey(keys.rightKey());
        eventRIGHT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventRIGHT);

        KeyboardEvent eventDOWN = new KeyboardEvent();
        eventDOWN.setKey(keys.downKey());
        eventDOWN.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventDOWN);

        */

    }


    //Todo: create method 'movePlayer()' that takes a dir & makes car move inside borders
    public void move() {

        //setDirection(d);

    }

    @Override
    public KeyList getKeys() {
        return keys;
    }
}


