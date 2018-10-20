package frapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class User {
  @Id
  public String id;

  private String userName;
  private String password;

  private String firstName;
  private String lastName;

  private Date dateOfBirth;
  private String email;

  public User() {}

  public User(String firstName, String lastName, String userName, String email, String password, String dob) {
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password; // need to encrypt this

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    try {
      this.dateOfBirth = sdf.parse(dob);
    } catch (ParseException pe) { System.out.println("Date not correctly formatted.");}
  }

  public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public String getUserName() { return userName; }

  public void setFirstName(String newName) { firstName = newName; }
  public void setLastName(String newName) { lastName = newName; }
  public void setFirstNameAndLastName(String newFirst, String newLast) {
    firstName = newFirst;
    lastName = newLast;
  }

  @Override
  public String toString() {
    return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
  }
}