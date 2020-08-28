package quiztastic.app;

import quiztastic.core.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

/**
 * The Question Reader should read the questions from a file.
 */
public class QuestionReader {
    private final BufferedReader reader;
    private int lineCounter = 0;

    public QuestionReader(BufferedReader reader) {
        this.reader = reader;
    }

    public QuestionReader(Reader reader) {
        this(new BufferedReader(reader));
    }

    public Question readQuestion() throws IOException, ParseException {
        String line = reader.readLine();
        if (line == null) {
        }
        lineCounter += 1;
        if (line == null) {
            return null;
        } else {
            String[] fields = line.split("\t");
            if (fields.length != 4) {
                throw new ParseException(
                        "Expected 4 fields, got " + fields.length,
                        lineCounter);
            }
            try {
                int score = Integer.parseInt(fields[0]);
                return new Question(score);
            } catch (NumberFormatException e) {
                throw new ParseException(
                        "Expected and integer in field 1, but got \"" + fields[0] + "\"",
                        lineCounter);
            }
        }
    }

}
