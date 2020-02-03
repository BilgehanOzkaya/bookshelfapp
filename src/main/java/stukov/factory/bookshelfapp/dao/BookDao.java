package stukov.factory.bookshelfapp.dao;

import stukov.factory.bookshelfapp.domain.Book;

import java.util.List;


public interface BookDao {

//    public void saveOrUpdate(Book book);

    public Book saveBook(int book_id);

    public Book updateBook(int book_id);

    public void delete(int book_id);

    public Book getById(int book_id);

    public List<Book> getBooks();

}


