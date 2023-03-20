/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.dao;

import br.com.cdv.jdbc.ConnectionFactory;
import br.com.cdv.model.Clientes;
import br.com.cdv.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendasDAO {

    private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

//Cadastrar venda
    public void cadastrarVenda(Vendas obj) {
        try {

            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda, observacoes) values(?, ?, ?, ?);";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVenda());
            stmt.setDouble(3, obj.getTotalVenda());
            stmt.setString(4, obj.getObs());

            stmt.execute();
            stmt.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro_venda:" + erro);
        }

    }

//Retorna a ultima venda
    public int retornaUltimaVenda() {

        try {
            int idvenda = 0;
            String sql = "select max(id) id from tb_vendas";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Vendas p = new Vendas();
                p.setId(rs.getInt("id"));
                idvenda = p.getId();

            }

            return idvenda;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    // Metodo de filtra vendas por datas
    public List<Vendas> listarVendasPorPeriodo(String data_inicio, LocalDate data_fim) {
        try {
            // criando a lista

            List<Vendas> lista = new ArrayList<>();
            // criando sql
            String sql = "select v.id, date_format(v.data_venda,'%d/%m/%Y') as data_formatada , c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + " inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN? and?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicio);
            stmt.setString(2, data_fim.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();
                Clientes c = new Clientes();

                obj.setId(rs.getInt("v.id"));
                obj.setDataVenda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotalVenda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));
                obj.setCliente(c);

                lista.add(obj);
            }

            return lista;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    // Metodo que calcula total de venda por data
    public double retornaTotalVendaPorData(LocalDate data_venda) {
        try {
            double totalvenda = 0;

            String sql = "select sum(total_venda) as total from tb_vendas where data_venda = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_venda.toString());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalvenda = rs.getDouble("total");
            }
            return totalvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
