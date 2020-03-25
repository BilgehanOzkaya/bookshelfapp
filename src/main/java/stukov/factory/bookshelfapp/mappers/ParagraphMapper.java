package stukov.factory.bookshelfapp.mappers;

import org.springframework.jdbc.core.RowMapper;
import stukov.factory.bookshelfapp.domain.Paragraph;
import stukov.factory.bookshelfapp.domain.Sentence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParagraphMapper implements RowMapper<Paragraph> {

    int iteration_id=0;
    int previousparagraph_id=0;
    int currentparagraph_id=0;
    String previoussentence = "";
    String currentsentence;
    String paragraphsentence;
    String samepagaragraphsentence;
    String differentparagraphsentence;


    @Override
    public Paragraph mapRow(ResultSet rs, int i) throws SQLException {

        Paragraph paragraph = new Paragraph();

        currentparagraph_id = rs.getInt("paragraph_id");

        currentsentence=(rs.getString("sentence_text"));

        if (previousparagraph_id == rs.getInt("paragraph_id")){

            samepagaragraphsentence=previoussentence+currentsentence;

        }

        else if (previousparagraph_id<currentparagraph_id){

            paragraph.setParagraph_id(currentparagraph_id);
            paragraph.setParagraph_text(samepagaragraphsentence);

            previoussentence="";

        }
        


        previousparagraph_id = rs.getInt("paragraph_id");

        previoussentence = previoussentence+rs.getString("sentence_text");




        return paragraph;
    }
}
