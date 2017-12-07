package com.gabulcompany.gabul2.main;
//PROGRAMA FEITO POR GABRIEL SAVIO BARBOSA SAMPAIO 2016001503
import java.util.ArrayList;

public class Curso {

    private String nome;
    private ArrayList<String> professor;

    public Curso (String nome){
        this.nome = nome;
        professor = new ArrayList<String>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getProfessor() {
        return professor;
    }

    public void addProfessor(String professor) {
        this.professor.add(professor);
    }
}
