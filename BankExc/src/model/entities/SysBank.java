package model.entities;

import model.exception.DomainException;

public class SysBank {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public SysBank ()
	{
		
	}
	
	public SysBank(Integer number, String holder, Double balance, Double withDrawLimit)
	{
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit (double amount)
	{
		balance += amount;
	}
	
	public void withDraw (double amount)
	{
		
		if (balance <= 0)
		{
		throw new DomainException ("Balance is empty");
		} else
		if (amount > getWithDrawLimit())
		{
			throw new DomainException ("The value of WithDraw is bigger than the limit");
		} else 
		{
			balance -= amount;
		}
	}
}
