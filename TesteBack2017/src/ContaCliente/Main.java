package ContaCliente;

import Dao.ClienteDao;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String finalizar = "s";
        Scanner sc = new Scanner(System.in);
        
        while((!finalizar.equals("n")) && (!finalizar.equals("N"))){
            Cliente cliente = new Cliente();
            System.out.println("Insira o id do cliente: ");
            cliente.setIdCliente(Integer.parseInt(sc.nextLine()));
            System.out.println("Insira o cpf ou cnpj do cliente: ");
            cliente.setCpfCnpj(sc.nextLine());
            System.out.println("Insira o nome do cliente: ");
            cliente.setNome(sc.nextLine());
            do{
                System.out.println("O cliente está ativo? [0] não [1] sim : ");
                cliente.setEstaAtivo(Integer.parseInt(sc.nextLine()));
            }while((cliente.getEstaAtivo() != 1)&&(cliente.getEstaAtivo() != 0));
            System.out.println("Informe o saldo total do cliente: ");
            cliente.setValorTotal(Double.parseDouble(sc.nextLine()));
            ClienteDao clienteDao = new ClienteDao();
            clienteDao.adiciona(cliente);
            
            System.out.println("Deseja inserir mais clientes? Aperte 'n' para terminar"+
                    " de inserir e qualquer outra para continuar inserindo");
                    finalizar = sc.nextLine();
        }
        
        ClienteDao clienteDao = new ClienteDao();
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(clienteDao.media()));
        
        ClienteDao dao = new ClienteDao();
        List<Cliente> clientes = dao.getLista();
        
        for(Cliente cliente : clientes){
            System.out.println("Id: "+ cliente.getIdCliente());
            System.out.println("CPF/CNPJ: "+ cliente.getCpfCnpj());
            System.out.println("Nome: "+ cliente.getNome());
            if(cliente.getEstaAtivo() == 1){
                System.out.println("Ativo: Sim");
            } else{
                System.out.println("Ativo: Não");
            }
            System.out.println("Saldo: "+ cliente.getValorTotal());
        }
    }
}
