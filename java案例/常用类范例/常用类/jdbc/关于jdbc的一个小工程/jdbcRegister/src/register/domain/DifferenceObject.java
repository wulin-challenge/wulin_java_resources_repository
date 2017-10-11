package register.domain;

import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import register.util.StudentModel;

public class DifferenceObject {
	private Frame frame;
	private JFrame jframe;
	private  Map<String,JFrame> jframeMap=new HashMap<String,JFrame>();
	private JLabel jlabel;
	private Map<String,JLabel> jlabelMap=new HashMap<String,JLabel>();
	private JTextField jtextField;
	private Map<String,JTextField> jtextFieldMap=new HashMap<String,JTextField>();
	private JPasswordField jpasswordField;
	private JButton jbutton;
	private Map<String,JRadioButton> jradioButtonMap=new HashMap<String,JRadioButton>();
	private ButtonGroup buttonGroup=new  ButtonGroup();
	private JTable jtable;
	private JComboBox jcomboBox;
	private StudentModel studentModel;
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public JFrame getJframe() {
		return jframe;
	}
	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}
	public JLabel getJlabel() {
		return jlabel;
	}
	public void setJlabel(JLabel jlabel) {
		this.jlabel = jlabel;
	}
	public JTextField getJtextField() {
		return jtextField;
	}
	public void setJtextField(JTextField jtextField) {
		this.jtextField = jtextField;
	}
	public JPasswordField getJpasswordField() {
		return jpasswordField;
	}
	public void setJpasswordField(JPasswordField jpasswordField) {
		this.jpasswordField = jpasswordField;
	}
	public JButton getJbutton() {
		return jbutton;
	}
	public void setJbutton(JButton jbutton) {
		this.jbutton = jbutton;
	}
	public Map<String, JLabel> getJlabelMap() {
		return jlabelMap;
	}
	public void setJlabelMap(Map<String, JLabel> jlabelMap) {
		this.jlabelMap = jlabelMap;
	}
	public Map<String, JTextField> getJtextFieldMap() {
		return jtextFieldMap;
	}
	public void setJtextFieldMap(Map<String, JTextField> jtextFieldMap) {
		this.jtextFieldMap = jtextFieldMap;
	}
	public Map<String, JRadioButton> getJradioButtonMap() {
		return jradioButtonMap;
	}
	public void setJradioButtonMap(Map<String, JRadioButton> jradioButtonMap) {
		this.jradioButtonMap = jradioButtonMap;
	}
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}
	public JTable getJtable() {
		return jtable;
	}
	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}
	public StudentModel getStudentModel() {
		return studentModel;
	}
	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}
	public Map<String, JFrame> getJframeMap() {
		return jframeMap;
	}
	public void setJframeMap(Map<String, JFrame> jframeMap) {
		this.jframeMap = jframeMap;
	}
	public JComboBox getJcomboBox() {
		return jcomboBox;
	}
	public void setJcomboBox(JComboBox jcomboBox) {
		this.jcomboBox = jcomboBox;
	}
}
