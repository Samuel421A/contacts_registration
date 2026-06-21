package br.com.samucadev.contacts_registration.infrastructure.repository;

import br.com.samucadev.contacts_registration.infrastructure.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);
    void deleteById(Long id);
}
