package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa um agendamento com cliente, serviço, data, hora e observação.
 * 
 * @author iansa
 */
public class Agendamento {
    
    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date data;
    private String observacao;

    // Construtor simples (sem hora/observação)
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = (servico != null && valor <= 0) ? servico.getValor() : valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Construtor completo (com data, hora e observação)
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String hora, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = (servico != null && valor <= 0) ? servico.getValor() : valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data + " " + hora);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.observacao = observacao;
    }

    // Construtor alternativo (com data e hora juntos)
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String dataHora, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = (servico != null && valor <= 0) ? servico.getValor() : valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataHora);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.observacao = observacao;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public float getValor() { return valor; }
    public void setValor(float valor) { this.valor = valor; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public String getDataFormatada() {
        return (data != null) ? new SimpleDateFormat("dd/MM/yyyy").format(data) : "";
    }

    public String getHoraFormatada() {
        return (data != null) ? new SimpleDateFormat("HH:mm").format(data) : "";
    }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
}
