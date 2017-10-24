package ru.addressbook.tests;


import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

public class ContactDelete extends Testbase {

  @Test
  public void contactDeleteTest() {
  app.getNavigationhelper().gotoHomePage();
  if (! app.getContacthelper().ThereAContact()) {
    app.getContacthelper().createContact(new ContactData(
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
                    "1991",
                    "123"),
            false);
  }
  app.getContacthelper().checkContact();
  app.getContacthelper().deleteContact();


  }


}
