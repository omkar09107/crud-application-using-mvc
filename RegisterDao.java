package bank.dao.register;

import java.util.List;

import bank.model.Register;

public interface RegisterDao {

	int createRecord(List<Register>lst);
	List<Register>retriveRecord(int accNumber);
	int deleteRecord(int accNumber);
	int updateRecord(List<Register>lst);
	List<Register>displayAll();
	
	
}
