package ru.maksmusic.model;

/**
 * UserAccount: класс для представления пользователя, который содержит
 */
public class UserAccount extends Account{
    private double balance;
    public UserAccount(Long id, String login, String password) {
        super(id, login, password);
    }

    //Имплементация метода: getIdUsers, в классе наследнике от Account, о причинах и функционале читай -> UserService
    public long getIdUsers(){return id;};
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
