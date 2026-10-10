public class UserWallet {
    private double balance;
    public UserWallet(double initialBalance)
    {
        this.balance = initialBalance;
    }

    //getter read only access;
    public double getBalance()
    {
        return balance;
    }
    public void addMoney(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.println("Added: "+amount+".new Balance :" + balance);
        }
        else {
            System.out.println("Invalid amount.");
        }
    }
    public boolean deductMoney(double amount)
    {
        if(amount > 0 && balance >= amount)
        {
            balance -= amount;
            return true;
        }
        return false;
    }
}
