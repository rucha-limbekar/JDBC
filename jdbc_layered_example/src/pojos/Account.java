package pojos;

public class Account {

	private int accNo;
	private String custName;
	private String accType;
	private double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", custName=" + custName + ", accType=" + accType + ", balance=" + balance
				+ "]";
	}
	
}
