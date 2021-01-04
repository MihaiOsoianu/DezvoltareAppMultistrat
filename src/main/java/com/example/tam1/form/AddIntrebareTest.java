package com.example.tam1.form;

import com.example.tam1.entity.Intrebare;
import com.example.tam1.entity.Test;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.List;

public class AddIntrebareTest {

    @NotNull
    private Integer idIntrebare;

    @NotNull
    private Integer idTest;

    @NotNull
    private Float punctaj;

   private List<Intrebare> intrebari;
   private Test test;
   public AddIntrebareTest(List<Intrebare> intrebari, Test test) {
       this.intrebari = intrebari;
       this.test = test;
       //this.punctaj = punctaj;
   }

    public Integer getIdIntrebare() {
        return idIntrebare;
    }

    public void setIdIntrebare(Integer idIntrebare) {
        this.idIntrebare = idIntrebare;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public List<Intrebare> getIntrebari() {
        return intrebari;
    }

    public void setIntrebari(List<Intrebare> intrebari) {
        this.intrebari = intrebari;
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
}
