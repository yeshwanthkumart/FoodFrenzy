package com.example.demo.entities;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int u_id;

	@NotBlank(message = "Please enter your name.")
	@Size(max = 60, message = "Your name must be 60 characters or fewer.")
	private String uname;

	@NotBlank(message = "Please enter your email address.")
	@Email(message = "Please enter a valid email address.")
	private String uemail;

	@NotBlank(message = "Please choose a password.")
	@Size(min = 4, max = 72, message = "Your password must contain 4 to 72 characters.")
	private String upassword;

	@NotNull(message = "Please enter your phone number.")
	@Pattern(regexp = "[0-9]{10}", message = "Please enter a 10-digit phone number.")
	private String unumber;
	
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	
	public User() {

}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;

	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", uname=" + uname + ", uemail=" + uemail + ", upassword=" + upassword
				+ ", unumber=" + unumber + ", orders=" + orders + "]";
	}
	

	 public User(String uemail, String upassword) {
	        this.uemail = uemail;
	        this.upassword = upassword;
	    }

}
