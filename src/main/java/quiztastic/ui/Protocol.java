package quiztastic.ui;

import quiztastic.app.Quiztastic;
import quiztastic.core.Board;
import quiztastic.core.Category;
import quiztastic.core.Question;
import quiztastic.domain.Game;
import quiztastic.entries.DisplayBoard;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
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

    private void displayBoard() {
        Game game = quiz.getCurrentGame();
        List<Integer> scores = List.of(100, 200, 300, 400, 500);
        for (int questionNumber = 0; questionNumber < 5; questionNumber++) {
            out.print("");
            for (int category = 0; category < 6; category++) {
                out.print("    ");
                if (game.isAnswered(category, questionNumber)) {
                    out.print("---");
                } else {
                    out.println(scores.get(questionNumber));
                }
                out.print("     |");
            }
            out.println();
        }
    }

    public void run () {
        String line = fetchCommand();
        while (!line.equals("quit")) {
            switch (line) {
                case "h":
                case "help":
                   out.println("Help commands");
                   out.println("Show board: b");
                   out.println("Choose question: c");
                   break;
                case "b":
                    out.println(quiz.getBoard());
                    break;
                case "c":
                    out.println("Not implementet yet");
                    break;
                case "A1":
                    out.println("question 100");
                    break;
                case "A2":
                    break;
                default:
                   out.println("Unknown command! " + line);
            }
            out.flush();
            line = fetchCommand();
        }

    }

}
