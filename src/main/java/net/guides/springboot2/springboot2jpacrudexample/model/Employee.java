package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")

public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
    private String dob;
    private String gender;
    private String mobileno;
    public Employee() {
  
    }
    
 
public Employee(String firstName, String lastName, String emailId, String address, String dob,
			String gender, String mobileno) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.mobileno = mobileno;
	}


//    public Employee(String firstName, String lastName, String emailId) {
//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.emailId = emailId;
//         
//    }
public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}

@Column(name = "first_name", nullable = false)
public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}

@Column(name = "last_name", nullable = false)
public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Column(name = "email_address", nullable = false)
public String getEmailId() {
	return emailId;
}


public void setEmailId(String emailId) {
	this.emailId = emailId;
}

@Column(name = "address", nullable = false)
public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}

@Column(name = "dob", nullable = false)
public String getDob() {
	return dob;
}


public void setDob(String dob) {
	this.dob = dob;
}

@Column(name = "gender", nullable = false)
public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}

@Column(name = "mobile_no", nullable = false)
public String getMobileno() {
	return mobileno;
}


public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
			+ ", address=" + address + ", dob=" + dob + ", gender=" + gender + ", mobileno=" + mobileno + "]";
}
}



    
//        public long getId() {
//        return id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
// 
//    @Column(name = "first_name", nullable = false)
//    public String getFirstName() {
//        return firstName;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
// 
//    @Column(name = "last_name", nullable = false)
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
// 
//    @Column(name = "email_address", nullable = false)
//    public String getEmailId() {
//        return emailId;
//    }
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }

   
  

