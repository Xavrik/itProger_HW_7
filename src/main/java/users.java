import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "users")
public class users implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name ="username",unique = true, nullable = false)
    private String username;

    @Column(name = "age", nullable = false)
    private int age;

    public users(){

    }

    public users(String username, int age){
        this.username = username;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
