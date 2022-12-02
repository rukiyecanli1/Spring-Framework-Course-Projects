package springIntro;

public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	
	//constructor injection
	//public CustomerManager(ICustomerDal customerDal) {
		//this.customerDal = customerDal;
	//}
	
    //setter injection
	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	@Override
	public void add() {
     // business rules
     customerDal.add();
	}
}
