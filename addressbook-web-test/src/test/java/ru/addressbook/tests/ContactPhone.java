package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhone extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
              .withHomeNumber("123123123").withEmail("sfdfdf@ssdfwdf.ty").withNumberofSelector("2").withNumberOfpunkt("1")
              .withNumberOfSelector2("2").withNumberOfpunkt2("2"));
    }
  }
  @Test
  public void contactPhoneTest() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHomeNumber(), equalTo(cleaned(contactInfoFromEditForm.getHomeNumber())));
    assertThat(contact.getMobNumber(), equalTo(cleaned(contactInfoFromEditForm.getMobNumber())));
  }
  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "")
            .replaceAll("[-()]", "");
  }
}
