/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author iansa
 */
abstract public class Pessoa {
    
    protected int id;
    protected String nome;
    protected char sex;
    protected Date dataNascimento;
    protected String telefone;
    protected String email;
    protected String rg;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
        
    }

    public Pessoa(int id, String nome, char sex, String dataNascimento, String telefone, String email, String rg) {
        this.id = id;
        this.nome = nome;
        this.sex = sex;
        try {
            SimpleDateFormat sdf;
            if (dataNascimento.trim().length() == 10) { 
                // Exemplo: 18/07/1990
                sdf = new SimpleDateFormat("dd/MM/yyyy");
            } else {
                // Exemplo: 18/07/1990 14:30
                sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            }
            this.dataNascimento = sdf.parse(dataNascimento);
        } catch (ParseException ex) {
            System.getLogger(Pessoa.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
}
