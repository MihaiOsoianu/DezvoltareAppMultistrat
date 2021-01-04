package com.example.tam1.model;

import lombok.Data;

@Data
public class IntrebareDto {

    private Integer idIntrebare;
    private String continut;
    private String A;
    private String B;
    private String C;
    private String D;
    private String raspunsCorect;

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

    public IntrebareDto(Integer idIntrebare, String continut, String a, String b, String c, String d, String raspunsCorect) {
        this.idIntrebare = idIntrebare;
        this.continut = continut;
        A = a;
        B = b;
        C = c;
        D = d;
        this.raspunsCorect = raspunsCorect;
    }
}
