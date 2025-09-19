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
    
    
        
    public void entrarNoSistema() {
        Usuario usuario = helper.obterModelo();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

        if (usuarioAutenticado != null) {
            view.exibeMensagem("Login realizado com sucesso!");
            System.out.println("Fechando janela de login...");
            this.view.dispose();
            java.awt.EventQueue.invokeLater(() -> {
                System.out.println("Abrindo MenuPrincipal...");
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            });
        } else {
            view.exibeMensagem("Usuario ou Senha invalido!");
        }
    }
}
