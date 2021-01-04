package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "test_intrebare")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestIntrebare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTestIntrebare;

    @ManyToOne
    @JoinColumn(name = "idIntrebare")
    private Intrebare intrebare;

    @ManyToOne
    @JoinColumn(name = "idTest")
    private Test test;

    @Column(name = "punctaj")
    private Float punctaj;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Intrebare getIntrebare() {
        return intrebare;
    }

    public void setIntrebare(Intrebare intrebare) {
        this.intrebare = intrebare;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Float getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(Float punctaj) {
        this.punctaj = punctaj;
    }

    public TestIntrebare(Intrebare intrebare, Test test, Float punctaj) {
        this.intrebare = intrebare;
        this.test = test;
        this.punctaj = punctaj;
    }
}
