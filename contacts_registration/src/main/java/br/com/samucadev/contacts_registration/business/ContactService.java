package br.com.samucadev.contacts_registration.business;

import br.com.samucadev.contacts_registration.infrastructure.entity.Contact;
import br.com.samucadev.contacts_registration.infrastructure.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public void saveContact(Contact contact) {
        repository.saveAndFlush(contact);
    }

    public Contact findContactById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado!"));
    }

    public List<Contact> findAllContacts() {
        return repository.findAll();
    }

    public void updateContactById(Contact contact, Long id) {
        Contact contactSearch = findContactById(id);
        Contact updatedContact = Contact.builder().
                id(id).
                name(contact.getName() != null ? contact.getName() : contactSearch.getName()).
                phoneNumber(contact.getPhoneNumber() != null ? contact.getPhoneNumber() : contactSearch.getPhoneNumber()).
                address(contact.getAddress() != null ? contact.getAddress() : contactSearch.getAddress()).
                build();

        repository.save(updatedContact);
    }

    public void deleteContactById(Long id) {
        repository.deleteById(id);
    }
}
