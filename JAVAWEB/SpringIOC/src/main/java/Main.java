import model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* @author: QuangNV51
* @since: 17/10/2022 15:43
* @description: Class demo IoC, DI and Bean with Spring
*/
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        User user = (User) applicationContext.getBean("User1");
//        System.out.println(user.toString());
        Customer customer = (Customer) applicationContext.getBean("Customer");
        System.out.println(customer.getAddress().toString());

        Customer customer1 = (Customer) applicationContext.getBean("Customer1");
        System.out.println(customer1.getAddress().getName());
    }
}
