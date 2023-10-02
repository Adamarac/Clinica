package com.bean;

import java.util.Calendar;
import java.sql.Time;

public class beanPaciente {
    
     private int id, medRes;
     private String nome, rg, cpf, end, tel, quarto, andar;
     private Calendar dataNasc;
     private Time horaVis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedRes() {
        return medRes;
    }

    public void setMedRes(int medRes) {
        this.medRes = medRes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Time getHoraVis() {
        return horaVis;
    }

    public void setHoraVis(Time horaVis) {
        this.horaVis = horaVis;
    }
     
    
    
     
     
}
