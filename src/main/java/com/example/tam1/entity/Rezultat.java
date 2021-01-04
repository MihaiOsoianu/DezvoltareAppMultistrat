package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rezultat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rezultat
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRezultat;
    @Column(name = "punctaj")
    private Float punctaj;
    @OneToOne(mappedBy = "rezultat")
    private Interviu interviu;
    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Integer getIdRezultat() {
        return idRezultat;
    }

    public void setIdRezultat(Integer idRezultat) {
        this.idRezultat = idRezultat;
    }

    public Float getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(Float punctaj) {
        this.punctaj = punctaj;
    }

}
