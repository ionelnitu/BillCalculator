package main;

public class Person {
    private String user_name;
    private String password;
    private Double oldIndex;
    private Double newIndex;

    public Person(){

    }

    public Person(String user_name, String password, Double oldIndex, Double newIndex) {
        this.user_name = user_name;
        this.password = password;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(Double oldIndex) {
        this.oldIndex = oldIndex;
    }

    public Double getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(Double newIndex) {
        this.newIndex = newIndex;
    }
}
