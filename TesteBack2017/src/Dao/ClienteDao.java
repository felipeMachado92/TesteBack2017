package Dao;

import ContaCliente.Cliente;
import ContaCliente.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ClienteDao {
    private Connection connection;
    
    public ClienteDao() throws Exception{
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Cliente cliente) throws SQLException{
        String sql = "insert into tb_customer_account "+
                "(id_customer, cpf_cnpj, nm_customer,is_active,vl_total) "+
                "values (?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,cliente.getIdCliente());
            stmt.setString(2,cliente.getCpfCnpj());
            stmt.setString(3,cliente.getNome());
            stmt.setInt(4,cliente.getEstaAtivo());
            stmt.setDouble(5,cliente.getValorTotal());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }
    }
    public double media() throws SQLException{
        try {
            double media;
            PreparedStatement stmt =  this.connection.
                    prepareStatement("select avg(vl_total) from tb_customer_account"+
                        " where vl_total > 560 and id_customer between 1500 and 2700 ");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            media = rs.getDouble("avg(vl_total)");
            rs.close();
            stmt.close();
            return media;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            connection.close();
        }
    }
    
    public List<Cliente> getLista() throws SQLException{
        try {
            List<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from tb_customer_account "+
                    "where vl_total > 560 and id_customer between 1500 and 2700 order by vl_total desc");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_customer"));
                cliente.setCpfCnpj(rs.getString("cpf_cnpj"));
                cliente.setNome(rs.getString("nm_customer"));
                cliente.setEstaAtivo(rs.getInt("is_active"));
                cliente.setValorTotal(rs.getDouble("vl_total"));
                
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            connection.close();
        }
    }
}
