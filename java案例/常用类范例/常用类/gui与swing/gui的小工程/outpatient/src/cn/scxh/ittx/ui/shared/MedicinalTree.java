package cn.scxh.ittx.ui.shared;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import cn.scxh.ittx.dao.impl.MedicineDaoImpl;
import cn.scxh.ittx.dao.intf.MedicineDao;
import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.util.ConstantUtils;
import cn.scxh.ittx.util.SharedModel;

public class MedicinalTree {
	List<DefaultMutableTreeNode> sharedNodeList = new ArrayList<DefaultMutableTreeNode>();
	private DifferenceObject object;

	public MedicinalTree() {
	}

	public MedicinalTree(DifferenceObject object) {
		this.object = object;
	}

	// 创建树
	public void createTree(JPanel jPanel6) {
		DifferenceObject object6=new DifferenceObject();
		object.getDifferenceObjectMap().put("jPanel6", object6);
		object6.getDifferenceObjectMap().put("jPanel5", object);
		object6.getDifferenceObjectMap().put("object7", object.getDifferenceObjectMap().get("object7"));
		object.getDifferenceObjectMap().get("object7").getDifferenceObjectMap().put("object6",object6);
		object6.setJpanel(jPanel6);
		jPanel6.setLayout(null);
		DefaultMutableTreeNode node1;
		node1 = oneNode();

		JTree jTree = new JTree(node1);
		// jTree.setEnabled(true);
		jTree.setEditable(true);
		jTree.setBounds(0, 0, 800, 600);
		autoGetData(jTree);
		treeMouseListener(jTree);

		jPanel6.add(jTree);
	}

	// 自动获取数据
	public void autoGetData(JTree jTree) {
		DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
		DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) model.getRoot();

