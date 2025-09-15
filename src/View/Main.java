/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;


/**
 *
 * @author iansa
 */
public class Main {
 
    
    
  public static void main(String[] args){
  
      String nome = "ian";
      System.out.println(nome);
      
      Servico barba = new Servico(1, "Barba", 20);
      
      System.out.println(barba.getDescricao());
      System.out.println(barba.getValor());
      
      Cliente cliente = new Cliente(3, "Karen", "Avenida Dominguinho", "40414-350");
      System.out.println(cliente);
      
      Usuario usuario = new Usuario(0, nome, nome);
      
      Agendamento agendamento = new Agendamento(1, cliente, barba, 20, "10/09/2025 19:30");
      System.out.println(agendamento);
      
      
      
      
      
      
  }
    
}
