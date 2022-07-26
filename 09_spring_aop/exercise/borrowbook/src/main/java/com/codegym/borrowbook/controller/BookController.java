package com.codegym.borrowbook.controller;

import com.codegym.borrowbook.model.Book;
import com.codegym.borrowbook.model.OderBook;
import com.codegym.borrowbook.service.IBookService;
import com.codegym.borrowbook.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IOderService iOderService;
    @Autowired
    private IBookService iBookService;

    @GetMapping("/book")
    public String getShowForm(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Book> list = iBookService.getAll(PageRequest.of(page, 4));
        model.addAttribute("listBook", list);
        return "list";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable String id, Model model) {
        model.addAttribute("book", iBookService.findByCodeBook(id));
        return "edit";
    }

    @PostMapping("/update")
    public String PostUpdate(@ModelAttribute(name = "book") Book book,RedirectAttributes redirectAttributes) {
        int idOderBook = (int) ((Math.random() * 90000) + 10000);
        String id = String.valueOf(idOderBook);
        iBookService.update(book);
        iOderService.create(id, book.getIdBook());
        redirectAttributes.addFlashAttribute("msg","Mượn sách thành công");
        return "redirect:/book";
    }

    @GetMapping("/return")
    public String showReturn(String id, RedirectAttributes redirectAttributes) {
        OderBook orderBook = iOderService.findIdOder(id);
        if (orderBook != null) {
            Book book = orderBook.getBooks();
            iBookService.returnBook(book);
            iOderService.delete(orderBook);
            redirectAttributes.addFlashAttribute("msg", "Trả sách thành công");
            return "redirect:/book";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không có mã mượn sách");
            return "/error";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handlerException() {
        return "error";
    }

}
