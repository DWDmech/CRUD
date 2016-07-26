package entity;


import java.io.Serializable;

import javax.persistence.*;



@Entity(name = "users")
public class User  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Override
	public String toString() {
		return "User [id = " + id 
				+ ", firstName = " + firstName 
				+ ", lastName = " + lastName 
				+ ", email = " + email
				+ ", phone = " + phone + "]";
	}

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
}