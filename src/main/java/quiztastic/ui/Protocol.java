package quiztastic.ui;

import quiztastic.app.Quiztastic;
import quiztastic.core.Board;
import quiztastic.core.Category;
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
