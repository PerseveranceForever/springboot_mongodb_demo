package mongodb.model;

import org.springframework.data.annotation.Id;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/28
 * @Description
 */
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}