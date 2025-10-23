package ua.opnu.bill;

public class Employee {

  private String name;

  public Employee(String name) {
    setName(name);
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }
}