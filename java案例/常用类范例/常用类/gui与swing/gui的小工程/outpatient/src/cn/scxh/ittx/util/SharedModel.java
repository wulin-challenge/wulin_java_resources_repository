package cn.scxh.ittx.util;

import javax.swing.table.AbstractTableModel;

import cn.scxh.ittx.domain.SharedArrays;

public class SharedModel extends AbstractTableModel {
	private SharedArrays sharedArrays;

	public int getColumnCount() {
		return sharedArrays.getSharedOneArray().length;
	}

	public int getRowCount() {
		return sharedArrays.getSharedTwoArray().length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return sharedArrays.getSharedTwoArray()[rowIndex][columnIndex];
	}

	public String getColumnName(int column) {
		return sharedArrays.getSharedOneArray()[column];
	}

	public SharedArrays getPatientArrays() {
		return sharedArrays;
	}

	public void setPatientArrays(SharedArrays patientArrays) {
		this.sharedArrays = patientArrays;
	}

}
