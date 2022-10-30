package packageTest;

/**
 *@author: QuangNV51
 *@version: 1.0
 *
 */
public class Dog  {
    private String name;
    private int age;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }

    /**
     * @return this name object
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return this age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param age
     * @return
     */
    public int totalAge(int age){
       return this.age = age+10;
    }
}
