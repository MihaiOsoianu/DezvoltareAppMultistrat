package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "intervievator")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Intervievator extends Persoana {

    @Column(name = "specializare")
    private String specializare;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "intervievator")
    private List<Interviu> listaInterviuri;

    //get+set

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

}
