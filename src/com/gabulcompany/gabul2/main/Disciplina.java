package com.gabulcompany.gabul2.main;
//PROGRAMA FEITO POR GABRIEL SAVIO BARBOSA SAMPAIO 2016001503
import java.util.ArrayList;

public class Disciplina {

    private String nome;
    private ArrayList <Discentes> alunos;
    private ArrayList <String> professores;
    public Disciplina(String nome){//Construtor "Default"
        alunos = new ArrayList<Discentes>();
        professores = new ArrayList<String>();
        this.nome = nome;
    }

    public Disciplina(String nome,ArrayList<Discentes> alunos){//Construtor com o alunos ja inseridos
        this.nome = nome;
        professores = new ArrayList<String>();
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Discentes> getAlunos() {
        return alunos;
    }

    public void addAlunos(Discentes alunos) {
        this.alunos.add(alunos);
    }

    public void removeAlunos(int i) {
        this.alunos.remove(i);
    }

    public ArrayList<String> getProfessores() {
        return professores;
    }

    public void addProfessores(String professores) {
        this.professores.add(professores);
    }
}
