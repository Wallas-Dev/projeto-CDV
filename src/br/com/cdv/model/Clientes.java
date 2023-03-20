/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import br.com.cdv.dao.ClienteDAO;
import java.util.List;


public class Clientes extends Pessoas{
    
    // Atributos
    private String rg;
    private String cpf;


    public Clientes() {
    }

    public Clientes(String rg, String cpf) {
        this.rg = rg;
        this.cpf = cpf;
    }
    
    public Clientes( String nome,String rg, String cpf, String email, String telefone, String celular, String cep, String endereco, int numero, String complemento, String bairro, String cidade, String uf) {
        super(nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, uf);
        this.rg = rg;
        this.cpf = cpf;
    }

    public Clientes(int id, String nome,String rg, String cpf, String email, String telefone, String celular, String cep, String endereco, int numero, String complemento, String bairro, String cidade, String uf) {
        super(id, nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, uf);
        this.rg = rg;
        this.cpf = cpf;
    }
    
    public void cadastrar(Clientes obj) {
        new ClienteDAO().cadastrarCliente(obj);
    }
    // Metodo alterarCliente

    public void alterar(Clientes obj) {
        new ClienteDAO().alterarCliente(obj);

    }
    // Metodo excluirCliente
    @Override
    public void excluir(int id) {
        new ClienteDAO().excluirCliente(id);

    }

    // Listar clientes
    public List<Clientes> listarClientes() {
        return new ClienteDAO().listarClientes();

    }

    // metodo consultaCliente por Cpf
    public Clientes consultaPorCpf(String cpf) {
        return new ClienteDAO().consultaPorCpf(cpf);

    }

    // metodo busca Cliente por cpf
    public Clientes buscaPorCpf(String cpf) {
        return new ClienteDAO().buscaPorCpf(cpf);

    }

    // Metodo buscar cliente por nome -- retorna uma lista
    public List<Clientes> buscaClienteNome(String nome) {
        return new ClienteDAO().buscaClienteNome(nome);
    }
    // Buscar Cep 

    public Clientes buscaCep(String cep) {
        return new ClienteDAO().buscaCep(cep);
    }
    
    
    //Get and Set
   

    public String getRg() {
        return rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
  
}
