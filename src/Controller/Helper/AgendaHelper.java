/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iansa
 */
public class AgendaHelper implements IHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view    ;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
       
         DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o tableModel    
        for (Agendamento agendamento : agendamentos) {
            
           tableModel.addRow(new Object[]{
           
               agendamento.getId(),
               agendamento.getCliente().getNome(),
               agendamento.getServico().getDescricao(),
               agendamento.getDataFormatada(),
               agendamento.getHoraFormatada(),
               agendamento.getValor(),
               agendamento.getObservacao()
               
           });
           
            
        }
 
        
        
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
    // Cria um novo modelo para o combo
    DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getBoxCliente().getModel();

    // Adiciona os clientes no combo
    for (Cliente cliente : clientes) {
        comboBoxModel.addElement(cliente); // aqui vai adicionar o objeto Cliente
    }

    // Atualiza o combo da view
    view.getBoxCliente().setModel(comboBoxModel);
    }

    public void preencherServico(ArrayList<Servico> servicos) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getBoxServico().getModel();

    // Adiciona os clientes no combo
    for (Servico servico : servicos) {
        comboBoxModel.addElement(servico);
    }
    
    view.getBoxServico().setModel(comboBoxModel);
   }

    public Servico obeterServico() {
        
        return (Servico) view.getBoxServico().getSelectedItem();
        
    }

    public void setarValor(float valor) {
        
        view.getTextValor().setText(valor + "");
        
    }

    @Override
    public Object obterModelo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void limparTela() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
    
}
