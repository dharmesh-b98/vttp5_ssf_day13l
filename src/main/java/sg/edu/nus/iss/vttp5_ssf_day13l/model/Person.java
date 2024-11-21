package sg.edu.nus.iss.vttp5_ssf_day13l.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;

public class Person {
    //@NotNull(message = "id must be auto generated")
    private String id;

    @NotEmpty(message = "FirstName is mandatory")
    @Size(min = 5, max = 60, message = "FirstName must be between 5 to 60 characters")
    private String firstName;

    @NotEmpty(message = "LastName is mandatory")
    @Size(min = 5, max = 60, message = "LastName must be between 5 to 60 characters")
    private String lastName;

    @Min(value = 1500, message = "Minimum salary is 1500")
    @Max(value = 50000, message = "Maximum salary is 50000")
    private Integer salary;

    @Email(message = "Email input does not conform to email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Past(message = "Birth date must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Pattern(regexp = "(8|9)([0-9]{7})" , message = "Phone number must start with 8 or 9 and have a total of 8 digits")
    private String telephone;

    @Digits(fraction = 0, integer = 6, message = "Postal code has to be 6 digits")
    @Min(value = 111111, message = "postal code has to be a number more than 111111")
    @Max(value = 999999, message = "postal code has to be a number less than 999999")
    private Integer postalcode;


    
    public Person() {
    }



    public Person(
            String firstName,
            String lastName,
            Integer salary,
            String email,
            Date dateOfBirth,
            String telephone,
            Integer postalcode) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.postalcode = postalcode;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Integer getSalary() {
        return salary;
    }



    public void setSalary(Integer salary) {
        this.salary = salary;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public Date getDateOfBirth() {
        return dateOfBirth;
    }



    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public String getTelephone() {
        return telephone;
    }



    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public Integer getPostalcode() {
        return postalcode;
    }



    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }



    



    

    

    
}
