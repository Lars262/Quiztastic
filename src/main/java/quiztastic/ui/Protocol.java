package quiztastic.ui;

import quiztastic.app.Quiztastic;
import quiztastic.domain.Game;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringWriter;
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
        String cmd = fetchCommand();
        while (!cmd.equals("quit")) {
            switch (cmd) {
                case "h":
                case "help":
                   out.println("Help commands: ");
                   out.println("Show board: b");
                   out.println("Choose question: c + category + score \n Example: A100");
                   break;
                case "b":
                case "board":
                    out.print(displayBoard());
                    //out.println(quiz.getBoard());
                    break;
                case "c":
                case "choose":
                    String question = in.next();
                    String a = question.substring(0, 1).toLowerCase(); // "A100" -> "a"
                    int questionScore = Integer.parseInt(question.substring(1)); // "A100" -> 100
                    //Hjæææælp
                    //answerQuestion(("abcdef".indexOf(a)), questionScore);
                    //break;
                    out.println("Not implementet yet");
                    break;

                default:
                    out.println("Unknown command! " + cmd);
            }
            in.nextLine();
            out.flush();
            cmd = fetchCommand();
        }

    }

}
