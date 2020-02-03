package stukov.factory.bookshelfapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paragraph {

    private Integer paragraph_id;
    private String paragraph_text;

    public Paragraph() { }

    public Paragraph(Integer paragraph_id, String paragraph_text) {
        this.paragraph_id = paragraph_id;
        this.paragraph_text = paragraph_text;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "paragraph_id=" + paragraph_id +
                ", paragraph_text='" + paragraph_text + '\'' +
                '}';
    }
}
