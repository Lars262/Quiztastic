package quiztastic.entries;

import quiztastic.app.Quiztastic;
import quiztastic.ui.Protocol;

public class DisplayBoard {
    public static void main(String[] args) {
        Quiztastic quiz = Quiztastic.getInstance();
        System.out.println(quiz.getBoard());
    }
}
