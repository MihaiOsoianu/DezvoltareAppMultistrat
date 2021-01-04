package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "intrebare")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Intrebare
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idIntrebare;
    @Column(name = "continut")
    private String continut;
    @Column(name = "A")
    private String A;
    @Column(name = "B")
    private String B;
    @Column(name = "C")
    private String C;
    @Column(name = "D")
    private String D;
    @Column(name = "raspunsCorect")
    private String raspunsCorect;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "intrebare")
    private List<TestIntrebare> listaTestIntrebare;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public Integer getIdIntrebare() {
        return idIntrebare;
    }

    public void setIdIntrebare(Integer idIntrebare) {
        this.idIntrebare = idIntrebare;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getRaspunsCorect() {
        return raspunsCorect;
    }

    public void setRaspunsCorect(String raspunsCorect) {
        this.raspunsCorect = raspunsCorect;
    }

}
