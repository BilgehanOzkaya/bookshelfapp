package stukov.factory.bookshelfapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import stukov.factory.bookshelfapp.domain.Sentence;
import stukov.factory.bookshelfapp.mappers.SentenceMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
public class SentenceDaoImpl implements SentenceDao {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_SENTENCE = "SELECT * FROM sentence WHERE sentence_id = ?";
    private final String SQL_DELETE_SENTENCE = "DELETE FROM sentence where sentence_id = ?";
    private final String SQL_UPDATE_SENTENCE = "UPDATE sentence SET sentence_text=? WHERE sentence_id=?";
    private final String SQL_GET_ALL_SENTENCES = "SELECT * FROM sentence";
    private final String SQL_INSERT_SENTENCE = "INSERT INTO sentence(sentence_id, sentence_text) VALUES(?,?)";

    @Autowired
    public SentenceDaoImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public Sentence getSentenceById(Integer sentence_id) {
        return jdbcTemplate.queryForObject(SQL_FIND_SENTENCE, new Object[] {sentence_id}, new SentenceMapper());
    }

    @Override
    public List<Sentence> getAllSentences() {
        return jdbcTemplate.query(SQL_GET_ALL_SENTENCES,new SentenceMapper());
    }

    @Override
    public boolean deleteSentence(Sentence sentence) {
        return jdbcTemplate.update(SQL_DELETE_SENTENCE, sentence.getSentence_id()) > 0;
    }

    @Override
    public boolean updateSentence(Sentence sentence) {
        return jdbcTemplate.update(SQL_UPDATE_SENTENCE, sentence.getSentence_text(), sentence.getSentence_id()) >0;
    }

    @Override
    public boolean createSentence(Sentence sentence) {
        return jdbcTemplate.update(SQL_INSERT_SENTENCE, sentence.getSentence_id(), sentence.getSentence_text()) > 0;
    }
}
