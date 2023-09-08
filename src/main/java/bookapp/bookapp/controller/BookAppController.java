package bookapp.bookapp.controller;

import bookapp.bookapp.dto.BookRequestDto;
import bookapp.bookapp.dto.BookResponseDto;
import bookapp.bookapp.model.BookApp;
import bookapp.bookapp.service.BookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bookz")
public class BookAppController {

    private final BookAppService bookAppService;

    @Autowired
    public BookAppController(BookAppService bookAppService) {
        this.bookAppService = bookAppService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookAppService.saveBook(bookRequestDto);
    }


    @GetMapping("/getBooks")
    public List<BookResponseDto> getBooks() {
        return bookAppService.getBooks();
    }

    @GetMapping("/getBooks/{uuid}")
    public BookResponseDto getBookById(@PathVariable UUID uuid) {

        return bookAppService.getABook(uuid);

    }

    @DeleteMapping("/deleteBook/{uuid}")
    public String deleteBook(@PathVariable UUID uuid){
       return bookAppService.deleteBook(uuid);
    }
}
