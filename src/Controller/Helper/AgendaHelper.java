/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
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

        // Percorrer a lista preenchendo o tableModel    
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

        // Adicione essas linhas no final para notificar e atualizar a tabela
        tableModel.fireTableDataChanged();  // Notifica o modelo de mudanças
        view.getTableAgendamentos().revalidate();  // Revalida o layout
        view.getTableAgendamentos().repaint();  // Repinta a tabela
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente.getNome());  // Usa o nome como string
        }
        view.getBoxCliente().setModel(comboBoxModel);
    }

    public void preencherServico(ArrayList<Servico> servicos) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico.getDescricao());  // Usa a descrição como string
        }
        view.getBoxServico().setModel(comboBoxModel);
    }
    
    
    
    public void preencherComAgendamento(Agendamento agendamento) {
        if (agendamento != null) {
            view.getTextId().setText(agendamento.getId() + "");
            view.getBoxCliente().setSelectedItem(agendamento.getCliente());
            view.getBoxServico().setSelectedItem(agendamento.getServico());
            view.getTextValor().setText(agendamento.getValor() + "");
            view.getTextData().setText(agendamento.getDataFormatada());
            view.getTextHora().setText(agendamento.getHoraFormatada());
            view.getTextObservacao().setText(agendamento.getObservacao());
        }
    }
    
    
    public Cliente obterCliente() {
        String nomeSelecionado = (String) view.getBoxCliente().getSelectedItem();
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.selectAll();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nomeSelecionado)) {
                return cliente;
            }
        }
        return null;  // Ou lance uma exceção se não encontrar
    }

    public Servico obterServico() {
        String descricaoSelecionada = (String) view.getBoxServico().getSelectedItem();
        ServicoDAO dao = new ServicoDAO();
        ArrayList<Servico> servicos = dao.selectAll();
        for (Servico servico : servicos) {
            if (servico.getDescricao().equals(descricaoSelecionada)) {
                return servico;
            }
        }
        return null;  // Ou lance uma exceção
    }

    public void setarValor(float valor) {
        
        view.getTextValor().setText(valor + "");
        
    }

    @Override
    public Agendamento obterModelo() {
        String idString = view.getTextId().getText();
        int id = idString.isEmpty() ? 0 : Integer.parseInt(idString);  // Usa 0 para novos

        Cliente cliente = obterCliente();
        Servico servico = obterServico();

        String valorString = view.getTextValor().getText();
        float valor = valorString.isEmpty() ? 0 : Float.parseFloat(valorString);

        String data = view.getTextData().getText();
        String hora = view.getTextHora().getText();

        if (data == null || data.isEmpty() || hora == null || hora.isEmpty()) {
            view.exibeMensagem("Preencha data e hora!");
            return null;
        }

        String dataHora = data + " " + hora;
        String observacao = view.getTextObservacao().getText();

        return new Agendamento(id, cliente, servico, valor, dataHora, observacao);
    }


    @Override
    public void limparTela() {
        view.getTextId().setText("");  // Limpa ID para novo
        view.getBoxCliente().setSelectedIndex(0);
        view.getBoxServico().setSelectedIndex(0);
        view.getTextValor().setText("");
        view.getTextData().setText("");
        view.getTextHora().setText("");
        view.getTextObservacao().setText("");
    }

}

    
    
    
    
    
