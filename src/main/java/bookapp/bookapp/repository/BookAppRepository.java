package bookapp.bookapp.repository;

import bookapp.bookapp.model.BookApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookAppRepository extends JpaRepository<BookApp, UUID> {
}
