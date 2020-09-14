package quiztastic.ui;

import quiztastic.app.Quiztastic;
import quiztastic.core.Category;
import quiztastic.domain.Game;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Protocol {
    private final Quiztastic quiz;
    private final Scanner in;
    private final PrintWriter out;

    public Protocol(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
        this.quiz = Quiztastic.getInstance();
    }

    private String fetchCommand () {
        out.print("> ");
        out.flush();
        String line = in.nextLine().strip();
        return line;
    }

    private int displayBoard() {
        Game game = quiz.getCurrentGame();
        List<Integer> scores = List.of(100, 200, 300, 400, 500);
        out.println(quiz.getBoard());
        out.println(List.copyOf(scores));
        for (int questionNumber = 0; questionNumber < 5; questionNumber++) {
            out.print("");
            for (int category = 0; category < 6; category++) {
                out.print("    ");
                if (game.isAnswered(category, questionNumber)) {
                    out.print("---");
                } else {
                    System.out.println(scores.get(questionNumber));
                }
                out.print("         |");
            }
            out.println();
        }
        return 0;
    }

    private int chooseCategory(String cat){
        Map<String, Integer> options =
                Map.of("A", 0, "B",1,"C",2,"D",3,"E",4,"F",5);
        Integer i = options.get(cat);
        if (i == null) {
            out.println("Not a valid category: " + cat);
            i = -1;
        }
        return i;
    }

    private int chooseCategory2(String cat){
        switch (cat){
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            case "F": return 5;
            default:
                return -1;
        }
    }

    public void run () {
        String line = fetchCommand();
        while (!line.equals("quit")) {
            switch (line) {
                case "h":
                case "help":
                   out.println("Help commands: ");
                   out.println("Show board: b");
                   out.println("Choose question: c");
                   break;
                case "b":
                case "board":
                    out.print(displayBoard());
                    //out.println(quiz.getBoard());
                    break;
                case "c":
                case "choose":
                    out.println("Not implementet yet");
                    break;

                default:
                   out.println("Unknown command! " + line);
            }
            out.flush();
            line = fetchCommand();
        }

    }

}
