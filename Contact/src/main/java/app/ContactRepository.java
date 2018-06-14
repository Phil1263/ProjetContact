package app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByLastName(String lastName);
    Optional<Contact> findById(long id);
}