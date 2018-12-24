package org.cereme.model;

import javax.persistence.*;

@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User{

    @Id
    @GeneratedValue(generator="gen_user", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen_user", sequenceName="seq_user", allocationSize=1)
    private Integer iduser;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
