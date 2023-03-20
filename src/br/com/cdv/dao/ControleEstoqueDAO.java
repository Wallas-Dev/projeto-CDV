/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.dao;

import br.com.cdv.jdbc.ConnectionFactory;
import br.com.cdv.model.ControleEstoque;
import br.com.cdv.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleEstoqueDAO {
    
    
    private Connection con;

    public ControleEstoqueDAO() {

        this.con = new ConnectionFactory().getConnection();

    }
    
    public List<ControleEstoque> listarEstoq1uePorPeriodo(String data_inicio, LocalDate data_fim) {
        try {
            
            List<ControleEstoque> lista = new ArrayList<>();

            String sql = "select id, produto_id, qtd_add, data_add from tb_adicao_estoque where data_add between ? and ?;;";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicio);
            stmt.setString(2, data_fim.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ControleEstoque control = new ControleEstoque();
                Produtos produto = new Produtos();
                
                produto.setId(rs.getInt("produto_id")); 
                control.setId(rs.getInt("id"));
                control.setQtd_adicionada(rs.getInt("qtd_add"));
                control.setData_adicionada(rs.getString("data_add"));
                control.setProduto(produto);

                lista.add(control);
            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
}
