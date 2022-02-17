/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ohayou
 */
public class VendaDAO {
    private Connection conexao;

    public VendaDAO() {
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Método para cadastrar venda
    public void cadastrarVenda(Vendas obj){
        try{
            //1 - Instrução SQL
            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda, observacoes)"
                + "value (?,?,?,?)";
            
            //2- Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDt_venda());
            stmt.setDouble(3, obj.getTotal_venda());
            stmt.setString(4, obj.getObservacoes());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
            
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }
    
    //Método para retornar vendas
    public int retornaUltimaVenda(){
        try{
            int idUltimaVenda = 0;
            
            //1 - Instrução SQL
            String sql = "select max(id) id from tb_vendas";
            
            //2- Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Vendas v = new Vendas();
                v.setId(rs.getInt("id"));
                idUltimaVenda = v.getId();
            }
            return idUltimaVenda;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    //Método para calcular total de vendas do dia
    public double totalVendas(LocalDate data){
        try{
            double totais = 0;
            
            //1 - Instrução SQL
            String sql = "select sum(total_venda) as total from tb_vendas where data_venda = ?";
            
            //2- Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, data.toString());
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                totais = rs.getDouble("total");
            }
            return totais;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    //Método para listar vendas
    public List<Vendas> historicoVendas(LocalDate data_inicio, LocalDate data_fim){
        try{
            //1 - Criando lista
            List<Vendas> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select v.id, c.nome, date_format(v.data_venda, '%d/%m/%y') as data_formatada,"
                    + "v.total_venda, v.observacoes from tb_vendas as v inner join tb_clientes as c "
                    + "on(v.cliente_id = c.id) where v.data_venda BETWEEN ? and ?";
            
            //3- Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            
            //4 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Vendas obj = new Vendas();
                Cliente c = new Cliente();
                
                obj.setId(rs.getInt("v.id"));
                c.setNome(rs.getString("c.nome"));
                obj.setCliente(c);
                obj.setDt_venda(rs.getString("data_formatada"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObservacoes(rs.getString("v.observacoes"));
                lista.add(obj);
            }
            return lista;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
