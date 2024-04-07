package ru.maksmusic.model;

/**
 * UserAccount: класс для представления пользователя, который содержит
 */
public class UserAccount  extends Account{
    private double balance;
    public UserAccount(String id, String login, String password) {
        super(id, login, password);
    }

    public double getBalance() {
        return balance;
    }
}
