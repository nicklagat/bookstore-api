package bookapp.bookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {

    private UUID uuid;
    private String title;
    private String author;
    private  String isbn;
    private String pages;
    private String price;



}
