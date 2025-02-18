package br.dev.joaquim.bank;

public class BankAccount {
  private int accountNumber;
  private double balance;
  private String accountHolderName;

  public BankAccount() {
  }

  /**
   *  Construtor que incializa a conta bancária com  número,saldo e nome
   * @param accountNumber - o número da conta
   * @param balance - o saldo inicial da conta
   * @param accountHolderName - o nome do titular da conta
   */

  public BankAccount(int accountNumber, double balance, String accountHolderName){
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.accountHolderName = accountHolderName;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  /**
   *  realizar um depósito na conta
   * @param value - valor a ser depositado
   * @throws IllegalArgumentException - se o valor informado for negativo, informar mensagem 
   */

  public void deposit(double value) {

    if (value < 0) {
      throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
    }

    this.balance += value;
  }

  /**
   * realizar um saque na conta
   * @param value - valor a ser sacado
   * @throws InsufficientFundsException - se o valor informado for negativo
   * @throws InsufficientFundsException - se o valor sacado for superior ao saldo da conta
   */

  public void withdraw(double value) throws InsufficientFundsException {

    if (value < 0) {
      throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
    }

    if (value > this.balance) {

      throw new InsufficientFundsException ("O valor R$ " + value + " é superior ao saldo [R$ " + this.balance + "]");
    }

    this.balance -= value;
  }

  @Override
  public String toString() {
    return "Conta " + accountNumber + " de " + accountHolderName + " têm R$ " + balance + " de saldo";
  }
}
