import java.util.ArrayList;
import java.util.List;

public class Test extends TestAbstract{
    private String birthDay;

    public Test() {
    }

    @Override
    protected void voic() {

    }


    public Test(String name, Integer age, String birthDay) {
        super(name, age);
        this.birthDay = birthDay;
    }


    public String getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Test{" +
                "birthDay='" + birthDay +", " +super.toString();
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public static void main(String[] args) {
        TestAbstract testAbstract = new Test();
        testAbstract.setAge(12);
        testAbstract.setName("Nguyen Van Quang");
        List<TestAbstract> testAbstractList = new ArrayList<>();
        testAbstractList.add(testAbstract);
        for (int i=0;i<testAbstractList.size();i++){
            System.out.println(testAbstractList.get(i).getName());
        }
        System.out.println(TestAbstract.count);
    }
}
