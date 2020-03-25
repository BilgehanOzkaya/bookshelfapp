package stukov.factory.bookshelfapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stukov.factory.bookshelfapp.dao.BookDao;
import stukov.factory.bookshelfapp.dao.ParagraphDAO;
import stukov.factory.bookshelfapp.dao.SentenceDao;

@Slf4j
@Controller
public class IndexController {

    private final BookDao bookDao;

    private final SentenceDao sentenceDao;

    private final ParagraphDAO paragraphDAO;

    public IndexController(BookDao bookDao, SentenceDao sentenceDao, ParagraphDAO paragraphDAO) {
        this.bookDao = bookDao;
        this.sentenceDao = sentenceDao;
        this.paragraphDAO = paragraphDAO;
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
    @RequestMapping({"/index/paragraphs"})
    public String getParagraphIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("paragraphs", paragraphDAO.getAllParagraphs());

        return "paragraphindex";
    }
}
