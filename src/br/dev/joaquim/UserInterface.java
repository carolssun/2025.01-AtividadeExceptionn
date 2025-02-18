package br.dev.joaquim;

import java.util.Random;
import java.util.Scanner;

import br.dev.joaquim.bank.BankAccount;
import br.dev.joaquim.bank.InsufficientFundsException;

/**
 * permite o usuário criar uma conta, depositar, sacar e visualizar infos
 */
public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private BankAccount account;


    /**
     * exibe mensagem de boas vindas e cria uma nova conta bancária
     */
    private void welcome() {
        System.out.println("Bem-vindo ao sistema bancário");
        System.out.print("Vamos criar usa conta, informe seu nome: ");
        String holderName = input.nextLine();
        int accountNumber = 1000 + (new Random()).nextInt(8999);
        System.out.println("Criamos uma conta com o número: " + accountNumber + ", com saldo igual a 0 (zero).");
        this.account = new BankAccount(accountNumber, 0, holderName);
    }


    /**
     * exibe o menu de opções p/ o usuário
     */
    private void showMenu() {
        System.out.println("\n\n-----------------------");
        System.out.println("Escolha uma das opções:");
        System.out.println("\t1. Verificar dados da conta.");
        System.out.println("\t2. Depositar.");
        System.out.println("\t3. Sacar.");
        System.out.println("\t4. Sair.");
        System.out.print("opção > ");
    }

    /**
     * inicia o sistema e permite ao usuário interagir com a conta
     * exibe o menu e executa as ações
     */
    public void start() {
        welcome();
        if (account == null)
            return;

        while (true) {
            showMenu();
            try {
                int choice = readOption();
                switch (choice) {
                    case 1:
                        System.out.println("\n" + this.account);
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw(); 
                        break;
                    case 4:
                        System.out.println("Até a próxima.");
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                waitUser();
            } catch (NumberFormatException ex) {
                System.out.println("Valor informado não é um número");
            }
        }
    }

    /**
     * realizar um depósito na conta bancária 
     * solicita o valor a ser depositado e chama o método de depósito da conta
     */
    private void deposit() {
        System.out.print("\nInforme o valor a ser depositado: ");
        double value = readValue();
        account.deposit(value);
        System.out.println("Desposito realizado com sucesso.");
    }

    /**
     * realiza um saque na conta bancária
     * Solicita o valor a ser sacado e chama o método de saque 
     * Caso não haja saldo suficiente, ativar a exceção {@throw InsufficientFundsException}
     *      
     */

    private void withdraw() {
        System.out.print("\nInforme o valor a ser sacado: ");
        double value = readValue();
        try{
            account.withdraw(value) ; 
            System.out.println("Saque realizado com sucesso");
        }catch(InsufficientFundsException e){
            System.out.println ("Erro: " + e.getMessage());     
        }
    }

    /**
     * lê a opção escolhida a partir da entrada
     * @return - a opção escolhida pelo usuário
     * @throws NumberFormatException - sse o valor informado não puder ser convertido para um inteiro
     */

    private int readOption() {
        String choiceString = input.nextLine();
        return Integer.parseInt(choiceString);
    }

    /** mesma coisa que o anterior
     * @return - o valor escolhido pelo usuário
     * @throws NumberFormatException - se o valor informado não puder ser convertido para int
     */

    private double readValue() {
        String line = input.nextLine();
        return Double.parseDouble(line);
    }

    private void waitUser() {
        System.out.println("pressione ENTER para continuar...");
        input.nextLine();
    }
}
