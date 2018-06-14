package app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotNull
    @Size(min=2, max=30)
    private String firstName, lastName;
    
    @Size(min=10, max=10)
    private String numberPhone;
    
    @NotNull
	@Size(min=4, max=50)
    private String email;
    
    protected Contact() {}
    
    public Contact(Long id, String firstName, String lastName, String numberPhone, String email) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public Contact(String firstName, String lastName, String numberPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.email = email;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public String getNumberPhone() {
    	return this.numberPhone;
    }
    
    public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
    
    public String getEmail() {
    	return this.email;
    }
    
	public void setEmail(String email) {
		this.email = email;
	}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
        return "Contact(Prénom: " + this.firstName + ", Nom: "+ this.lastName + ", Numero telephone: " + this.numberPhone + ", Email: " + this.email + ")";
    }
	public String getUrlDelete() {
		return "location.href='/delete/"+this.id+"'";
	}
	
	public String getUrlModify() {
		return "location.href='/form/"+this.id+"'";
	}

}
