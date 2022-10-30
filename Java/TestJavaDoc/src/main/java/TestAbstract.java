abstract class TestAbstract {
    private String name;
    private Integer age;
    static Integer count = 0;

    public TestAbstract() {
        count++;
    }

    public TestAbstract(String name, Integer age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    protected abstract void  voic();

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age
                ;
    }
}
