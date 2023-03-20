/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;


import br.com.cdv.dao.ControleEstoqueDAO;
import java.time.LocalDate;

import java.util.List;



public class ControleEstoque {
    
    private int id;
    private Produtos produto;
    private int qtd_adicionada;
    private String data_adicionada;
    private double subtotal;

    
    public List<ControleEstoque> listarEstoquePorPeriodo(String data_inicio, LocalDate data_fim) {
        return new ControleEstoqueDAO().listarEstoq1uePorPeriodo(data_inicio, data_fim);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQtd_adicionada() {
        return qtd_adicionada;
    }

    public void setQtd_adicionada(int qtd_adicionada) {
        this.qtd_adicionada = qtd_adicionada;
    }

    public String getData_adicionada() {
        return data_adicionada;
    }

    public void setData_adicionada(String data_adicionada) {
        this.data_adicionada = data_adicionada;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
