package frapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private UserRepository repository;
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    // save a couple of customers
    repository.save(new User("Alice", "Smith", "aliceSmith", "alice@smith.com", "password1", "01/01/2001"));
    repository.save(new User("Bob", "Smith", "bobSmith", "bob@smith.com", "password2", "02/02/2002"));
    repository.save(new User("Alice", "Doe", "aliceDoe", "alice@doe.com", "password3", "03/03/2003"));

    // fetch all customers
    System.out.println("Customers found with findAll():");
    System.out.println("-------------------------------");
    for (User customer : repository.findAll())
      System.out.println(customer);
    System.out.println();

    // fetch an individual customer
    System.out.println("Customer found with findByFirstName('Alice'):");
    System.out.println("--------------------------------");
    for (User customer : repository.findByFirstName("Alice"))
      System.out.println(customer);

    System.out.println("Customers found with findByLastName('Smith'):");
    System.out.println("--------------------------------");
    for (User customer : repository.findByLastName("Smith"))
      System.out.println(customer);
  }
}
