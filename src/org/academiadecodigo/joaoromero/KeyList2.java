package org.academiadecodigo.joaoromero;

import org.academiadecodigo.joaoromero.cars.Direction;

/**
 * Created by João Romero on 30/03/16.
 */
public class KeyList2 {

    private Key[] keys;

    public KeyList2(Key[] keys) {
        this.keys = keys;
    }

    public Key[] getKeys() {
        return keys;
    }



    // Inner class Key
    public class Key {

        public final int CODE;
        public final Direction DIRECTION;


        public Key(int KEY_CODE, Direction direction) {
            this.CODE = KEY_CODE;
            this.DIRECTION = direction;
        }

    }

}
