package ru.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {

  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  private String Name;

  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  private String Header;

  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private String Footer;

  @ManyToMany(mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  public int getId() {
    return id;
  }

  public String getName() {
    return Name;
  }

  public String getHeader() {
    return Header;
  }

  public String getFooter() {
    return Footer;
  }

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }
  public GroupData withName(String name) {
    Name = name;
    return this;
  }
  public GroupData withHeader(String header) {
    Header = header;
    return this;
  }
  public GroupData withFooter(String footer) {
    Footer = footer;
    return this;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", Name='" + Name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return Name != null ? Name.equals(groupData.Name) : groupData.Name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (Name != null ? Name.hashCode() : 0);
    return result;
  }
}
