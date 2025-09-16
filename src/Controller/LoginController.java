/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author iansa
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view   ) {
        this.view = view;
        this.helper = new LoginHelper(view);
        
    }
    
    
        
    public void entrarNoSistema(){
        
        //pegar um usuario da View
        Usuario usuario = helper.obterModelo();
        
        
        //pesquisar o usuario no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        //Se o usuario da View tiver o mesmo usuario e senha que o usuario vindo do banco direcionar ao menu 
        if (usuarioAutenticado != null){
        //navegar para menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }
        //Se não vou mostrar uma mensagem ao usuario "usuario ou senha invalido"
        else{
            view.exibeMensagem("Usuario ou Senha invalido!");
        }
        
        
        
        
        
    }
}
