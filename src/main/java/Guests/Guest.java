package Guests;

public class Guest {
    
    private String name;
    private int walletValue;
    
    public Guest(String name, int walletValue) {
        this.name = name;
        this.walletValue = walletValue;
    }

    public int getWalletValue() {
        return walletValue;
    }

    public String getName() {
        return name;
    }

    public void reduceWalletValue(int roomCharge) {
        this.walletValue -= roomCharge;
    }

    public boolean hasSufficientFunds(int charge) {
        return charge <= this.walletValue;
    }
}
