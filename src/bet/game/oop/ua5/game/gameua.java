package bet.game.oop.ua5.game;

import bet.game.oop.ua5.gra.*;

/**
 *
 * @author  betmka.
 */


public class gameua {


    static void taomenu() {

    }

    static void taoframe() {
        bframe frame = new bframe();
        int testframe = frame.betframe();
        if(testframe != 0){
            System.out.println("test frame failed");
        }

    }

    public static void main(String[] args) {
        taoframe();

}
}