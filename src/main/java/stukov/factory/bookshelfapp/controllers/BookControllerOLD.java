//package stukov.factory.bookshelfapp.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import stukov.factory.bookshelfapp.dao.BookDao;
//import stukov.factory.bookshelfapp.domain.Book;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.List;
//
//public class BookControllerOLD {
//
//    @Autowired
//    private BookDao bookDao;
//
//
//    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
//    public ModelAndView newContact(ModelAndView model) {
//        Book newBook = new Book();
//        model.addObject("book", newBook);
//        model.setViewName("BookForm");
//        return model;
//    }
//
//    @RequestMapping(value = "/saveBook",method = RequestMethod.POST)
//    public ModelAndView saveBook(@ModelAttribute Book book) {
//        bookDao.saveOrUpdate(book);
//        return new ModelAndView("redirect:/");
//    }
//
//    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
//    public ModelAndView deleteBook(HttpServletRequest request) {
//        int book_id = Integer.parseInt(request.getParameter("id"));
//        bookDao.delete(book_id);
//        return new ModelAndView("redirect:/");
//    }
//
//    @RequestMapping(value = "/editBook",method = RequestMethod.GET)
//    public ModelAndView editBook(HttpServletRequest request) {
//        int book_id = Integer.parseInt(request.getParameter("id"));
//        Book book = bookDao.getById(book_id);
//        ModelAndView model = new ModelAndView("BookForm");
//        model.addObject("book",book);
//        return model;
//    }
//
//}
