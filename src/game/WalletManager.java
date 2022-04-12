package game;

public class WalletManager {

    private int Balance;

    public WalletManager(int balance) {
        Balance = balance;
    }

    public int getBalance() {
        return Balance;
    }

    public void addBalance(int value){
        Balance += value;
    }

    public void deductBalance(int value){
        Balance -= value;
    }
}

