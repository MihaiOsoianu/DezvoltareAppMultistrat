package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "interviu")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Interviu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idInterviu")
    private Integer idInterviu;
    @Column(name = "tip")
    private String tip;
    @Column(name = "data")
    private Timestamp data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intervievator_id")
    private Intervievator intervievator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRezultat", referencedColumnName = "idRezultat")
    private Rezultat rezultat;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Integer getIdInterviu() {
        return idInterviu;
    }

    public void setIdInterviu(Integer idInterviu) {
        this.idInterviu = idInterviu;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Intervievator getIntervievator() {
        return intervievator;
    }

    public void setIntervievator(Intervievator intervievator) {
        this.intervievator = intervievator;
    }

    public Rezultat getRezultat() {
        return rezultat;
    }

    public void setRezultat(Rezultat rezultat) {
        this.rezultat = rezultat;
    }
}
