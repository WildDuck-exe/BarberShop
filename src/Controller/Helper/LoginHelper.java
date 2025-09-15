/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.Login;

/**
 *
 * @author iansa
 */
public class LoginHelper implements IHelper{
    
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario oberModelo(){
        
        String nome = view.getTextUser().getText();
        String senha = view.getTextSenha().getText();
        Usuario modelo = new Usuario(0, nome, nome);
    
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUser().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getTextUser().setText("");
        view.getTextSenha().setText("");
    }

    @Override
    public Objetc obterModelo() {
        
    }
}
