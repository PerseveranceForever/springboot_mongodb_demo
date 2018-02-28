package mongodb.dao;

import java.util.List;

import mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/28
 * @Description
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    /**
     * firstName查找Customer
     *
     * @param firstName
     * @return
     */
    Customer findByFirstName(String firstName);

    /**
     * 查找包含lastName的Customer
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);

}