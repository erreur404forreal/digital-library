package org.cereme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Library")
public class Library {

    @Id
    @GeneratedValue
    @Column
    private Integer libId;
    @Column
    private String libName;
    @Column
    private String city;
    //@OneToMany(fetch = FetchType.EAGER)
    //private List<Work> works;

    public Library(String libName, String city) {
        this.libName = libName;
        this.city = city;

    }

    public Library(){

    }

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
