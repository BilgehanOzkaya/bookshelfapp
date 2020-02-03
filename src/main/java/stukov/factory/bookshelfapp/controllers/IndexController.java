package stukov.factory.bookshelfapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stukov.factory.bookshelfapp.dao.BookDao;
import stukov.factory.bookshelfapp.dao.SentenceDao;

@Slf4j
@Controller
public class IndexController {

    private final BookDao bookDao;

    private final SentenceDao sentenceDao;

    public IndexController(BookDao bookDao, SentenceDao sentenceDao) {
        this.bookDao = bookDao;
        this.sentenceDao = sentenceDao;
    }

    @RequestMapping({"/index/books"})
    public String getBookIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("books",bookDao.getBooks());

        return  "bookindex";
    }
    @RequestMapping({"/index/sentences"})
    public String getSentenceIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("sentences", sentenceDao.getAllSentences());

        return "sentenceindex";
    }
}
