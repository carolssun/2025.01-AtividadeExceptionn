package br.dev.joaquim.bank;
/**
 * Exceção personalizada que é lançada quando uma operação bancária não pode ser realizada devido à falta de fundos na conta
 * 
 */
public class InsufficientFundsException extends Exception {

    /**
     * construtor que inicializa a exceção com uma mensagem personalizada
     * @param message - mensagem que descreve o porquê do erro/exceção
     */
    public InsufficientFundsException (String message) {
        super(message);
    }
    
}
