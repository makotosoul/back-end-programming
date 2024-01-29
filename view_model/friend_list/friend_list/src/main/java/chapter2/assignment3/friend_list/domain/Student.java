package chapter2.assignment3.friend_list.domain;

public class Student {
    private String name;
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Name: "+getName();
    }

}
