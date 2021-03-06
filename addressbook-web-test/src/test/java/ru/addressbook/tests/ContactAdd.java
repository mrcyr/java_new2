package ru.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactAdd extends Testbase {

  @DataProvider
  public Iterator<Object[]> validContactsCSV() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))){
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[] {new ContactData().withFirstname(split[0])
                .withLastname(split[1])
                .withAddress(split[2])
                .withMobNumber(split[3])
                .withEmail1(split[4])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsXML() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsJSON() throws IOException {
   try(BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contacts.json")))){
     String json = "";
     String line = reader.readLine();
     while (line != null) {
       json += line;
       line = reader.readLine();
     }
     Gson gson = new Gson();
     List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
     return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
   }
  }

  @Test(dataProvider = "validContactsJSON")
  public void ContactAddTest(ContactData contacts) {
    app.goTo().home();
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/7Lj6myuF0cA.jpg");
    contacts.withPhoto(photo);
    app.contact().create(contacts);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(
            before.withAdded(contacts.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();
  }
}

