package Chapter7Lab;

public class OhBabyATripleAccountClass
{
	private double balance;
	private String name;
	private long acctNum;

	private static int depositCounter, withdrawCounter;
	private static double totalDeposited, totalWithdrew;

	// -------------------------------------------------
	// Constructor -- initializes balance, owner, and account number
	// -------------------------------------------------
	public OhBabyATripleAccountClass(double initBal, String owner, long number)
	{
		balance = initBal;
		name = owner;
		acctNum = number;
	}

	// -------------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	// -------------------------------------------------
	public void withdraw(double amount)
	{
		if (balance >= amount)
		{
			balance -= amount;
			totalWithdrew += amount;
			withdrawCounter++;
		}

		else
			System.out.println("Insufficient funds");
	}
	// -------------------------------------------------
	// Adds deposit amount to balance.
	// -------------------------------------------------

	public void deposit(double amount)
	{
		balance += amount;
		totalDeposited += amount;
		depositCounter++;
	}

	// -------------------------------------------------
	// Returns balance.
	// -------------------------------------------------
	public double getBalance()
	{
		return balance;
	}

	// -------------------------------------------------
	// Returns a string containing the name, account number, and balance.
	// -------------------------------------------------
	public String toString()
	{
		return "Name: " + name + "\nAccount Number: " + acctNum + "\nBalance: " + balance;
	}

	public static int getDepositCounter()
	{
		return depositCounter;
	}

	public static int getWithdrawCounter()
	{
		return withdrawCounter;
	}

	public static double getTotalDeposited()
	{
		return totalDeposited;
	}

	public static double getTotalWithdrew()
	{
		return totalWithdrew;
	}

	public long getAcctNumber()
	{
		return acctNum;
	}
}
