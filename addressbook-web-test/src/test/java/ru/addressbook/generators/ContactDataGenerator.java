package ru.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
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

  @Parameter(names = "-d", description = "Format file")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCSV(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXML(contacts, new File(file));
    } else {
      System.out.println("Хз, что за формат " + format);
    }
  }

  private List<ContactData> generateContacts(int count) {

    List<ContactData> contacts = new ArrayList<ContactData>();

    for (int i = 0; i < count; i++) {

      contacts.add(new ContactData()
              .withFirstname(String.format("Ваня %s", i))
              .withLastname(String.format("Петров %s", i))
              .withAddress(String.format("Питер %s", i))
              .withMobNumber(String.format("12312312313 %s", i))
              .withEmail1(String.format("123%s@.ru", i)));

    }
    return contacts;
  }

  private void saveAsCSV(List<ContactData> contacts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;\n",
              contact.getFirstname(),
              contact.getLastname(),
              contact.getAddress(),
              contact.getMobNumber(),
              contact.getEmail1()));
    }
    writer.close();
  }

  private void saveAsXML(List<ContactData> contacts, File file) throws IOException {

    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    xstream.alias("contact", ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }
}