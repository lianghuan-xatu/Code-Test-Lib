package itcast.web.BeanUtilsTest;

public class User1 {
    private String name;
    private String password;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeHe() {
        return gender;
    }

    public void setHeHe(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
