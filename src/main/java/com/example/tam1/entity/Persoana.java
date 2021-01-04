package com.example.tam1.entity;

//import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPersoana")
    private Integer idPersoana;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    //get+set

    public Integer getIdPersoana() {
        return idPersoana;
    }

    public void setIdPersoana(Integer idPersoana) {
        this.idPersoana = idPersoana;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTotNume() { return prenume + " " +nume; }

}
