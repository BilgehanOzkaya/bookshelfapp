package stukov.factory.bookshelfapp.dao;

import stukov.factory.bookshelfapp.domain.Paragraph;

import java.util.List;

public interface ParagraphDAO {

    Paragraph getParagraphById(Integer paragraph_id);

    List<Paragraph> getAllParagraphs();

    boolean deleteParagraph(Paragraph paragraph);

    boolean updateParagraph(Paragraph paragraph);

    boolean createParagraph(Paragraph paragraph);

}
