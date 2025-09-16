/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author iansa
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        
        //Buscar uma lista com os agendamento do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        //Exibir essa lista na view
        helper.preencherTabela(agendamentos);
        
        
        
    }
    
    public void atualizaCliente(){
    
        //buscar objetos cliente do banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        //exibir cliente no BoxCliente
        helper.preencherClientes(clientes);
        
    }
    
    
    public void atualizaServico(){
    
    ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
    
        helper.preencherServico(servicos);
    }
    
    
    public void atualizaValor(){
    
        Servico servico = helper.obterServico(); 
        if (servico != null) { 
            
            helper.setarValor(servico.getValor()); 
        }
    
    }
    
    public void agendar(){
    
        //Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        //Salvar objeto no Banco de Dados
        new AgendamentoDAO().insert(agendamento);
        
        atualizaTabela();
        
        helper.limparTela();
    }
}
    
