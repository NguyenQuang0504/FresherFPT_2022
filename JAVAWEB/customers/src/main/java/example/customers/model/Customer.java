package example.customers.model;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerBirthDay;
    private String customerEmail;

    public Customer() {
    }

    public Customer(String customerName, String customerBirthDay, String customerEmail) {
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerEmail = customerEmail;
    }

    public Customer(int customerId, String customerName, String customerBirthDay, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerEmail = customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
