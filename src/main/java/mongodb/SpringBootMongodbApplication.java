package mongodb;

import mongodb.dao.CustomerRepository;
import mongodb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动mongodb
 * C:\Program Files\MongoDB\Server\3.4\bin
 * mongod.exe --dbpath E:\mongdb\data\db
 *
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/28
 * @Description
 */
@SpringBootApplication
public class SpringBootMongodbApplication implements CommandLineRunner {


    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }

    /**
     * Customers found with findAll():
     -------------------------------
     Customer[id=58f880f589ffb696b8a6077e, firstName='Alice', lastName='Smith']
     Customer[id=58f880f589ffb696b8a6077f, firstName='Bob', lastName='Smith']

     Customer found with findByFirstName('Alice'):
     --------------------------------
     Customer[id=58f880f589ffb696b8a6077e, firstName='Alice', lastName='Smith']
     Customers found with findByLastName('Smith'):
     --------------------------------
     Customer[id=58f880f589ffb696b8a6077e, firstName='Alice', lastName='Smith']
     Customer[id=58f880f589ffb696b8a6077f, firstName='Bob', lastName='Smith']
     */
}
