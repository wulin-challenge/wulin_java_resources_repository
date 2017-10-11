package cn.scxh.ittx.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.ui.shared.EditVariousComponent;
import cn.scxh.ittx.util.SharedModel;


public class DifferenceObject {
	private String id;
	private List<Boolean> flagList=new ArrayList<Boolean>();
	private Map<String,DifferenceObject>  differenceObjectMap=new HashMap<String,DifferenceObject>();
	private String flag;
	private SharedModel sharedModel;
	private JFrame jframe;
	private  Map<String,JFrame> jframeMap=new HashMap<String,JFrame>();
	private JLabel jlabel;
	private Map<String,JLabel> jlabelMap=new HashMap<String,JLabel>();
	private JTextField jtextField;
	private Map<String,JTextField> jtextFieldMap=new HashMap<String,JTextField>();
	private JPasswordField jpasswordField;
	private JButton jbutton;
	private Map<String,JButton> jbuttonMap=new HashMap<String,JButton>();
	private Map<String,JRadioButton> jradioButtonMap=new HashMap<String,JRadioButton>();
	private ButtonGroup buttonGroup=new  ButtonGroup();
	private JTable jtable;
	private JComboBox jcomboBox;
	private Map<String,JComboBox> jcomboBoxMap=new HashMap<String,JComboBox>();
	private Map<String,JPanel> jpanelMap=new HashMap<String,JPanel>();
	private JPanel jpanel;
	private DifferenceComponent differenceComponent;
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
	public Map<String, JComboBox> getJcomboBoxMap() {
		return jcomboBoxMap;
	}
	public void setJcomboBoxMap(Map<String, JComboBox> jcomboBoxMap) {
		this.jcomboBoxMap = jcomboBoxMap;
	}
	public Map<String, JPanel> getJpanelMap() {
		return jpanelMap;
	}
	public void setJpanelMap(Map<String, JPanel> jpanelMap) {
		this.jpanelMap = jpanelMap;
	}
	public JPanel getJpanel() {
		return jpanel;
	}
	public void setJpanel(JPanel jpanel) {
		this.jpanel = jpanel;
	}
	public DifferenceComponent getDifferenceComponent() {
		return differenceComponent;
	}
	public void setDifferenceComponent(DifferenceComponent differenceComponent) {
		this.differenceComponent = differenceComponent;
	}
	public SharedModel getSharedModel() {
		return sharedModel;
	}
	public void setSharedModel(SharedModel patientModel) {
		this.sharedModel = patientModel;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Map<String, DifferenceObject> getDifferenceObjectMap() {
		return differenceObjectMap;
	}
	public void setDifferenceObjectMap(
			Map<String, DifferenceObject> differenceObjectMap) {
		this.differenceObjectMap = differenceObjectMap;
	}
	public List<Boolean> getFlagList() {
		return flagList;
	}
	public void setFlagList(List<Boolean> flagList) {
		this.flagList = flagList;
	}
	public Map<String, JButton> getJbuttonMap() {
		return jbuttonMap;
	}
	public void setJbuttonMap(Map<String, JButton> jbuttonMap) {
		this.jbuttonMap = jbuttonMap;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
