package cn.scxh.ittx.ui.hospitalFrame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.ui.shared.EditVariousComponent;
import cn.scxh.ittx.ui.shared.MedicineClassifyTree;
import cn.scxh.ittx.util.ConstantUtils;

public class DisposeMedicineFrame {

	public void addDiposeMedicineFrame() {
		JFrame jFrame = new JFrame("处方");
		jFrame.setBounds(ConstantUtils.WIDTH / 8, ConstantUtils.HEIGHT / 10,
				ConstantUtils.WIDTH - ConstantUtils.WIDTH / 4,
				ConstantUtils.HEIGHT - ConstantUtils.HEIGHT / 6);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JPanel bigJPanel = new JPanel();
		bigJPanel.setBounds(ConstantUtils.WIDTH / 8, ConstantUtils.HEIGHT / 10,
				ConstantUtils.WIDTH - ConstantUtils.WIDTH / 4,
				ConstantUtils.HEIGHT - ConstantUtils.HEIGHT / 6);

		jSlitPaneDisposeMedicinal(jFrame, bigJPanel);
		jFrame.add(bigJPanel);
		jFrame.setVisible(true);
	}

	public void jSlitPaneDisposeMedicinal(JFrame jFrame, JPanel bigJPanel) {
		JPanel leftJPanel = new JPanel();
		JPanel rightJPanel = new JPanel();
		JTabbelOfLeftJPanel(jFrame, leftJPanel, rightJPanel);
		leftJPanel.setPreferredSize(new Dimension(300, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 6 - 60));
		rightJPanel.setPreferredSize(new Dimension(700, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 6 - 60));
		JSplitPane horizontalJSplitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, leftJPanel, rightJPanel);
		bigJPanel.add(horizontalJSplitPane);
	}

	// 左边的JTabbedPane
	private void JTabbelOfLeftJPanel(JFrame jFrame, JPanel leftJPanel,
			JPanel rightJPanel) {
		JPanel jPanel10 = new JPanel();
		JPanel jPanel11 = new JPanel();

		jPanel10.setLayout(null);
		DifferenceObject object10 = new DifferenceObject();
		DifferenceComponent dc10 = new DifferenceComponent(object10);
		object10.setDifferenceComponent(dc10);
		object10.setJpanel(jPanel10);
		object10.setJframe(jFrame);

		jPanel11.setLayout(null);
		DifferenceObject object11 = new DifferenceObject();
		DifferenceComponent dc11 = new DifferenceComponent(object11);
		object11.setDifferenceComponent(dc11);
		object11.setJpanel(jPanel11);
		object11.setJframe(jFrame);

		object10.getDifferenceObjectMap().put("object11", object11);
		object11.getDifferenceObjectMap().put("object10", object10);
		JTabbelOfRightJPanel(rightJPanel, object10);
		bufferedJPanel10(object10);
		bufferedJPanel11(object11);
		JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.add("经验方/用法", jPanel10);
		jTabbedPane.add("历史处方", jPanel11);
		jTabbedPane.setPreferredSize(new Dimension(ConstantUtils.WIDTH
				- ConstantUtils.WIDTH / 4 - 720, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 6 - 60));
		leftJPanel.add(jTabbedPane);
	}

	// 右边的JTabbedPane
	private void JTabbelOfRightJPanel(JPanel rightJPanel,
			DifferenceObject object10) {
		DifferenceObject object11 = object10.getDifferenceObjectMap().get(
				"object11");
		JPanel jPanel12 = new JPanel();
		JPanel jPanel13 = new JPanel();

		jPanel12.setLayout(null);
		DifferenceObject object12 = new DifferenceObject();
		DifferenceComponent dc12 = new DifferenceComponent(object12);
		object12.setDifferenceComponent(dc12);
		object12.setJpanel(jPanel12);

		jPanel13.setLayout(null);
		DifferenceObject object13 = new DifferenceObject();
		DifferenceComponent dc13 = new DifferenceComponent(object13);
		object13.setDifferenceComponent(dc13);
		object13.setJpanel(jPanel13);

		object10.getDifferenceObjectMap().put("object12", object12);
		object10.getDifferenceObjectMap().put("object13", object13);
		object12.getDifferenceObjectMap().put("object10", object10);
		object13.getDifferenceObjectMap().put("object10", object10);
		object11.getDifferenceObjectMap().put("object12", object12);
		object11.getDifferenceObjectMap().put("object13", object13);
		object12.getDifferenceObjectMap().put("object11", object11);
		object13.getDifferenceObjectMap().put("object11", object11);
		bufferedJPanel12(object12);
		bufferedJPanel13(object13);
		JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.add("西药处方", jPanel12);
		jTabbedPane.add("中药处方", jPanel13);
		jTabbedPane.setPreferredSize(new Dimension(ConstantUtils.WIDTH
				- ConstantUtils.WIDTH / 4 - 320, ConstantUtils.HEIGHT
				- ConstantUtils.HEIGHT / 6 - 60));
		rightJPanel.add(jTabbedPane);
	}

	private void bufferedJPanel10(DifferenceObject object10) {
		EditVariousComponent evc=new EditVariousComponent();
		MedicineClassifyTree mcf=new MedicineClassifyTree(object10);
		evc.editJPanel10Component(object10);
		mcf.createTreeAndNode();
	}

	private void bufferedJPanel11(DifferenceObject object11) {

	}
	
	private void bufferedJPanel12(DifferenceObject object12) {

	}

	private void bufferedJPanel13(DifferenceObject object13) {

	}

	public static void main(String[] args) {
		DisposeMedicineFrame dmf = new DisposeMedicineFrame();
		dmf.addDiposeMedicineFrame();
	}

}
