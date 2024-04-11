import java.util.Scanner;


public class SistemaBancario {

    static double recebePix(double saldo, double valor) {
        saldo += valor;
        return saldo;
    }

    static double transferePix(double saldo, double valor) {
        saldo -= valor;
        return saldo;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome = "";
        String tipoConta = "";
        int idCliente = 0;
        double saldo = 0;

        //Menu de seleção inicial
        String menuInicial = """
                                
                ************************************
                Olá! Boas-vindas ao sistema AluBank
                 
                1- Incluir novo cliente
                2- Pesquisar cliente (id)
                3- Sair                          
                                                                 
                ************************************                
                """;

        System.out.println(menuInicial);
        System.out.println("Entre com a opção desejada: ");
        int opMenu = sc.nextInt();

        while (opMenu != 3) {
            if (opMenu == 1) {
                pausar(1000);
                System.out.println("--- Inclusão de cliente ---");
                sc.nextLine();
                System.out.print("Nome: ");
                nome = sc.nextLine();
                System.out.print("Tipo de conta: ");
                tipoConta = sc.nextLine();
                System.out.print("Saldo inicial: ");
                saldo = sc.nextDouble();
                idCliente++;
                System.out.println("Cadastro concluído com sucesso! O ID do cliente é: " + idCliente);
                pausar(2000);

            } else if (opMenu == 2) {
                if (idCliente == 0) {
                    System.out.println("Nenhum cliente foi encontrado. Saíndo do sistema...");
                    pausar(1000);
                    break;

                } else {
                    pausar(1000);
                    System.out.println("Digite o ID do cliente que deseja pesquisar: ");
                    int id = sc.nextInt();
                    pausar(1500);

                    if (id == idCliente) {
                        System.out.println("-----------------------------");
                        System.out.println("Dados cadastrais do cliente:");
                        System.out.println("ID: " + idCliente);
                        System.out.println("Nome: " + nome);
                        System.out.println("Tipo da conta: " + tipoConta);
                        System.out.println("Saldo: " + saldo);
                        System.out.println("-----------------------------");
                        pausar(2000);

                        System.out.println("Deseja efetuar alguma movimentação neste cliente? 1- Sim; 2- Não. ");
                        int menuMovimenta = sc.nextInt();
                        pausar(2000);

                        //Menu de operações
                        if (menuMovimenta == 1) {
                            String opcoes = """
                                    -= Operações =-

                                    1- Consultar saldos
                                    2- Receber valor
                                    3- Transferir valor
                                    4- Voltar para o menu anterior

                                    Digite a opção desejada : """;

                            System.out.println(opcoes);
                            int idOpcao = sc.nextInt();
                            pausar(2000);


                            while (idOpcao != 4) {

                                switch (idOpcao) {
                                    case 1:
                                        System.out.printf("Saldo atual: %.2f", saldo);
                                        System.out.println();
                                        System.out.println("***********************");
                                        break;

                                    case 2:
                                        System.out.println("Informe o valor a receber: ");
                                        double valorEntrada = sc.nextDouble();

                                        saldo = recebePix(saldo, valorEntrada);

                                        System.out.printf("Saldo atualizado R$ %.2f", saldo);
                                        System.out.println();
                                        System.out.println("***********************");
                                        break;

                                    case 3:
                                        System.out.println("Informe o valor que deseja transferir: ");
                                        double valorSaida = sc.nextDouble();

                                        if (valorSaida > saldo) {
                                            System.out.println("Saldo insuficiente!");
                                            System.out.println("***********************");
                                        } else {
                                            saldo = transferePix(saldo, valorSaida);
                                            System.out.printf("Saldo atualizado R$ %.2f", saldo);
                                            System.out.println();
                                            System.out.println("***********************");
                                        }
                                        break;

                                    default:
                                        System.out.println("Opção inválida! ");
                                        System.out.println();
                                        System.out.println("***********************");
                                        break;

                                }

                                System.out.println(opcoes);
                                idOpcao = sc.nextInt();


                            }
                        }


                    } else {
                        System.out.println("Nenhum cliente foi encontrado. Saíndo do sistema...");
                        break;

                    }
                }

            }
            else {
                System.out.println("Opção inválida! Saíndo do sistema...");
                break;
            }

            System.out.println(menuInicial);
            System.out.println("Entre com a opção desejada: ");
            opMenu = sc.nextInt();

        }

        System.out.println("Saindo do sistema...");
        pausar(2000);

    }


    public static void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}




