package ru.addressbook.model;

public class GroupData {
  private final String Name;
  private final String Header;
  private final String Footer;

  public GroupData(String Name, String Header, String Footer) {
    this.Name = Name;
    this.Header = Header;
    this.Footer = Footer;
  }

  public String getGroupName() {
    return Name;
  }

  public String getGroupHeader() {
    return Header;
  }

  public String getGroupFooter() {
    return Footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "Name='" + Name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return Name != null ? Name.equals(groupData.Name) : groupData.Name == null;
  }

  @Override
  public int hashCode() {
    return Name != null ? Name.hashCode() : 0;
  }
}
