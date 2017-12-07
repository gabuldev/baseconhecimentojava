package com.gabulcompany.gabul2.main;


//PROGRAMA FEITO POR GABRIEL SAVIO BARBOSA SAMPAIO 2016001503

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormMain {
    private JComboBox comboBoxab;
    private JButton letraAButton;
    private JButton letraBButton;
    private JComboBox comboBoxc;
    private JButton letraCButton;
    private JComboBox comboBoxd;
    private JButton letraDButton;
    private JComboBox comboBoxe1;
    private JComboBox comboBoxe2;
    private JButton pesquisarButton;
    private JPanel panel;
    private JButton carregarButton;
    private JButton configuraçõesButton;
    private static JFrame frame;
    //VARIAVEL DE CONTROLE DO SISTEMA

    //  OS DOIS ARRAY SAO CARREGADOS COM DADOS EM UM ARQUIVO .SAV
    private ArrayList<Docentes> docentes;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Curso> cursos;
    private ArrayList<Discentes> discentes;

    public FormMain(ArrayList<Docentes> docentes,ArrayList<Disciplina> disciplina, ArrayList<Curso> curso, JFrame frame,ArrayList<Discentes> discentes){
        this.docentes = docentes;
        this.disciplinas = disciplina;
        this.cursos = curso;
        this.frame = frame;
        this.discentes = discentes;

        CarregarComboBoxs();
        letraAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String disciplinas = "";
                JFrame frame = new JFrame();
                if(docentes.isEmpty() != true) {
                    for (int i = 0; i < docentes.get(comboBoxab.getSelectedIndex()).getDisciplinas().size(); i++) {

                        disciplinas += "  " + docentes.get(comboBoxab.getSelectedIndex()).getDisciplinas().get(i).getNome() + ";";

                    }

                    JOptionPane.showMessageDialog(frame,"O " + docentes.get(comboBoxab.getSelectedIndex()).getNome() + " ministra/ministrou as disciplinas: " + disciplinas);
                }

            }
        });
        letraBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();

                JOptionPane.showMessageDialog(frame,"O " + docentes.get(comboBoxab.getSelectedIndex()).getNome() + " pertence ao curso: " + docentes.get(comboBoxab.getSelectedIndex()).getCurso());
            }
        });
        letraCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String professores = "";
                if (cursos.isEmpty() != true) {
                    for (int i = 0; i < cursos.get(comboBoxc.getSelectedIndex()).getProfessor().size(); i++) {

                        professores += " " + cursos.get(comboBoxc.getSelectedIndex()).getProfessor().get(i) + " ; ";
                    }

                    JOptionPane.showMessageDialog(frame, "O curso de " + cursos.get(comboBoxc.getSelectedIndex()).getNome() + " tem os seguintes professores: " + professores);
                }
            }
        });
        letraDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String professores = " ";

                if(disciplinas.isEmpty() != true){

                    for(int i = 0; i < disciplinas.get(comboBoxd.getSelectedIndex()).getProfessores().size() ; i++){
                        professores += " " + disciplinas.get(comboBoxd.getSelectedIndex()).getProfessores().get(i) + " ; ";
                    }

                    JOptionPane.showMessageDialog(frame,"Na disciplina : " + disciplinas.get(comboBoxd.getSelectedIndex()).getNome() + " ministraram/ministra os professores : " + professores);
                }


            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String alunos = " ";

                if(docentes.isEmpty() != true){

                    for(int i = 0 ;i < docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().get(comboBoxe2.getSelectedIndex()).getAlunos().size();i++){
                        alunos += " " + docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().get(comboBoxe2.getSelectedIndex()).getAlunos().get(i).getNome() + " ; ";
                    }

                    JOptionPane.showMessageDialog(frame,"Os alunos são : " + alunos);
                }
            }
        });
        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model_e2 = new DefaultComboBoxModel();

                for(int i = 0; i < docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().size();i++){
                    model_e2.addElement(docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().get(i).getNome());
                }
                comboBoxe2.setModel(model_e2);
            }
        });
        configuraçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new FormConfig(docentes,cursos,disciplinas,frame,discentes).getPanelconfig());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }//fim

    public FormMain(){
        docentes = new ArrayList<Docentes>();
        disciplinas  = new ArrayList<Disciplina>();
        cursos = new ArrayList<Curso>();
        discentes = new ArrayList<Discentes>();

        //testdados();
        CarregarComboBoxs();
        letraAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String disciplinas = "";
                JFrame frame = new JFrame();
                if(docentes.isEmpty() != true) {
                    for (int i = 0; i < docentes.get(comboBoxab.getSelectedIndex()).getDisciplinas().size(); i++) {

                        disciplinas += "  " + docentes.get(comboBoxab.getSelectedIndex()).getDisciplinas().get(i).getNome() + ";";

                    }

                    JOptionPane.showMessageDialog(frame,"O " + docentes.get(comboBoxab.getSelectedIndex()).getNome() + " ministra/ministrou as disciplinas: " + disciplinas);
                }

            }
        });
        letraBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();

                JOptionPane.showMessageDialog(frame,"O " + docentes.get(comboBoxab.getSelectedIndex()).getNome() + " pertence ao curso: " + docentes.get(comboBoxab.getSelectedIndex()).getCurso());
            }
        });
        letraCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String professores = "";
                if (cursos.isEmpty() != true) {
                    for (int i = 0; i < cursos.get(comboBoxc.getSelectedIndex()).getProfessor().size(); i++) {

                        professores += " " + cursos.get(comboBoxc.getSelectedIndex()).getProfessor().get(i) + " ; ";
                    }

                    JOptionPane.showMessageDialog(frame, "O curso de " + cursos.get(comboBoxc.getSelectedIndex()).getNome() + " tem os seguintes professores: " + professores);
                }
            }
        });
        letraDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String professores = " ";

                if(disciplinas.isEmpty() != true){

                    for(int i = 0; i < disciplinas.get(comboBoxd.getSelectedIndex()).getProfessores().size() ; i++){
                        professores += " " + disciplinas.get(comboBoxd.getSelectedIndex()).getProfessores().get(i) + " ; ";
                    }

                    JOptionPane.showMessageDialog(frame,"Na disciplina : " + disciplinas.get(comboBoxd.getSelectedIndex()).getNome() + " ministraram/ministra os professores : " + professores);
                }


            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String alunos = " ";

                if(docentes.isEmpty() != true){

                    for(int i = 0 ;i < docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().get(comboBoxe2.getSelectedIndex()).getAlunos().size();i++){
                        alunos += " " + docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().get(comboBoxe2.getSelectedIndex()).getAlunos().get(i).getNome() + " ; ";
                    }

                    JOptionPane.showMessageDialog(frame,"Os alunos são : " + alunos);
                }
            }
        });
        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model_e2 = new DefaultComboBoxModel();

                for(int i = 0; i < docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().size();i++){
                    model_e2.addElement(docentes.get(comboBoxe1.getSelectedIndex()).getDisciplinas().get(i).getNome());
                }
                comboBoxe2.setModel(model_e2);
            }
        });
        configuraçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new FormConfig(docentes,cursos,disciplinas,frame,discentes).getPanelconfig());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }//fim


    private void CarregarComboBoxs(){// ESSA FUNÇÃO PREENCHE TODAS AS COMBOBOX DA LAYOUT

        DefaultComboBoxModel model_ab = new DefaultComboBoxModel();
        DefaultComboBoxModel model_c = new DefaultComboBoxModel();
        DefaultComboBoxModel model_d = new DefaultComboBoxModel();
        DefaultComboBoxModel model_e1 = new DefaultComboBoxModel();
        DefaultComboBoxModel model_e2 = new DefaultComboBoxModel();

        //CRIANDO DA LETRA A e B


        if(docentes.isEmpty() != true){//VERIFICA QUE NAO É NULO E CRIA O MODELO
            for(int i =0; i < docentes.size();i++){
                model_ab.addElement(docentes.get(i).getNome());//ELE ADD O NOME DE CADA PROFESSOR, A COMBO ENTAO ARMAZENA UMA STRING, MAS COM ISSO EU SEI A ORDEM DE CRIAÇÃO DOS PROFESSOR ENTAO PARA PESQUISAR DEPOIS EH SO PEGAR O INDEX DA COMBOX
            }
            comboBoxab.setModel(model_ab);//DEPOIS DE CRIADO, EU SETO NA MINHA COMBOBOX O MODELO QUE EU CRIEI
        }

        //CRIANDO DA LETRA C

        if(cursos.isEmpty() != true){//VERIFICA QUE NAO É NULO E CRIA O MODELO
            for(int i =0; i < cursos.size();i++){
                model_c.addElement(cursos.get(i).getNome());
            }

            comboBoxc.setModel(model_c);
        }


        //CRIANDO A LETRA D

        if(disciplinas.isEmpty() != true){//VERIFICA QUE NAO É NULO E CRIA O MODELO
            for(int i =0; i < disciplinas.size();i++){
               model_d.addElement(disciplinas.get(i).getNome());
            }

            comboBoxd.setModel(model_d);
        }

        //CRIANDO A LETRA E

        if(docentes.isEmpty() != true){//VERIFICA QUE NAO É NULO E CRIA O MODELO
            for(int i =0; i < docentes.size();i++){
                model_e1.addElement(docentes.get(i).getNome());
            }
            comboBoxe1.setModel(model_e1);
        }
    }

    public void testdados (){//Feito para demonstrar a parte de exibicao do layout, com insercao ja na main

        docentes.add(new Docentes("Walter Nagai"));
        docentes.get(0).addDisciplinas(new Disciplina("Linguagens De programacao"));
        docentes.get(0).addDisciplinas((new Disciplina("Mobile")));
        docentes.add(new Docentes("Shitjuka"));
        docentes.get(1).addDisciplinas(new Disciplina("Desenho"));
        docentes.get(1).addDisciplinas((new Disciplina("Mobile")));

        cursos.add(new Curso("Computacao"));
        cursos.get(0).addProfessor("Walter Nagai");
        cursos.add(new Curso("Ambiental"));
        cursos.get(1).addProfessor("Shitjuka");

        disciplinas.add(new Disciplina("Linguagens De Programacao"));
        disciplinas.get(0).addProfessores("Walter Nagai");
        disciplinas.add(new Disciplina("Desenho"));
        disciplinas.get(1).addProfessores("Shitzuka");


    }




    public static void main(String[] args) {
        frame = new JFrame();
        frame.setContentPane(new FormMain().getPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
