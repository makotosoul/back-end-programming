package chapter2.assignment2.handling_lists.domain;

public class Student {
    private String lastName;
    private String firstName;
    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String toString() {
        return "last name = "+getLastName()+"first name = "+getFirstName();
    }

}
