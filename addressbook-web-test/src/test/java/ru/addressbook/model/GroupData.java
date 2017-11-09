package ru.addressbook.model;

public class GroupData {
  private final String id;
  private final String Name;
  private final String Header;
  private final String Footer;

  public GroupData(String Name, String Header, String Footer) {
    this.id = null;
    this.Name = Name;
    this.Header = Header;
    this.Footer = Footer;
  }

  public GroupData(String id, String Name, String Header, String Footer) {
    this.id = id;
    this.Name = Name;
    this.Header = Header;
    this.Footer = Footer;
  }

  public String getId() {
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

    if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
    return Name != null ? Name.equals(groupData.Name) : groupData.Name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (Name != null ? Name.hashCode() : 0);
    return result;
  }
}
