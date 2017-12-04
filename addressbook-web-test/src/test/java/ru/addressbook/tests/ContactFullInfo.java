package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactFullInfo extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
              .withHomeNumber("123123123").withMobNumber("213123123").withEmail1("sfdfdf@ssdfwdf.ty")
              .withNumberofSelector("2").withNumberOfpunkt("1").withNumberOfSelector2("2").withNumberOfpunkt2("2"));
    }
  }

  @Test
  public void testContactDetailsForm() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData editForm = app.contact().infoFromEditForm(contact);
    String details = app.contact().infoFromDetailForm(contact).getAllDetails();
    assertThat(cleaned(details), equalTo(mergeAllDetails(editForm)));
    }

  private String mergeAllDetails(ContactData contact) {
    return Arrays.asList(
            contact.getFirstname(),
            contact.getLastname(),
            contact.getAddress(),
            contact.getMobNumber(),
            contact.getHomeNumber(),
            contact.getEmail1(),
            contact.getEmail2())
            .stream()
            .filter((s) -> !s.equals(""))
            .map(ContactFullInfo::cleaned)
            .collect(Collectors.joining(""));

  }
  public static String cleaned(String string) {
   return string.replaceAll("M:", "")
           .replaceAll("H:", "")
           .replaceAll("W:", "")
           .replaceAll("\\s","")
           .replaceAll("-()","");
  }
}
