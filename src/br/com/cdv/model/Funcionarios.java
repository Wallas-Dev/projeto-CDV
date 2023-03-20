/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import br.com.cdv.dao.FuncionarioDAO;
import java.util.List;



public class Funcionarios extends Pessoas {
    
    private String rg;
    private String cpf;
    private String senha;
    private String cargo;
    private String nivel_acesso;

    public Funcionarios() {
    }


    public Funcionarios(String senha, String cargo, String nivel_acesso, String nome, String rg, String cpf, String email, String telefone, String celular, String cep, String endereco, int numero, String complemento, String bairro, String cidade, String uf) {
        super(nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, uf);
        this.rg = rg;
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
        this.nivel_acesso = nivel_acesso;
    }
    
    
    
    public void cadastrar(Funcionarios obj) {
        new FuncionarioDAO().cadastrarFuncionario(obj);
    }

    // metado alterar funcinarios
    public void alterar(Funcionarios obj) {
        new FuncionarioDAO().alterarFuncionario(obj);

    }

    // metado excluir funcinarios
    @Override
    public void excluir(int id) {
        new FuncionarioDAO().excluirFuncionario(id);

    }

    //metodo listar funcionarios 
    public List<Funcionarios> listarFuncionarios() {
        return new FuncionarioDAO().listarFuncionarios();
    }

    // Consulta Funcionario por cpf 
    public Funcionarios consultaPorCpf(String cpf) {
        return new FuncionarioDAO().consultaPorCpf(cpf);

    }

    // Metodo listar Funcionario por nome -- retorna uma lista
    public List<Funcionarios> listaFuncionariosNome(String nome) {
        return new FuncionarioDAO().listaFuncionariosNome(nome);
    }

    //Metodo efetua login 
    public void efetuarLogin(String email, String senha) {
        new FuncionarioDAO().efetuarLogin(email, senha);
    }

    

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
    
    
    
}
