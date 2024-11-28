package com.Hotel.Management.System.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.mapping.Property;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    //    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<State> states;
//
//    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Property> properties;
}
