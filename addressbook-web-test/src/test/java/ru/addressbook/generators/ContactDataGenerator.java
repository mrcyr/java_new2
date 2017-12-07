package ru.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contacts count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main (String [] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }  catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts, new File(file));
  }

  private void save(List<ContactData> contacts, File file) throws IOException {

    Writer writer  = new FileWriter(file);
    for(ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;\n",
              contact.getFirstname(),
              contact.getLastname(),
              contact.getAddress(),
              contact.getMobNumber(),
              contact.getEmail1()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {

    List<ContactData> contacts = new ArrayList<ContactData>();

    for(int i = 0; i < count; i++) {

      contacts.add(new ContactData()
              .withFirstname(String.format("Ваня %s", i))
                      .withLastname(String.format("Петров %s", i))
                              .withAddress(String.format("Питер %s", i))
                                      .withMobNumber(String.format("12312312313 %s", i))
                                              .withEmail1(String.format("123%s@.ru", i)));

    }
    return contacts;
  }
}
