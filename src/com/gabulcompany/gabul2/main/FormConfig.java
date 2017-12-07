package com.gabulcompany.gabul2.main;
//PROGRAMA FEITO POR GABRIEL SAVIO BARBOSA SAMPAIO 2016001503
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormConfig {
    private JPanel panelconfig;
    private JTextField textField2;
    private JButton criarButton2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton criarButton4;
    private JComboBox comboBox1;
    private JButton selecionarButton;
    private JButton adicionarButton;
    private JComboBox comboBox2;
    private JTable table1;
    private JButton excluirButton;
    private JTextField textField1;
    private JButton criarButton3;
    private JComboBox comboBox3;
    private JButton salvarButton1;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JButton criarButton;
    private JFrame frame1;
    //VARIAVEIS DE CONTROLE
    private ArrayList<Docentes> docentes;
    private  ArrayList<Curso> curso;
    private  ArrayList<Disciplina> disciplina;
    private  ArrayList<Discentes> discentes;

    public FormConfig(ArrayList<Docentes> docentes, ArrayList<Curso> cursos, ArrayList<Disciplina>disciplina , JFrame frame12,ArrayList<Discentes> discent) {
        discentes = new ArrayList<Discentes>();
        this.docentes = docentes;
        this.curso = cursos;
        this.disciplina = disciplina;
        this.frame1 = frame12;
        this.discentes = discent;

        //iniciar todas as combobox
        ComboBox1();//REFERENTE A DISCIPLINA
        ComboBox2();//REFERENTE AOS ALUNOS
        ComboBox3();//REFERENTE AOS PROFESSORES
        ComboBox4();//REFERENTE AOS CURSOS
        ComboBox5();//REFENRETE A DISCIPLINA QUE PROFESSOR IRA ASSUMIR

        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curso.add(new Curso(textField1.getText()));
                ComboBox4();
            }
        });
        criarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disciplina.add(new Disciplina(textField2.getText()));
                ComboBox1();
                ComboBox5();
            }
        });
        criarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docentes.add(new Docentes(textField3.getText()));
                ComboBox3();
            }
        });
        criarButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discentes.add(new Discentes(textField4.getText()));
                ComboBox2();
            }
        });

        selecionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableBox();
            }
        });
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disciplina.get(comboBox1.getSelectedIndex()).addAlunos(new Discentes(comboBox2.getSelectedItem().toString()));
                TableBox();
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disciplina.get(comboBox1.getSelectedIndex()).removeAlunos(table1.getSelectedRow());
                TableBox();
            }
        });
        salvarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docentes.get(comboBox3.getSelectedIndex()).setCurso(comboBox4.getSelectedItem().toString());
                docentes.get(comboBox3.getSelectedIndex()).addDisciplinas(disciplina.get(comboBox5.getSelectedIndex()));
                cursos.get(comboBox4.getSelectedIndex()).addProfessor(comboBox3.getSelectedItem().toString());
                disciplina.get(comboBox5.getSelectedIndex()).addProfessores(comboBox3.getSelectedItem().toString());
                frame1.setContentPane(new FormMain(docentes,disciplina,curso,frame1,discentes).getPanel());
                frame1.pack();
                frame1.setVisible(true);

            }
        });
    }

    public void ComboBox1(){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        if(disciplina.isEmpty() != true) {
            for (int i = 0; i < disciplina.size(); i++){
                model1.addElement(disciplina.get(i).getNome());
            }
        }
        comboBox1.setModel(model1);
    }

    public void ComboBox2(){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        if(discentes.isEmpty() != true) {
            for (int i = 0; i < discentes.size(); i++){
                model1.addElement(discentes.get(i).getNome());
            }
        }
        comboBox2.setModel(model1);
    }

    public void ComboBox3(){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        if(docentes.isEmpty() != true) {
            for (int i = 0; i < docentes.size(); i++){
                model1.addElement(docentes.get(i).getNome());
            }
        }
        comboBox3.setModel(model1);
    }

    public void ComboBox4(){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        if(curso.isEmpty() != true) {
            for (int i = 0; i < curso.size(); i++){
                model1.addElement(curso.get(i).getNome());
            }
        }
        comboBox4.setModel(model1);
    }

    public void ComboBox5(){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        if(disciplina.isEmpty() != true) {
            for (int i = 0; i < disciplina.size(); i++){
                model1.addElement(disciplina.get(i).getNome());
            }
        }
        comboBox5.setModel(model1);
    }

    public void TableBox (){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nome"});

        for(int i = 0; i < disciplina.get(comboBox1.getSelectedIndex()).getAlunos().size();i++){

            model.addRow(new String[]{disciplina.get(comboBox1.getSelectedIndex()).getAlunos().get(i).getNome()});
        }
        table1.setModel(model);
    }

    public JPanel getPanelconfig() {
        return panelconfig;
    }

    public void setPanelconfig(JPanel panelconfig) {
        this.panelconfig = panelconfig;
    }
}
