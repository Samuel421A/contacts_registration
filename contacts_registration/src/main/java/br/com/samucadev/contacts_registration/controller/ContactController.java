package br.com.samucadev.contacts_registration.controller;

import br.com.samucadev.contacts_registration.business.ContactService;
import br.com.samucadev.contacts_registration.infrastructure.entity.Contact;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContactController {
    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> saveContact(@RequestBody Contact contact) {
        service.saveContact(contact);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Contact> findContactById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findContactById(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Contact>> findAllContacts() {
        return ResponseEntity.ok(service.findAllContacts());
    }

    @PutMapping
    public ResponseEntity<Void> updateContactById(@RequestBody Contact contact, @RequestParam Long id) {
        service.updateContactById(contact, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteContactById(@RequestParam Long id) {
        service.deleteContactById(id);
        return ResponseEntity.ok().build();
    }
}
