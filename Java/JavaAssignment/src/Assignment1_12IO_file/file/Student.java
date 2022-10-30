package Assignment1_12IO_file.file;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Student implements Serializable, Comparable<Student> {
    private String MSSV;
    private String name;
    private String phone;
    private String email;

    public Student(String MSSV, String name, String phone, String email) {
        this.MSSV = MSSV;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  MSSV + ", " + name + ", " + phone + ", " + email ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(MSSV, student.MSSV) && Objects.equals(name, student.name) && Objects.equals(phone, student.phone) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MSSV, name, phone, email);
    }

    public Student() {
    }


    @Override
    public int compareTo(Student o) {
        if (!(this.getName().compareTo(o.getName())==0)){
            return this.getName().compareTo(o.getName());
        }
        else {
            return o.getEmail().compareTo(this.email);
        }
    }

}
