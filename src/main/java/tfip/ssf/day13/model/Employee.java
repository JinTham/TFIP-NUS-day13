package tfip.ssf.day13.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {
    @NotEmpty(message = "First Name is a mandatory field")
    @Size(min=2,max=30,message="First Name must be between 2 to 30 characters")
    private String firstName;
    
    @NotEmpty(message = "Last Name is a mandatory field")
    @Size(min=2,max=30,message="Last Name must be between 2 to 30 characters")
    private String lastName;
    
    @Email(message = "Invalid email format")
    @Size(max=50)
    @NotBlank(message = "Email is a mandatory field")
    private String email;

    @Pattern(regexp = "[89][0-9]{7}",message="Invalid Phone number format")
    private String phone;

    @Min(value=1500,message="Must be higher than 1499")
    @Max(value=100000,message = "Must be lower than 100000")
    private Integer salary;

    @Past(message = "Birthday needs to be a past date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String address;

    @Digits(fraction=0,integer=6,message="Postal code format, i.e. 123456")
    private Integer postcode;

    //Constructor
    public Employee(String firstName, String lastName, String email, String phone, Integer salary, Date birthday,
            String address, Integer postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.postcode = postcode;
    }
    public Employee() {
    }

    //Getter & Setter
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPostcode() {
        return postcode;
    }
    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    //ToString
    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
                + ", salary=" + salary + ", birthday=" + birthday + ", address=" + address + ", postcode=" + postcode
                + "]";
    }
    
    //Methods

}
