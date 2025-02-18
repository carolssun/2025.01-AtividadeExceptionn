import br.dev.joaquim.UserInterface;
import br.dev.joaquim.bank.BankAccount;
import br.dev.joaquim.bank.InsufficientFundsException;

public class Main {
    public static void main(String[]args){
        try{
            // criando contas
            BankAccount c1 =new BankAccount (0001, 100.00, "João");
            BankAccount c2 =new BankAccount (0002, 200.00, "Ana Clara");
            BankAccount c3 =new BankAccount (0003, 300.00, "Alberto");

            // exibindo info
            System.out.println("\n=================================\n");
            System.out.println("Teste do sistema: ");
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);

            // fazer deposito
            c1.deposit(50.00);
            c2.deposit(50.00);
            c3.deposit(50.00);
            System.out.println("\nApós depósitos: ");
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);

            // saque válido
            c1.withdraw(30);
            System.out.println("\nApós saque válido: ");
            System.out.println(c1);

            //saque inválido
            System.out.println("\nTentando sacar um valor maior que o saldo:  ");
            c1.withdraw(800.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("\n=================================\n");
        UserInterface main = new UserInterface();
        main.start();
        
    }

}
