import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Aeroporto");
        System.out.println("olá, seja bem-vindo ao Aeroporto Jatinho Feliz!");

        do {
            System.out.println("opções de menu");
            System.out.println("1 - Cadastrar ");
            System.out.println("2 - alterar ");
            System.out.println("3 - Listar ");
            System.out.println("4 - excluir ");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    cadastrar(scanner);
                    break;
                case 2:
                    alterar(scanner);
                    break;
                case 3:
                    listar(scanner);
                    break;
                case 4:
                    excluir(scanner);
                    break;
                case 5:
                    sair();
                    break;
                default:
                    System.out.println("Ops...opção inválida!");
                    break;
            }
        } while (opcao != 5);
        
    }
    private static void alterar(Scanner scanner) {
        System.out.println("Digite o tipo: ([A] Aeronave; [C] Companhia; [H] Hangar; [P] Pista; [V] Voo)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                alterarAeronave(scanner);
                break;
            case "C":
                alterarCompanhia(scanner);
                break;
            case "H":
                alterarHangar(scanner);
                break;
            case "P":
                alterarPista(scanner);
                break;
            case "V":
                alterarVoo(scanner);
                break;
            default:
                break;
        }
    }

    private static void listar(Scanner scanner) {
        System.out.println("Digite o tipo: ([A] Aeronave; [C] Companhia; [H] Hangar; [P] Pista; [V] Voo)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                listarAeronave(scanner);
                break;
            case "C":
                Companhia.getAll();
                break;
            case "H":
                Hangar.getAll();
                break;
            case "P":
                Pista.getAll();
                break;
            case "V":
                Voo.getAll();
                break;
            default:
                break;
        }
    }

    private static void listarAeronave(Scanner scanner) {
        System.out.println("Listar o Aeronave");
        System.out.println("Digite o tipo: ([A] Aviao; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                Aviao.getAll();
                break;
            case "H":
                Helicoptero.getAll();
                break;
            case "J":   
                Jato.getAll();
                break;
            default:
                break;
        }
    }
    
    
    private static void excluir(Scanner scanner) {
        System.out.println("Digite o tipo: ([A] Aeronave; [C] Companhia; [H] Hangar; [P] Pista; [V] Voo)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                excluirAeronave(scanner);
                break;
            case "C":
                Companhia.remove(scanner);
                break;
            case "H":
                Hangar.remove(scanner);
                break;
            case "P":
                Pista.remove(scanner);
                break;
            case "V":
                Voo.remove(scanner);
                break;
            default:
                break;
        }
    }


    private static void excluirAeronave(Scanner scanner) {
        System.out.println("Excluir o aviao");
        System.out.println("Digite o tipo: ([A] Aviao; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                Aviao.remove(scanner);
                break;
            case "H":
                Helicoptero.remove(scanner);
                break;
            case "J":
                Jato.remove(scanner);
                break;
            default:
                break;
        }
    }
    
    private static void cadastrar(Scanner scanner) {
        System.out.println("Digite o tipo: ([A] Aeronave; [C] Companhia; [H] Hangar; [P] Pista; [V] Voo)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                cadastrarAeronave(scanner);
                break;
            case "C":
                cadastrarCompanhia(scanner);
                break;
            case "H":
                cadastrarHangar(scanner);
                break;
            case "P":
                cadastrarPista(scanner);
                break;
            case "V":
                cadastrarVoo(scanner);
                break;
            default:
                break;
        }
    }
   
    private static void alterarAeronave(Scanner scanner) {
        System.out.println("Alterar Aeronave");
        System.out.println("Informe o nome:");
        String nome = scanner.next(); 
        System.out.println("Digite o tipo: ([A] Aviao; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
                alterarAviao(scanner,nome);
                break;
            case "H":
                alterarHelicoptero(scanner, nome);
                break;
            case "J":
                alterarJato(scanner,nome);
                break;
            default:
                break;
        }
    }
    
    private static void cadastrarAeronave(Scanner scanner) {
        System.out.println("Cadastrar aviao");
        System.out.println("Informe a nome:");
        String nome = scanner.next(); 
        System.out.println("Digite o tipo: ([A] Aviao; [H] Helicoptero; [J] Jato)");
        String tipo = scanner.next();
        switch (tipo) {
            case "A":
               cadastrarAviao(scanner,nome);
                break;
            case "H":
                cadastrarHelicoptero(scanner, nome);
                break;
            case "J":
                cadastrarJato(scanner,nome);
                break;
            default:
                break;
        }
    }
    
    public static void cadastrarJato(Scanner scanner, String nome) {
        System.out.println("Informe o marca:");
        String marca = scanner.next(); 
        System.out.println("Informe o modelo:");
        String modelo = scanner.next(); 
        System.out.println("Informe o prefixo:");
        String cor = scanner.next(); 
        System.out.println("Informe a capacidade:");
        int velocidade = scanner.nextInt();
        try {
            Jato jato = new Jato(
                marca,
                modelo,
                nome,
                cor,
                velocidade
            );
            System.out.println("Aviao cadastrado com sucesso!");
            System.out.println(jato);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarAviao(Scanner scanner, String nome) {
        System.out.println("Informe o marca:");
        String marca = scanner.next(); 
        System.out.println("Informe o modelo:");
        String modelo = scanner.next(); 
        System.out.println("Informe o prefixo:");
        String prefixo = scanner.next(); 
        System.out.println("Informe a capacidade:");
        String capacidade = scanner.next();
        System.out.println("Informe o número da Companhia:");
        int IdCompanhia = scanner.nextInt();
        try {
            Aviao aviao = new Aviao(
                marca,
                modelo,
                prefixo,
                capacidade,
                IdCompanhia
            );
            System.out.println("Aviao cadastrado com sucesso!");
            System.out.println(aviao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        try {
            Helicoptero helicoptero = new Helicoptero(
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

    public static void alterarAviao(Scanner scanner, String nome){
        System.out.println("Informe a cor:");
        String cor = scanner.next();
        System.out.println("Informe a capacidade:");
        int capacidade = scanner.nextInt();
        System.out.println("Informe a marca:");
        String marca = scanner.next();
        System.out.println("Informe a modelo:");
        String modelo = scanner.next();
        System.out.println("Informe o id do Aviao:");
        Integer idAviao = scanner.nextInt();
        try {
            Aviao aviao = new Aviao(
                idAviao,
                marca,
                modelo,
                nome,
                cor,
                capacidade
            );
            aviao.atualizar(scanner);
        System.out.println("Aviao alterado com sucesso!");
        System.out.println(aviao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alterarHelicoptero(Scanner scanner, String nome){
        System.out.println("Informe a cor:");
        String cor = scanner.next();
        System.out.println("Informe a capacidade:");
        int capacidade = scanner.nextInt();
        System.out.println("Informe a marca:");
        String marca = scanner.next();
        System.out.println("Informe a modelo:");
        String modelo = scanner.next();
        System.out.println("Informe o id do Helicoptero:");
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
            helicoptero.atualizar(scanner);
            System.out.println("Helicoptero alterado com sucesso!");
            System.out.println(helicoptero);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alterarJato(Scanner scanner, String nome){
        System.out.println("Informe a cor:");
        String cor = scanner.next();
        System.out.println("Informe a velocidade:");
        int velocidade = scanner.nextInt();
        System.out.println("Informe a marca:");
        String marca = scanner.next();
        System.out.println("Informe a modelo:");
        String modelo = scanner.next();
        System.out.println("Informe o id do Jato:");
        Integer idJato = scanner.nextInt();
        try {
            Jato jato = new Jato(
                idJato,
                marca,
                modelo,
                nome,
                cor,
                velocidade
            );
            jato.atualizar(scanner);
            System.out.println("Jato alterado com sucesso!");
            System.out.println(jato);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alterarCompanhia(Scanner scanner){
        System.out.println("Informe o cnpj:");
        String cnpj = scanner.next();
        System.out.println("Informe o nome:");
        String nome = scanner.next();
        System.out.println("Informe o id do Companhia:");
        Integer idCompanhia = scanner.nextInt();
        try {
            Companhia companhia = new Companhia(
                idCompanhia,
                nome,
                cnpj
            );
            companhia.atualizar(scanner);
            System.out.println("Companhia alterado com sucesso!");
            System.out.println(companhia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alterarPista(Scanner scanner){
        System.out.println("Informe o numero:");
        String numero = scanner.next();
        System.out.println("Informe o id do Pista:");
        Integer idPista = scanner.nextInt();
        try {
            Pista pista = new Pista(
                idPista,
                numero
            );
            pista.atualizar(scanner);
            System.out.println("Pista alterado com sucesso!");
            System.out.println(pista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alterarHangar(Scanner scanner){
        System.out.println("Informe o local:");
        String local = scanner.next();
        System.out.println("Informe o id do Hangar:");
        Integer idHangar = scanner.nextInt();
        try {
            Hangar hangar = new Hangar(
                idHangar,
                local
            );
            hangar.atualizar(scanner);
            System.out.println("Hangar alterado com sucesso!");
            System.out.println(hangar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alterarVoo(Scanner scanner){
        System.out.println("Informe o numero:");
        String numero = scanner.next();
        System.out.println("Informe o id do Voo:");
        Integer idVoo = scanner.nextInt();
        System.out.println("Informe a data:");
        String data = scanner.next();
        System.out.println("Informe a hora:");
        String hora = scanner.next();
        System.out.println("Informe a origem:");
        String origem = scanner.next();
        System.out.println("Informe a destino:");
        String destino = scanner.next();
        System.out.println("Informe a piloto:");
        String piloto = scanner.next();
        System.out.println("Informe a copiloto:");
        String copiloto = scanner.next();
        System.out.println("Informe a observacao:");
        String observacao = scanner.next();
        try {
            Voo voo = new Voo(
                idVoo,
                numero,
                data,
                hora,
                origem,
                destino,
                piloto,
                copiloto,
                observacao
            );
            voo.atualizar(scanner);
            System.out.println("Voo alterado com sucesso!");
            System.out.println(voo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void cadastrarCompanhia(Scanner scanner){
        System.out.println("Informe o cnpj:");
        String cnpj = scanner.next();
        System.out.println("Informe o nome:");
        String nome = scanner.next();
        try {
            Companhia companhia = new Companhia(
                nome,
                cnpj
            );
            companhia.atualizar(scanner);
            System.out.println("Companhia cadastrado com sucesso!");
            System.out.println(companhia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarPista(Scanner scanner){
        System.out.println("Informe o numero:");
        String numero = scanner.next();
        try {
            Pista pista = new Pista(
                numero
            );
            pista.atualizar(scanner);
            System.out.println("Pista cadastrado com sucesso!");
            System.out.println(pista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarHangar(Scanner scanner){
        System.out.println("Informe o local:");
        String local = scanner.next();
        try {
            Hangar hangar = new Hangar(
                local
            );
            hangar.atualizar(scanner);
            System.out.println("Hangar cadastrado com sucesso!");
            System.out.println(hangar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarVoo(Scanner scanner){
        System.out.println("Informe o numero:");
        String numero = scanner.next();
        System.out.println("Informe a data:");
        String data = scanner.next();
        System.out.println("Informe a hora:");
        String hora = scanner.next();
        System.out.println("Informe a origem:");
        String origem = scanner.next();
        System.out.println("Informe a destino:");
        String destino = scanner.next();
        System.out.println("Informe a piloto:");
        String piloto = scanner.next();
        System.out.println("Informe a copiloto:");
        String copiloto = scanner.next();
        System.out.println("Informe a observacao:");
        String observacao = scanner.next();
        try {
            Voo voo = new Voo(
                numero,
                data,
                hora,
                origem,
                destino,
                piloto,
                copiloto,
                observacao
            );
            voo.atualizar(scanner);
            System.out.println("Voo cadastrado com sucesso!");
            System.out.println(voo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void sair() {
        System.out.println("Saindo...");
        System.exit(0);
    }
}


