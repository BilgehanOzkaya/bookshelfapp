package stukov.factory.bookshelfapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String book_name, book_author, book_publisher, book_genre;
    private int book_id, chapter_id;

    public Book(){
    }

    public Book(String book_name, String book_author, String book_publisher, String book_genre, int book_id, int chapter_id) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
        this.book_genre = book_genre;
        this.book_id = book_id;
        this.chapter_id = chapter_id;
    }

}





