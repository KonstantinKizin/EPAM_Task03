package entity;//а про уровни пакетов я Пушкину рассказывала?

public class User {

    private String name;
    private String sureName;
    private String phoneNumber;
    private String emailAdress;

    public User(String name, String sureName, String phoneNumber, String emailAdress) {
        this.name = name;
        this.sureName = sureName;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!sureName.equals(user.sureName)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        return emailAdress.equals(user.emailAdress);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + sureName.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + emailAdress.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }
}
