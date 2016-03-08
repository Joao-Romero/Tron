package org.academiadecodigo.joaoromero;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by João Romero on 08/03/16.
 */
public class KeyboardController implements KeyboardHandler {

    private Keyboard k;

    private Playable p1;
    private Playable p2;


    public KeyboardController() {

        k = new Keyboard(this);

    }

    public void setPlayer1(Playable p1) {
        this.p1 = p1;
    }

    public void setPlayer2(Playable p2) {
        this.p2 = p2;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
