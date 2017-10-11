package register.util;

import javax.swing.table.AbstractTableModel;

public class StudentModel extends AbstractTableModel {
	StudentArrays sa=null;
	private static StudentModel studentModel;
	private StudentModel(){}
	public StudentModel(int i){}
	public synchronized static StudentModel getInstance(){
		if(studentModel==null){
			studentModel=new StudentModel();
		}
		return studentModel;
	}
	public int getColumnCount() {
		int i=sa.getStudentOne().length;
		return i;
	}

	public int getRowCount() {
		int rows=sa.getStudentTwo().length;
		return rows;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return sa.getStudentTwo()[rowIndex][columnIndex];
	}

	public String getColumnName(int column) {
		return sa.getStudentOne()[column];
	}

	public void setSa(StudentArrays sa) {
		this.sa = sa;
	}

	

}
