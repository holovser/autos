package diploma.autos.gateway.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    private String role;

    public Role() {
    }

    @OneToMany(fetch = FetchType.EAGER)
    private Set<User> user;

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
