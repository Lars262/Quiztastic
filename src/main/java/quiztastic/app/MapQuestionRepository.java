package quiztastic.app;

import quiztastic.core.Category;
import quiztastic.core.Question;
import quiztastic.domain.QuestionRepository;

import java.util.HashMap;
import java.util.List;

public class MapQuestionRepository implements QuestionRepository {
    private final HashMap<Category, List<Question>> questionsByCategory;

    public MapQuestionRepository(HashMap<Category, List<Question>> questionsByCategory) {
        this.questionsByCategory = questionsByCategory;
    }

    public static MapQuestionRepository fromQuestionReader(QuestionReader reader) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public List<Category> getCategories() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public List<Question> getQuestionsWithCategory(Category category) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
