package com.gabulcompany.gabul2.main;
//PROGRAMA FEITO POR GABRIEL SAVIO BARBOSA SAMPAIO 2016001503
import java.util.ArrayList;

public class Docentes {

    private String nome;
    private String curso;

    private ArrayList<Disciplina> disciplinas;

    public Docentes(String nome){//Construtor com parametro
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplinas(Disciplina disciplina_Ministrou) {
       disciplinas.add(disciplina_Ministrou);
    }

}
