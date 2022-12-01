import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Aeroporto");
        System.out.println("olá, seja bem-vindo ao Aeroporto Jatinho Feliz!");

        do {
            System.out.println("opções de menu");
            System.out.println("1 - Cadastrar Avião");
            System.out.println("2 - Cadastrar Helicoptero");
            System.out.println("3 - Cadastrar Jato");
            System.out.println("4 - Cadastrar Companhia");
            System.out.println("5 - Cadastrar Hangar");
            System.out.println("6 - Cadastrar Pista");
            System.out.println("7 - Cadastrar Voo");
            System.out.println("8 - Listar Avião");
            System.out.println("9 - Listar Helicoptero");
            System.out.println("10 - Listar Jato");
            System.out.println("11 - Listar Companhia");
            System.out.println("12 - Listar Hangar");
            System.out.println("13 - Listar Pista");
            System.out.println("14 - Listar Voo");
            System.out.println("15 - alterar Avião");
            System.out.println("16 - alterar Helicoptero");
            System.out.println("17 - alterar Jato");
            System.out.println("18 - alterar Companhia");
            System.out.println("19 - alterar Hangar");
            System.out.println("20 - alterar Pista");
            System.out.println("21 - alterar Voo");
            System.out.println("22 - excluir Avião");
            System.out.println("23 - excluir Helicoptero");
            System.out.println("24 - excluir Jato");
            System.out.println("25 - excluir Companhia");
            System.out.println("26 - excluir Hangar");
            System.out.println("27 - excluir Pista");
            System.out.println("28 - excluir Voo");
            System.out.println("29 - Sair");
            System.out.print("Opção: ");
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    cadastrarAviao(scanner);
                    break;
                case 2:
                    cadastrarHelicoptero(scanner);
                    break;
                case 3:
                    cadastrarJato(scanner);
                    break;
                case 4:
                    cadastrarCompanhia(scanner);
                    break;
                case 5:
                    cadastrarHangar(scanner);
                    break;
                case 6:
                    cadastrarPista(scanner);
                    break;
                case 7:
                    cadastrarVoo(scanner);
                    break;    
                case 8:
                    listarAviao();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 9:
                    listarHelicoptero();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 10:
                    listarJato();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 11:
                    listarCompanhia();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 12:
                    listarHangar();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 13:
                    listarPista();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 14:
                    listarVoo();
                    try{
                        System.in.read();
                    }catch(Exception e){}
                    break;
                case 15:
                    AlterarAviao(scanner);
                    break;
                case 16:
                    AlterarHelicoptero(scanner);
                    break;
                case 17:
                    AlterarJato(scanner);
                    break;
                case 18:
                    AlterarCompanhia(scanner);
                    break;
                case 1:
                    AlterarHangar(scanner);
                    break;
                case 19:
                    AlterarPista(scanner);
                    break;
                case 20:
                    AlterarVoo(scanner);
                    break;    
                case 21:
                    excluirAviao(scanner);
                    break;
                case 22:
                    excluirHelicoptero(scanner);
                    break;
                case 23:
                    excluirJato(scanner);
                    break;
                case 24:
                    excluirCompanhia(scanner);
                    break;
                case 19:
                    excluirHangar(scanner);
                    break;
                case 25:
                    excluirPista(scanner);
                    break;
                case 26:
                    excluirVoo(scanner);
                    break;
                case 27:
                    sair();
                    break;
                default:
                    System.out.println("Ops...opção inválida!");
                    break;
            }
        } while (opcao != 27);
        
    }

    public static void cadastrarAviao(Scanner scanner) {
        String cor;
        int idLocacao;
        System.out.println("Cadastrar aviao");
        System.out.println("Informe a nome:");
        String nome = scanner.next(); 
        System.out.println("Digite o tipo: ([A] Aviao; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                System.out.println("Informe o prefixo;:");
                String prefixo = scanner.next(); 
                System.out.println("Informe a capacidade:");
                capacidade = scanner.nextInt();
                System.out.println("Informe o número da locação:");
                idLocacao = scanner.nextInt();
                try {
                    Locacao locacao = Locacao.getLocacao(idLocacao);
                    Aviao aviao = new Aviao(
                        prefixo,
                        capacidade,
                        nome,
                        locacao
                    );
                    System.out.println("Aviao cadastrado com sucesso!");
                    System.out.println(aviao);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "C":
                cadastrarHelicoptero(scanner, nome);
                break;
            case "M":
                cadastrarJato(scanner,nome);
                break;
            default:
                break;
        }
    }
  
    public static void cadastrarHelicoptero(Scanner scanner, String nome){
        System.out.println("Informe a cor:");
        String cor = scanner.next();
        System.out.println("Informe a capacidade:");
        int capacidade = scanner.nextInt();
        System.out.println("Informe a marca:");
        String marca = scanner.next();
        System.out.println("Informe a modelo:");
        String modelo = scanner.next();
        System.out.println("Informe o número da locação:");
        Integer idHelicoptero = scanner.nextInt();
        try {
            Helicoptero helicoptero = new Helicoptero(
                idHelicoptero,
                cor,
                capacidade,
                marca,
                modelo,
                nome
            );
        System.out.println("Helicoptero cadastrado com sucesso!");
        System.out.println(helicoptero);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void sair() {
        System.out.println("Saindo...");
        System.exit(0);
    }
}


