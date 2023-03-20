/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import br.com.cdv.dao.VendasDAO;
import java.time.LocalDate;
import java.util.List;


public class Vendas {
    
    //Atributos
    
    private int id;
    private Clientes cliente;
    private String dataVenda;
    private double totalVenda;
    private String obs;
  
    
    
    public void cadastrarVenda(Vendas obj) {
        new VendasDAO().cadastrarVenda(obj);

    }

//Retorna a ultima venda
    public int retornaUltimaVenda() {
        return new VendasDAO().retornaUltimaVenda();

    }

    // Metodo de filtra vendas por datas
    public List<Vendas> listarVendasPorPeriodo(String data_inicio, LocalDate data_fim) {
        return new VendasDAO().listarVendasPorPeriodo(data_inicio, data_fim);

    }

    // Metodo que calcula total de venda por data
    public double retornaTotalVendaPorData(LocalDate data_venda) {
        return new VendasDAO().retornaTotalVendaPorData(data_venda);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    
}
