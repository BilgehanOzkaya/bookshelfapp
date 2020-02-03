package stukov.factory.bookshelfapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stukov.factory.bookshelfapp.dao.BookDao;
import stukov.factory.bookshelfapp.domain.Book;

@Slf4j
@Controller
public class BookController {

    private static final String BOOK_BOOKFORM_URL = "book/bookform";
    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("book/{book_id}/show")
    public String showById(@PathVariable Integer book_id, Model model){

        model.addAttribute("book",bookDao.getById(book_id));

        return "book/show";
    }

    @GetMapping("book/new")
    public String newBook(@PathVariable Integer book_id,Model model) {

        model.addAttribute("book",bookDao.saveBook(book_id));

        return BOOK_BOOKFORM_URL;
    }

    @GetMapping("book/{book_id}/update")
    public String updateBook(@PathVariable Integer book_id, Model model) {

        model.addAttribute("book",bookDao.updateBook(book_id));

        return BOOK_BOOKFORM_URL;
    }

    @GetMapping("book/{book_id}/delete")
    public String deleteById(@PathVariable Integer book_id) {
        bookDao.delete(book_id);
        return "redirect:/";
    }
}



