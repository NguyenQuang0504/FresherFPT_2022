import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("A");
        String string = "A";
        StringBuilder stringBuilder1 = new StringBuilder("A");
        String string1 = new String("A");
        System.out.println("So sanh 2 stringBuilder: " +stringBuilder1.equals(stringBuilder));
        System.out.println("So sanh 2 String: " +string1.equals(string));
        System.out.println("So sanh String va StringBuilder: " +string1.equals(stringBuilder));
        System.out.println(stringBuilder==stringBuilder1);
        System.out.println("hasCode() truoc khi noi chuoi cua StringBuilder: " +stringBuilder.hashCode());
        stringBuilder = stringBuilder.append("d");
        System.out.println("hasCode() sau khi noi chuoi cua StringBuffer: " +stringBuilder.hashCode());
        System.out.println("hasCode() truoc khi noi chuoi cua String: " +string.hashCode());
        string = string +"ss";
        System.out.println("hasCode() sau khi noi chuoi cua String: " +string.hashCode());
        Pattern pattern = Pattern.compile("Nguyend");
        Matcher matcher = pattern.matcher("Nguyen Van Quang");
        boolean check = matcher.find();
        System.out.println(check);

        TestAbstract testAbstract = new Test();
        testAbstract.setName("Nguyen Quang");
        testAbstract.setAge(22);
        if (testAbstract instanceof Test){
            Test test = (Test) testAbstract;
            test.setBirthDay("20000504");
        }
        System.out.println(testAbstract.toString());
    }
}
