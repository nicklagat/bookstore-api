package bookapp.bookapp.service;

import bookapp.bookapp.dto.BookRequestDto;
import bookapp.bookapp.dto.BookResponseDto;
import bookapp.bookapp.model.BookApp;
import bookapp.bookapp.repository.BookAppRepository;
import jakarta.persistence.Cacheable;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookAppService {

    private final BookAppRepository bookAppRepository;

    @Autowired
    public BookAppService(BookAppRepository bookAppRepository) {
        this.bookAppRepository = bookAppRepository;
    }


    // CRUD Operation

    public BookResponseDto saveBook(BookRequestDto bookRequestDto){
        BookApp bookToSave = bookDtoToEntity(bookRequestDto);
        BookApp savedBook = bookAppRepository.save(bookToSave);

        return bookEntityToDto(savedBook);

    }



    public List<BookResponseDto> getBooks(){

        List<BookApp> bookApps = bookAppRepository.findAll();

        log.info("Getting the books from the database");
        System.out.println(bookApps);

       return bookApps.stream().map(this::bookEntityToDto)
               .collect(Collectors.toList());




    }

    public BookResponseDto getABook(UUID uuid){

        BookApp bookApp = bookAppRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("Book with UUID " + uuid + " not found"));

        return bookEntityToDto(bookApp);


    }

    public String deleteBook(UUID uuid){
        BookApp bookApp = bookAppRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("Book with UUID " + uuid + " not found"));

        String message = "The book titled '" + bookApp.getTitle() + "' with UUID " + uuid + " has been deleted.";

        bookAppRepository.delete(bookApp);

        return  message;


    }


    // Converting the BookRequestDto to a Book Entity
    private BookApp bookDtoToEntity(BookRequestDto bookRequestDto) {
        BookApp bookApp = new BookApp();
        bookApp.setTitle(bookRequestDto.getTitle());
        bookApp.setAuthor(bookRequestDto.getAuthor());
        bookApp.setPages(bookRequestDto.getPages());
        bookApp.setPrice(bookRequestDto.getPrice());
        bookApp.setIsbn(bookRequestDto.getIsbn());

        return bookApp;

    }


    // Converting the Book Entity to a BookResponseDto
    private BookResponseDto bookEntityToDto(BookApp bookApp){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setUuid(bookApp.getUuid());
        bookResponseDto.setTitle(bookApp.getTitle());
        bookResponseDto.setAuthor(bookApp.getAuthor());
        bookResponseDto.setPrice(bookApp.getPrice());

        return bookResponseDto;
    }
}
