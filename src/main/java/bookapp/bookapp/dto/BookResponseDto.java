package bookapp.bookapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private UUID uuid;
    private String title;
    private String author;
    private String price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String isbn;

}
