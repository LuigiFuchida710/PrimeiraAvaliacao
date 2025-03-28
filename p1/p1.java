import java.util.ArrayList;

// Superclasse ContaBancaria
class ContaBancaria {
    protected String titular;
    protected int numeroConta;
    protected double saldo;

    public ContaBancaria(String titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    // Getters e Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado.");
    }

    // Sobrecarga do método depositar
    public void depositar(double valor, String origem) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado via " + origem);
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado.");
            return true;
        }
        System.out.println("Saldo insuficiente.");
        return false;
    }
}

// Subclasse ContaCorrente
class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial = 500.0;

    public ContaCorrente(String titular, int numeroConta) {
        super(titular, numeroConta);
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado usando cheque especial.");
            return true;
        }
        System.out.println("Saldo insuficiente, mesmo com cheque especial.");
        return false;
    }
}

// Subclasse ContaPoupanca
class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String titular, int numeroConta) {
        super(titular, numeroConta);
    }
}

// Classe Banco para gerenciar contas
class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void criarContaCorrente(String titular, int numeroConta) {
        contas.add(new ContaCorrente(titular, numeroConta));
    }

    public void criarContaPoupanca(String titular, int numeroConta) {
        contas.add(new ContaPoupanca(titular, numeroConta));
    }

    public ContaBancaria buscarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}