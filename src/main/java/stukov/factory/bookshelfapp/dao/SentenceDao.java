package stukov.factory.bookshelfapp.dao;

import stukov.factory.bookshelfapp.domain.Sentence;

import java.util.List;

public interface SentenceDao {

   Sentence getSentenceById(Integer sentence_id);

   List<Sentence> getAllSentences();

   boolean deleteSentence(Sentence sentence);

   boolean updateSentence(Sentence sentence);

   boolean createSentence(Sentence sentence);

}
