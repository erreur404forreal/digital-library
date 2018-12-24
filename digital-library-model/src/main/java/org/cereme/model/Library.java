package org.cereme.model;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<Work> works;

    public Library(String libName, String city, List<Work> works) {
        this.libName = libName;
        this.city = city;
        this.works = works;
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

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }
}
