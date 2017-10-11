package package3.ui;

import javax.swing.table.AbstractTableModel;

import package3.domain.UserString;

public class UserModel extends AbstractTableModel{
	private UserString userString;
	
	

	public int getRowCount() {
		return userString.getString2().length;
	}

	@Override
	public int getColumnCount() {
		return userString.getString1().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return userString.getString2()[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return userString.getString1()[column];
	}

	
	
	
	
	
	
	
	
	


	public UserString getUserString() {
		return userString;
	}

	public void setUserString(UserString userString) {
		this.userString = userString;
	}
	
	

}
