package yu.domain;

/**
 * @Auther: yusiming
 * @Date: 2018/7/30 17:21
 * @Description:
 */
public class Employee {
    private String name;
    private double salary;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}