		isRecursionQuery(jTree,node1);
		showTableData(sharedNodeList);
	}

	// 显示表数据
	public void showTableData(List<DefaultMutableTreeNode> sharedNodeList2) {
		DifferenceObject object7=object.getDifferenceObjectMap().get("object7");
		SharedModel sharedModel=new SharedModel();
		object7.setSharedModel(sharedModel);
		try {
			sharedModel.setPatientArrays(queryMedicines(sharedNodeList2));
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		JTable jTable7=new JTable(sharedModel);
		object7.setJtable(jTable7);
		JScrollPane jScrollPane=new JScrollPane(jTable7);
		jScrollPane.setBounds(0,0,ConstantUtils.WIDTH-ConstantUtils.WIDTH/4-225,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6-160);
		
		JPanel jPanel7=object7.getJpanel();
		jPanel7.add(jScrollPane);
		
	}

	//数据转换方法
	public SharedArrays queryMedicines(List<DefaultMutableTreeNode> sharedNodeList2)
			throws QueryObjectException {
		String[] oneArray = new String[] { "编号", "名称", "药品类别", "药品规格", "进口单位",
				"进口价格", "成本价格", "验证码", "销售价格", "简单名称", "库存上限", "库存下限", "批准编号",
				"生产公司", "主要成分", "药品功效", "使用方法", "注意事项" };
		SharedArrays sharedArrays = new SharedArrays();
		List<List<Medicine>> listList=new ArrayList<List<Medicine>>();
		MedicineDao md = new MedicineDaoImpl();
		Medicine medicine=new Medicine();
		try{
		int sum=0;
		int i=0;
		for(DefaultMutableTreeNode node:sharedNodeList2){
			medicine.setClassification(node.toString());
			List<Medicine> medicineList = md.differenceConditionQueryMedicines(medicine);
			sum=sum+medicineList.size();
			listList.add(medicineList);
		}
		String[][] twoArray = new String[sum][oneArray.length];
		for(List<Medicine> medicineList : listList){
			for (Medicine m : medicineList) {
				twoArray[i][0] = String.valueOf(m.getId());
				twoArray[i][1] = m.getName();
				twoArray[i][2] = m.getClassification();
				twoArray[i][3] = m.getStandard();
				twoArray[i][4] = m.getEnterCompany();
				twoArray[i][5] = m.getEnterPrice();
				twoArray[i][6] = m.getShoppingPrice();
				twoArray[i][7] = m.getValidateNumber() + "";
				twoArray[i][8] = m.getSalePrice() + "";
				twoArray[i][9] = m.getSimpleName();
				twoArray[i][10] = m.getUpperLimit();
				twoArray[i][11] = m.getDownLimit();
				twoArray[i][12] = m.getApproveNumber() + "";
				twoArray[i][13] = m.getProduceCompany();
				twoArray[i][14] = m.getMainComponent();
				twoArray[i][15] = m.getMedicineEffect();
				twoArray[i][16] = m.getUseMethod();
				twoArray[i][17] = m.getMattersNeedAttention();
				i++;
			}
		}
			sharedArrays.setSharedOneArray(oneArray);
			sharedArrays.setSharedTwoArray(twoArray);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		sharedNodeList.clear();
		return sharedArrays;
	}

	//第一个节点是叶子节点查询
	public void isRecursionQuery(JTree jTree,DefaultMutableTreeNode node){
		if(node.isLeaf()){
			sharedNodeList.add(node);
		}else{
			recursionquery(jTree,node);
		}
	}
	
	// 递归查询
	public void recursionquery(JTree jTree, DefaultMutableTreeNode node) {
		if (!node.isLeaf()) {
			DefaultMutableTreeNode node1 = node.getNextNode();
			recursionquery(jTree, node1);
			node = node.getNextSibling();
			if (node != null) {
				recursionquery(jTree, node);
			}
		} else {
			sharedNodeList.add(node);
			node = node.getNextSibling();
			if (node != null) {
				recursionquery(jTree, node);
			}
		}
	}

	// tree的鼠标监听
	public void treeMouseListener(final JTree jTree) {
		jTree.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TreePath path=jTree.getPathForLocation(e.getX(), e.getY());
				if(path!=null){
					DefaultMutableTreeNode node=(DefaultMutableTreeNode)path.getLastPathComponent();
					isRecursionQuery(jTree,node);
				}
				DifferenceObject object7=object.getDifferenceObjectMap().get("object7");
				SharedModel sharedModel=object7.getSharedModel();
				
				try {
					sharedModel.setPatientArrays(queryMedicines(sharedNodeList));
					object7.getJtable().updateUI();
				} catch (QueryObjectException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	// 一级节点
	public DefaultMutableTreeNode oneNode() {
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("药品分类");

		twoNode(node1);
		return node1;
	}

	// 二级节点
	public List<DefaultMutableTreeNode> twoNode(DefaultMutableTreeNode node1) {
		List<DefaultMutableTreeNode> node2List = new ArrayList<DefaultMutableTreeNode>();
		DefaultMutableTreeNode node21 = new DefaultMutableTreeNode("自费类");
		DefaultMutableTreeNode node22 = new DefaultMutableTreeNode("报销类");

		node1.add(node21);
		node1.add(node22);

		node2List.add(node21);
		node2List.add(node22);
		threeNode(node2List);
		return node2List;
	}

	// 三级节点
	public List<DefaultMutableTreeNode> threeNode(
			List<DefaultMutableTreeNode> node2List) {
		List<DefaultMutableTreeNode> node3List = new ArrayList<DefaultMutableTreeNode>();
		DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("皮肤科常用药");
		DefaultMutableTreeNode node32 = new DefaultMutableTreeNode("皮肤科中药");
		DefaultMutableTreeNode node33 = new DefaultMutableTreeNode("西药成分外用药");
		DefaultMutableTreeNode node34 = new DefaultMutableTreeNode("中药成分外用药");
		DefaultMutableTreeNode node35 = new DefaultMutableTreeNode("内科用药");
		DefaultMutableTreeNode node36 = new DefaultMutableTreeNode("儿科用药");
		DefaultMutableTreeNode node37 = new DefaultMutableTreeNode("中成药");
		DefaultMutableTreeNode node38 = new DefaultMutableTreeNode("收费项目");
		DefaultMutableTreeNode node39 = new DefaultMutableTreeNode("消耗品项");

		DefaultMutableTreeNode node21 = node2List.get(0);

		node21.add(node31);
		node21.add(node32);
		node21.add(node33);
		node21.add(node34);
		node21.add(node35);
		node21.add(node36);
		node21.add(node37);
		node21.add(node38);
		node21.add(node39);

		node3List.add(node31);
		node3List.add(node32);
		node3List.add(node33);
		node3List.add(node34);
		node3List.add(node35);
		node3List.add(node36);
		node3List.add(node37);
		node3List.add(node38);
		node3List.add(node39);

		return node3List;
	}

}
