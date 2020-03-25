package stukov.factory.bookshelfapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import stukov.factory.bookshelfapp.domain.Paragraph;
import stukov.factory.bookshelfapp.mappers.ParagraphMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ParagraphDAOImpl implements ParagraphDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_PSJ = "select psj.paragraph_id, psj.sentence_id, p.p_cardinality, s.s_cardinality, s.sentence_text " +
            "from psj inner join  (select sentence_id, sentence_text, s_cardinality from sentence) s on psj.sentence_id = s.sentence_id " +
            "inner join (select paragraph_id, p_cardinality from paragraph) p on psj.paragraph_id = p.paragraph_id";

    private final String SQL_FIND_PARAGRAPH = " WHERE paragraph_id = ? ";
    private final String SQL_DELETE_PARAGRAPH = " DELETE FROM paragraph WHERE paragraph_id = ? ";
    private final String SQL_UPDATE_PARAGRAPH = " UPDATE paragraph SET sentence_id? WHERE sentence_id = ? ";
    private final String SQL_GET_ALL_PARAGRAPHS = " SELECT * FROM paragraph ";
    private final String SQL_INSERT_PARAGRAPH = "INSERT INTO paragraph (paragraph_id) VALUES(?)";

    @Autowired
    public ParagraphDAOImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public Paragraph getParagraphById(Integer paragraph_id) {
        return null;
    }

    @Override
    public List<Paragraph> getAllParagraphs() {
        return jdbcTemplate.query(SQL_PSJ, new ParagraphMapper());
    }

    @Override
    public boolean deleteParagraph(Paragraph paragraph) {
        return false;
    }

    @Override
    public boolean updateParagraph(Paragraph paragraph) {
        return false;
    }

    @Override
    public boolean createParagraph(Paragraph paragraph) {
        return false;
    }
}
