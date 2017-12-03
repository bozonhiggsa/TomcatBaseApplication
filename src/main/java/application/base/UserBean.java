package application.base;

/**
 * Bean класс предметной области
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserBean {
    private String name = "Tom";
    private int age = 21;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
