package quiztastic.entries;

import quiztastic.app.MapQuestionRepository;
import quiztastic.app.QuestionReader;
import quiztastic.core.Board;
import quiztastic.domain.BoardController;
import quiztastic.domain.QuestionRepository;

import java.io.InputStream;
import java.io.InputStreamReader;

public class DisplayBoard {
    private final BoardController boardController;

    public DisplayBoard() {
        InputStream s = this.getClass()
                .getClassLoader()
                .getResourceAsStream("master_season1-35clean.tsv");
        QuestionReader reader = new QuestionReader(new InputStreamReader(s));
        QuestionRepository questionRepository =
                MapQuestionRepository.fromQuestionReader(reader);
        this.boardController = new BoardController(questionRepository);
    }

    public void displayBoard () {
        Board board = boardController.makeBoard();
        System.out.println(board);
    }

    public static void main(String[] args) {
        new DisplayBoard().displayBoard();
    }
}
