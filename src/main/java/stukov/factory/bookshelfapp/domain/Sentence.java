package stukov.factory.bookshelfapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sentence {

     private Integer sentence_id;
     private String sentence_text;

     public Sentence() {}

     public Sentence(Integer sentence_id, String sentence_text) {

          this.sentence_id = sentence_id;
          this.sentence_text = sentence_text;
     }

     @Override
     public String toString() {
          return "Sentence{" +
                  "sentence_id=" + sentence_id +
                  ", sentence_text='" + sentence_text + '\'' +
                  '}';
     }
}
