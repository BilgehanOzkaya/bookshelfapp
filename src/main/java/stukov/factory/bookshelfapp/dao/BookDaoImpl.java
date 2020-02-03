package stukov.factory.bookshelfapp.dao;

import com.google.gson.Gson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import stukov.factory.bookshelfapp.domain.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookDaoImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

    public BookDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    @Override
//    public void saveOrUpdate(Book book) {
//
//        if (book.getBook_id() > 0) {
//            //Update
//            String sql = "UPDATE book SET book_name=?, book_author=?, book_publisher=?, chapter_id=?, book_genre=?" + "WHERE book_id=?";
//            jdbcTemplate.update(sql, book.getBook_id(), book.getChapter_id(), book.getBook_name(), book.getBook_author(), book.getBook_publisher(), book.getBook_genre());
//
//        } else {
//            // insert
//            String sql = "INSERT INTO book (book_id, chapter_id, book_name, book_author,book_publisher, book_genre)"
//                    + " VALUES (?, ?, ?, ?, ?)";
//            jdbcTemplate.update(sql, book.getBook_id(), book.getChapter_id(), book.getBook_name(), book.getBook_author(), book.getBook_publisher(), book.getBook_genre());
//        }
//
//    }

    @Override
    public Book saveBook(int book_id) {

        Book book = new Book();

                    String sql = "INSERT INTO book (book_id, chapter_id, book_name, book_author,book_publisher, book_genre)"
                    + " VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, book.getBook_id(), book.getChapter_id(), book.getBook_name(), book.getBook_author(), book.getBook_publisher(), book.getBook_genre());
        return book;
    }

    @Override
    public Book updateBook(int book_id) {

        Book book = new Book();

        String sql = "UPDATE book SET book_name=?, book_author=?, book_publisher=?, chapter_id=?, book_genre=?" + "WHERE book_id=?";
            jdbcTemplate.update(sql, book.getBook_id(), book.getChapter_id(), book.getBook_name(), book.getBook_author(), book.getBook_publisher(), book.getBook_genre());
            
        return null;
    }

    @Override
    public void delete(int book_id) {

        String sql = "DELETE FROM book where book_id=?";
        jdbcTemplate.update(sql, book_id);

    }

    @Override
    public Book getById(int book_id) {

        String sql = "SELECT * FROM book WHERE book_id=" + book_id;
        return (Book) jdbcTemplate.query(sql, (ResultSetExtractor) (rs) -> {
            if (rs.next()) {
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setChapter_id(rs.getInt("chapter_id"));
                book.setBook_name(rs.getString("book_name"));
                book.setBook_author(rs.getString("book_author"));
                book.setBook_publisher(rs.getString("book_publisher"));
                book.setBook_genre(rs.getString("book_genre"));
                return book;
            }
            return null;
        });
    }

    @Override
    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();

//        try{
//            Connection con = DB.getCon();
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM book");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Book aBook = new Book();
//            aBook.setBook_id(rs.getInt("book_id"));
//            aBook.setChapter_id(rs.getInt("chapter_id"));
//            aBook.setBook_name(rs.getString("book_name"));
//            aBook.setBook_author(rs.getString("book_author"));
//            aBook.setBook_publisher(rs.getString("book_publisher"));
//            list.add(aBook);
//            }
//            con.close();
//        }catch (Exception e){
//            System.out.println(e);}
//
//        return list;



        String sql = "SELECT * FROM book";
        List<Book> bookList = jdbcTemplate.query(sql, (RowMapper) (rs, rowNum) -> {

            Book aBook = new Book();
            aBook.setBook_id(rs.getInt("book_id"));
            aBook.setChapter_id(rs.getInt("chapter_id"));
            aBook.setBook_name(rs.getString("book_name"));
            aBook.setBook_author(rs.getString("book_author"));
            aBook.setBook_publisher(rs.getString("book_publisher"));
            aBook.setBook_genre(rs.getString("book_genre"));
            return aBook;

        });

        return bookList;
    }
}
