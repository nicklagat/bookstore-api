package bookapp.bookapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookinventories")
public class BookApp {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String title;
    private String author;
    private String isbn;
    private String price;
    private String pages;
}
