/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.ItensVenda;
import br.com.projeto.model.Produto;
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
public class ItensVendaDAO {
    private Connection conexao;

    public ItensVendaDAO() {
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Método para cadastrar intens
    public void cadastrarItensProduto(ItensVenda obj){
        try{
            //1 - Instrução SQL
            String sql = "insert into tb_itensvendas (venda_id, produto_id, qtd, subtotal)"
                + "value (?,?,?,?)";
        
            //2- Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getVendas().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }
    
    //Método para listar intens
    public List<ItensVenda> listaItensVenda(int venda_id){
        try{
            //1 - Criar Lista
            List<ItensVenda> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select p.descricao, i.qtd, p.preco, i.subtotal "
                    + "from tb_itensvendas as i "
                    + "inner join tb_produtos as p on(i.produto_id = p.id) "
                    + "where i.venda_id = ?";
            
            //3 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, venda_id);
            
            //4 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ItensVenda item = new ItensVenda();
                Produto p = new Produto();
                
                p.setDescricao(rs.getString("p.descricao"));
                item.setQtd(rs.getInt("i.qtd"));
                p.setPreco(rs.getDouble("p.preco"));
                item.setSubtotal(rs.getDouble("i.subtotal"));
                item.setProduto(p);
                
                lista.add(item);
            }
            
            return lista;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
