package frapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MongoRepository<User, String> {
  public User findByUserName(@Param("user") String userName);
  public List<User> findByFirstName(@Param("firstName") String firstName);
  public List<User> findByLastName(@Param("lastName") String lastName);
  public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
