package trabalho1sd.funcionario;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import trabalho1sd.servidor.database.LivroDAO;
import trabalho1sd.servidor.model.Publisher;

public class Funcionario {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            LivroDAO livro = new LivroDAO();
            
            System.out.println("Conectado ao servidor");
            Registry regs = LocateRegistry.getRegistry("localhost", 1098);
            Publisher pub = (Publisher) regs.lookup("ServerRMI");
         
            String input;
            while (true) {
                System.out.print("\n\n[1]Adicionar\n[2]Remover\n[3]Alterar\n[4]Ver todos\n[5]Alugar Livro\n[6]Registrar Devolução\n[0] Sair\nDigite: ");
                input = scanner.nextLine();
                System.out.println("\n\n");
                String query;
                
                if(input.equalsIgnoreCase("0")){
                    break;
                }
                
                switch(input){
                    case "1" -> {
                    
                        System.out.println("\nCodigo: ");
                        int cod = scanner.nextInt();
                        System.out.println("Titulo: ");
                        scanner.nextLine();
                        String titulo = scanner.nextLine();
                        query = "insert into tb_livro (ID, TITULO, DISPONIBILIDADE) values ('" + cod + "', '" + titulo + "', '1');";
                        livro.insert(query);
                        pub.enviaMensagem("O livro " + titulo + " foi adicionado");
                        break;
                    }
                    
                    case "2" ->{
                        System.out.println("\nCodigo: ");
                        int cod = scanner.nextInt();
                        query = "delete from tb_livro where ID = " + cod;
                        livro.insert(query);
                        pub.enviaMensagem("O livro de ID " + cod + " removido");
                        break;
                    }
                    
                    case "3" ->{
                        System.out.println("\nCodigo: ");
                        int cod = scanner.nextInt();
                        System.out.println("Titulo: ");
                        scanner.nextLine();
                        String titulo = scanner.nextLine();
                        query = "update tb_livro set TITULO = '" + titulo + "' where ID = " + cod;
                        livro.insert(query);
                        pub.enviaMensagem("O livro de ID " + cod + " atualizado");
                        break;
                    }
                    case "4" ->{
                        query = "select * from tb_livro where DISPONIBILIDADE = '1';";
                        livro.search(query);
                        break;
                    }
                    
                    case "5" ->{
                        System.out.println("\nCodigo: ");
                        int cod = scanner.nextInt();
                        query = "update tb_livro set DISPONIBILIDADE = '0' where ID = " + cod;
                        livro.insert(query);
                        pub.enviaMensagem("O livro de ID " + cod + " foi alugado");
                    }
                    
                    case "6" ->{
                        System.out.println("\nCodigo: ");
                        int cod = scanner.nextInt();
                        query = "update tb_livro set DISPONIBILIDADE = '1' where ID = " + cod;
                        livro.insert(query);
                        pub.enviaMensagem("O livro de ID " + cod + " foi devolvido");
                    }
                }
            }
            System.out.println("Encerrando sessão do funcionario.");
            scanner.close();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
