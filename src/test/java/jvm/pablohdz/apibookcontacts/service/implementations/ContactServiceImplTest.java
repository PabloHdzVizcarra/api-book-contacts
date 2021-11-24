package jvm.pablohdz.apibookcontacts.service.implementations;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import jvm.pablohdz.apibookcontacts.mapper.ContactMapper;
import jvm.pablohdz.apibookcontacts.model.Contact;
import jvm.pablohdz.apibookcontacts.model.ContactDto;
import jvm.pablohdz.apibookcontacts.model.ContactRequest;
import jvm.pablohdz.apibookcontacts.repository.ContactRepository;
import jvm.pablohdz.apibookcontacts.service.ContactService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class ContactServiceImplTest
{
    ContactService contactService;
    @Mock
    private ContactRepository contactRepository;
    @Mock
    private ContactMapper contactMapper;

    @BeforeEach
    void setUp()
    {
        contactService = new ContactServiceImpl(contactRepository, contactMapper);
    }

    @Test
    void givenContact_whenSaveContact()
    {
        given(contactRepository.save(any()))
                .willReturn(createFullContact());
        given(contactMapper.contactToContactDto(createFullContact()))
                .willReturn(createFullContactDto());

        ContactDto dto = contactService.save(new ContactRequest(
                "james",
                "8744125672",
                "mobile"
        ));

        assertThat(dto)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }

    @NotNull
    private ContactDto createFullContactDto()
    {
        return new ContactDto(
                1L, "james", "8721569078", "mobile",
                LocalDateTime.now().toString(), LocalDateTime.now().toString()
        );
    }

    @NotNull
    private Contact createFullContact()
    {
        return new Contact(
                "james", "8721569078", "mobile");
    }
}