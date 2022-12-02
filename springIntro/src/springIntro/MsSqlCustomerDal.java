package springIntro;

public class MsSqlCustomerDal implements ICustomerDal{

	String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	@Override
	public void add() {
		System.out.println("Baglanti string i : "+this.connectionString);
		System.out.println("MsSql veri tabanıona eklendi");
		
	}

}
