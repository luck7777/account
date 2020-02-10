package entities;

import model.exceptions.DomainExceptions;

public class Account {
		
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Integer getNumber() {
		return number;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public void whitDraw(double amount) {
		if(amount > getWithDrawLimit()) {
			throw new DomainExceptions("Withdraw error: The amount exceeds withdraw limit");
		}
		if(amount > getBalance()) {
			throw new DomainExceptions("Withdraw error: Not enough balance");
		}
		balance -= amount;
	}
	@Override
	public String toString () {
		return "New Balance: " + balance;
	}
}
