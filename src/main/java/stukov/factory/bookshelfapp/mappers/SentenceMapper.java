package stukov.factory.bookshelfapp.mappers;

import org.springframework.jdbc.core.RowMapper;
import stukov.factory.bookshelfapp.domain.Sentence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SentenceMapper implements RowMapper<Sentence> {
    @Override
    public Sentence mapRow(ResultSet rs, int i) throws SQLException {

        Sentence sentence = new Sentence();
        sentence.setSentence_id(rs.getInt("sentence_id"));
        sentence.setSentence_text(rs.getString("sentence_text"));
        return sentence;
    }
}
