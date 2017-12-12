package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactForm extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("dsdsd").withLastname("dsfdsf").withAddress("dfsdfdsf")
              .withHomeNumber("123123123").withMobNumber("213123123").withEmail1("sfdfdf@ssdfwdf.ty"));
    }
  }

  @Test(enabled = false)
  public void testContactPhone() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  @Test(enabled = false)
  public void testContactEmail () {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  @Test(enabled = false)
  public void testContactAddress() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getFullAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  @Test(enabled = false)
  public void testContactDetailsForm() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData editForm = app.contact().infoFromEditForm(contact);
    String details = app.contact().infoFromDetailForm(contact).getAllDetails();
    assertThat(cleaned(details), equalTo(mergeAllDetails(editForm)));
  }

  private String mergeAllDetails(ContactData contact) {
    return Stream.of(
            contact.getFirstname(),
            contact.getLastname(),
            contact.getAddress(),
            contact.getMobNumber(),
            contact.getHomeNumber(),
            contact.getEmail1(),
            contact.getEmail2())
            .filter((s) -> !s.equals(""))
            .map(ContactForm::cleaned)
            .collect(Collectors.joining(""));
  }

  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail1(), contact.getEmail2()).filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Stream.of(contact.getHomeNumber(), contact.getMobNumber()).filter((s) -> ! s.equals(""))
            .map(ContactForm::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String string) {
    return string.replaceAll("M:", "")
            .replaceAll("H:", "")
            .replaceAll("W:", "")
            .replaceAll("\\s","")
            .replaceAll("-()","");
  }
}
