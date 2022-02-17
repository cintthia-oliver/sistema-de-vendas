/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ohayou
 */
public class FornecedorDAO {
    private Connection conexao;
    
    public FornecedorDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Método Cadastrar Fornecedor
    public void cadastrarFornecedores(Fornecedor obj){
        try{
           //1 - Instrução SQL
           String sql = "insert into tb_fornecedores(nome, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                   + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
           
           //2 - Preparar SQL
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getCnpj());
           stmt.setString(3, obj.getEmail());
           stmt.setString(4, obj.getTelefone());
           stmt.setString(5, obj.getCelular());
           stmt.setString(6, obj.getCep());
           stmt.setString(7, obj.getEndereco());
           stmt.setString(8, obj.getNumero());
           stmt.setString(9, obj.getComplemento());
           stmt.setString(10, obj.getBairro());
           stmt.setString(11, obj.getCidade());
           stmt.setString(12, obj.getEstado());
           
           //3 - Executar
           stmt.execute();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com Sucesso!");
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Listar Fornecedores
    public List<Fornecedor> listarFornecedores(){
        try{
            List<Fornecedor> lista = new ArrayList<>();
            
            //1 - Instrução SQL
            String sql = "select * from tb_fornecedores";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Fornecedor obj = new Fornecedor();
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setCnpj(rs.getString("cnpj"));
               obj.setEmail(rs.getString("email"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setEndereco(rs.getString("endereco"));
               obj.setNumero(rs.getString("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
               
               lista.add(obj);
               
            }
            return lista;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
        return null;
    }
    
    //Metodo Alterar Fornecedor
    public void alterarFornecedor(Fornecedor obj){
        try{
            //1 - Instrução SQL
            String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?,"
                    + " bairro=?, cidade=?, estado=? where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            stmt.setInt(13, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedor Alterado com Sucesso!");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Excluir Fornecedor
    public void excluirFornecedor(Fornecedor obj){
        try{
            //1 - Instrução SQL
            String sql = "delete from tb_fornecedores where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedor Excluido com Sucesso!");

            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Buscar Fornecedor
    public Fornecedor buscarFornecedor(String nome){
        try{
            //1 - Instrução SQL
            String sql = "select * from tb_fornecedores where nome = ?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            Fornecedor obj = new Fornecedor();
            
            while(rs.next()){
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setCnpj(rs.getString("cnpj"));
               obj.setEmail(rs.getString("email"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setEndereco(rs.getString("endereco"));
               obj.setNumero(rs.getString("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
            }
            return obj;
            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
        
        return null;
    }
    
    //Método filtrar fornecedor na tabela
    public List<Fornecedor> pesquisarNome(String nome){
        try{
            //1 - Criar lista
            List<Fornecedor> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select * from tb_fornecedores where nome like ?";
            
            //3 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //4 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Fornecedor obj = new Fornecedor();
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setCnpj(rs.getString("cnpj"));
               obj.setEmail(rs.getString("email"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setEndereco(rs.getString("endereco"));
               obj.setNumero(rs.getString("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
               
               lista.add(obj);
               
            }
            return lista;
            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro:\n "+error);
        }
        
        return null;
    }
    
}
