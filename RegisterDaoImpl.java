package bank.dao.register;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import bank.dao.DBcon;
import bank.model.Login;
import bank.model.Register;

public class RegisterDaoImpl implements RegisterDao {

	@Override
	public int createRecord(List<Register> lst) {
		// TODO Auto-generated method stub
		int i=0;
		Connection con = DBcon.myConnection();
		Register rmodel = lst.get(0);
		
		try {
			PreparedStatement pstate = con.prepareStatement("insert into crudBank values(?,?,?,?,?)");
			pstate.setInt(1, rmodel.getAccNumber());
			pstate.setString(2,rmodel.getAccFname());
			pstate.setString(3, rmodel.getAccUname());
			pstate.setString(4, rmodel.getAccPassword());
			pstate.setFloat(5, rmodel.getAccBal());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<Register> retriveRecord(int accNumber) {
		// TODO Auto-generated method stub
		Connection con =DBcon.myConnection();
		List<Register> lstrecord = null;
		
		try {
			PreparedStatement pstate = con.prepareStatement("select * from crudBank where accNumber = ?");
			pstate.setInt(1, accNumber);
			ResultSet result = pstate.executeQuery();
			
			if(result.next()) {
				int accNumber1 = result.getInt(1);
				String accFname = result.getString(2);
				String accUname = result.getString(3);
				String accPassword = result.getString(4);
				float accBal = result.getFloat(5);
				
				
				 Register rmodel=new Register(accNumber1, accFname, accUname, accPassword, accBal);
				 lstrecord = new LinkedList<Register>();
				 lstrecord.add(rmodel);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstrecord;
		
	}

	@Override
	public int deleteRecord(int accNumber) {
		// TODO Auto-generated method stub
		Connection con=DBcon.myConnection();
		int i=0;
		
		try {
			PreparedStatement pstate = con.prepareStatement("delete from crudBank where accNumber=?");
			pstate.setInt(1, accNumber);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int updateRecord(List<Register> lst) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Register> displayAll() {
		// TODO Auto-generated method stub
		 Connection con = DBcon.myConnection();
		    List<Register> lstallrecords = new LinkedList<Register>();
		    String str = "select * from crudBank";

		    try {
		        Statement state = 
		        		con.createStatement();
		        ResultSet result = state.executeQuery(str);
		        while (result.next()) {
		            Register robj = new Register(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
		            lstallrecords.add(robj);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return lstallrecords;
	}

	

	public boolean validateUser(List<Login> lst) {
		// TODO Auto-generated method stub
		boolean b =false;
		
		Connection con = DBcon.myConnection();
		Login lobj = lst.get(0);
		
		try {
			PreparedStatement pstate = con.prepareStatement("select * from crudBank where accUname = ? and accPassword = ?");
			pstate.setString(1, lobj.getAccUname());
			pstate.setString(2, lobj.getAccPassword());
			ResultSet result = pstate.executeQuery();
			if(result.next()) {
				b=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	
}
