package cn.scxh.ittx.ui.hospitalFrame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.PatientServiceImpl;
import cn.scxh.ittx.service.intf.PatientService;
import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.ui.shared.EditVariousComponent;
import cn.scxh.ittx.util.ConstantUtils;
import cn.scxh.ittx.util.SharedModel;

public class PatientConsultFrame {
	public void patientConsult() {
		DifferenceObject object = new DifferenceObject();
		DifferenceComponent dc = new DifferenceComponent(object);
		object.setDifferenceComponent(dc);
		JFrame jFrame = new JFrame("≤°»À◊…—Ø");
		object.setJframe(jFrame);
		jFrame.setLayout(null);
		jFrame.setBounds(0, 0, ConstantUtils.WIDTH, ConstantUtils.HEIGHT);
		patientConsultSplitPane(jFrame, object);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setVisible(true);
	}
	
	// JTable
	public void leftJPanelContext(JPanel leftJPanel, DifferenceObject object) {
		leftJPanel.setLayout(null);
		PatientService ps = new PatientServiceImpl();
		SharedModel patientModel = new SharedModel();
		try {
			patientModel.setPatientArrays(ps.queryPatients(new Patient()));
		} catch (QueryObjectException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "≤È—Ø≥ˆ¥Ì¡À");
		}
		JTable jTable = new JTable(patientModel);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		object.getJpanelMap().put("TableJPanel", leftJPanel);
		object.setJtable(jTable);
		object.setSharedModel(patientModel);
		jScrollPane.setBounds(0, 0, ConstantUtils.WIDTH, ConstantUtils.HEIGHT);
		leftJPanel.add(jScrollPane);
	}

	// JSplitPane
	public void patientConsultSplitPane(JFrame jFrame, DifferenceObject object) {
		JPanel primaryJPanel = new JPanel();
		JPanel topJPanel = new JPanel();
		JPanel bottomJPanel = new JPanel();
		JPanel leftJPanel = new JPanel();
		JPanel rightJPanel = new JPanel();

		// -------------------------------
		EditVariousComponent evc=new EditVariousComponent();
		evc.topJPanelContext(topJPanel, object);
		leftJPanelContext(leftJPanel, object);

		// ----------------------------------

		JSplitPane jSplitPaneVertical = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT, topJPanel, bottomJPanel);
		JSplitPane jSplitPaneHorezontal = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, leftJPanel, rightJPanel);

		leftJPanel.setPreferredSize(new Dimension(ConstantUtils.WIDTH / 4,
				ConstantUtils.HEIGHT - ConstantUtils.HEIGHT / 8));
		rightJPanel.setPreferredSize(new Dimension(ConstantUtils.WIDTH
				- ConstantUtils.WIDTH / 4, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 8));

		topJPanel.setPreferredSize(new Dimension(ConstantUtils.WIDTH,
				ConstantUtils.HEIGHT / 14));
		bottomJPanel.setPreferredSize(new Dimension(ConstantUtils.WIDTH,
				ConstantUtils.HEIGHT - ConstantUtils.HEIGHT / 8));

		patientConsultTabbedPane(rightJPanel, object);
		primaryJPanel
				.setBounds(0, 0, ConstantUtils.WIDTH, ConstantUtils.HEIGHT);
		bottomJPanel.add(jSplitPaneHorezontal);
		primaryJPanel.add(jSplitPaneVertical);
		jFrame.add(primaryJPanel);
	}

	// JTabbedPane
	public void patientConsultTabbedPane(JPanel rightJPanel,
			DifferenceObject object) {
		JPanel tabbedPaneJPanel1 = new JPanel();
		JPanel tabbedPaneJPanel2 = new JPanel();
		tabbedPaneJPanel2Contect(tabbedPaneJPanel2,object);
		// --------------------------

		EditVariousComponent evc=new EditVariousComponent();
		evc.tabbedPaneJPanel1Context(tabbedPaneJPanel1, object);
	
		// --------------------------
		JTabbedPane jTabbelPane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.WRAP_TAB_LAYOUT);

		jTabbelPane.add("≥ı’Ôµ«º«", tabbedPaneJPanel1);
		jTabbelPane.add("≤°¿˝π‹¿Ì", tabbedPaneJPanel2);

		rightJPanel.add(jTabbelPane);
		jTabbelPane.setPreferredSize(new Dimension(ConstantUtils.WIDTH
				- ConstantUtils.WIDTH / 4, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 8));
	}

	private void tabbedPaneJPanel2Contect(JPanel jPanel2 ,DifferenceObject object) {
		JPanel jPanel21=new JPanel();
		JPanel jPanel22=new JPanel();
		//------------------------
		EditVariousComponent evc=new EditVariousComponent();
		evc.tabbedPaneJPanel2ContectJPanel21(jPanel21,object);
		
		//------------------------
		JTabbedPane jTabbedPane2=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane2.add("≤°¿˙√Ë ˆ",jPanel21);
		jTabbedPane2.add("≤°¿˙Õº∆¨",jPanel22);
		jPanel2.add(jTabbedPane2);
		jTabbedPane2.setPreferredSize(new Dimension(ConstantUtils.WIDTH
				- ConstantUtils.WIDTH / 4, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 8));
	}

	public static void main(String[] args) {
		PatientConsultFrame fcf = new PatientConsultFrame();
		fcf.patientConsult();
	}
}
