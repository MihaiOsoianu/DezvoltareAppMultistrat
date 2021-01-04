package com.example.tam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "test")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTest;
    @Column(name = "subiect")
    private String subiect;
    @Column(name = "nume")
    private String nume;
    @Column(name = "punctajMaxim")
    private Float punctajMaxim;
    @Column(name = "punctajMinimNecesar")
    private Float punctajMinimNecesar;
    @Column(name = "nrIntrebari")
    private Integer nrIntrebari;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    private List<TestIntrebare> listaTestIntrebare;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    private List<Interviu> listaInterviuri;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getSubiect() {
        return subiect;
    }

    public void setSubiect(String subiect) {
        this.subiect = subiect;
    }

    public Float getPunctajMaxim() {
        return punctajMaxim;
    }

    public Float getPunctajMinimNecesar() {
        return punctajMinimNecesar;
    }

    public void setPunctajMaxim(Float punctajMaxim) {
        this.punctajMaxim = punctajMaxim;
    }

    public void setPunctajMinimNecesar(Float punctajMinimNecesar) {
        this.punctajMinimNecesar = punctajMinimNecesar;
    }

    public void setPunctaj(Float punctaj, Float min) {
        this.punctajMaxim = punctaj;
        this.punctajMinimNecesar = min;
    }

    public Integer getNrIntrebari() {
        return nrIntrebari;
    }

    public void setNrIntrebari(Integer nrIntrebari) {
        this.nrIntrebari = nrIntrebari;
    }

    public List<Intrebare> getListaIntrebari() {
        List<Intrebare> listaIntrebari = new ArrayList<Intrebare>();
        for (TestIntrebare testIntrebare : this.listaTestIntrebare){
            listaIntrebari.add(testIntrebare.getIntrebare());
        }
        return listaIntrebari;
    }

    public List<TestIntrebare> getListaTestIntrebare() {
        return listaTestIntrebare;
    }

    //    public HashMap<String, Float> getMapIntrebari(){
//        HashMap<String, Float> map = new HashMap<>();
//        for (TestIntrebare testIntrebare : this.listaTestIntrebare){
//            map.put(testIntrebare.getIntrebare().getContinut(), testIntrebare.getPunctaj());
//        }
//        return map;
//    }

    public void setListaTestIntrebare(List<TestIntrebare> listaTestIntrebare) {
        this.listaTestIntrebare = listaTestIntrebare;
    }

    public void addTestIntrebare(TestIntrebare testIntrebare){
        this.listaTestIntrebare.add(testIntrebare);
    }

}
