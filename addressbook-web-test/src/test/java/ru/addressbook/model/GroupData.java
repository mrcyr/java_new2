package ru.addressbook.model;

public class GroupData {
  private int id;
  private final String Name;
  private final String Header;
  private final String Footer;

  public GroupData(String Name, String Header, String Footer) {
    this.id = 0;
    this.Name = Name;
    this.Header = Header;
    this.Footer = Footer;
  }

  public GroupData(int id, String Name, String Header, String Footer) {
    this.id = id;
    this.Name = Name;
    this.Header = Header;
    this.Footer = Footer;
  }

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

  public void setId(int id) {
    this.id = id;
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
