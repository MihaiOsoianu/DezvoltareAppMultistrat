package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "candidat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Candidat extends Persoana {

    @Column(name = "email")
    private String email;
    @Column(name = "telefon")
    private String telefon;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "candidat")
    private List<Interviu> listaInterviuri;


    //get+set

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }



}
