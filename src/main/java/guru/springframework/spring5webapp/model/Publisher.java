package guru.springframework.spring5webapp.model;

import javax.persistence.*;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String name;
    String address;

    public Publisher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
