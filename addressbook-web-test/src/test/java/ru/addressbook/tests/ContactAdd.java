package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

public class ContactAdd extends Testbase {
  @Test
  public void Contact() {
    app.getContacthelper().addContact();
    app.getContacthelper().fillCotactInfo(new ContactData(
            "Petr",
            "Petrov",
            "Chetkiy",
            "Lala co.",
            "Tamtam",
            "123123123",
            "1",
            "4",
            "2",
            "9",
            "1991"));
    app.getContacthelper().gotoHome();

  }

}