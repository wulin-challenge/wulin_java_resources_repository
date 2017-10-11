package cn.scxh.ittx.ui.shared;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.MedicineClassify;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.MedicineClassifyServiceImpl;
import cn.scxh.ittx.service.intf.MedicineClassifyService;

public class MedicineClassifyTree {
	private DefaultMutableTreeNode myNode;
	private DifferenceObject object;

	public MedicineClassifyTree(DifferenceObject object) {
		this.object = object;
	}

	// 创建一颗树与一个根节点
	public void createTreeAndNode() {
		JPanel jPanel10 = object.getJpanel();
		MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
		List<MedicineClassify> classifyList = null;
		try {
			classifyList = mcf.getMedicineRoot(null);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		myNode = new DefaultMutableTreeNode(classifyList
				.get(0).getName());
		try {
			recursionCreateMedicineClassifyTree(mcf, classifyList.get(0), myNode);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		JTree jTree = new JTree(myNode);
		jTree.setEditable(true);
		ListenerTheTree(jTree);
		jTree.setBounds(0, 140, 300, 600);
		jPanel10.add(jTree);

	}

	// 监听该树
	public void ListenerTheTree(final JTree jTree) {
		jTree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				userDefinedCreateNode(jTree, e);
				if (e.getButton() != 3) {
					TreePath path = jTree
							.getPathForLocation(e.getX(), e.getY());
					MedicineClassify classify = getSelectedNodeInformation(path);
					System.out.println("classify" + classify.getName());
				}
			}
		});
	}

	// 取得所选择的节点的所有信息
	public MedicineClassify getSelectedNodeInformation(TreePath path) {
		MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
		MedicineClassify classify = new MedicineClassify();
		if (path != null) {
			int i = path.getPathCount();
			for (int j = 0; j < i; j++) {
				try {
					if (j == 0) {
						classify = mcf.getMedicineRoot(classify).get(0);
					} else {
						classify.setName(path.getPathComponent(j).toString());
						classify = mcf.getChildrenBynameAndId(classify).get(0);
					}
				} catch (QueryObjectException e1) {
					e1.printStackTrace();
				}

			}
			// System.out.println(classify.getId() + "="
			// + classify.getName());

		}
		return classify;
	}

	// 自定义创建节点
	public void userDefinedCreateNode(JTree jTree, MouseEvent e) {
		TreePath path = jTree.getPathForLocation(e.getX(), e.getY());
		// int i = path.getPathCount();
		JPopupMenu menu = rightKeyMenu(jTree);
		boolean flag = jTree.isPathSelected(path); // 判断当前节点是否有被选中
		if (flag) {
			if (e.getButton() == 3) {
				System.out.println(flag);
				menu.show(jTree, e.getX(), e.getY());
				int i = menu.getComponentCount();

			}
		}

	}

	// 右键菜单
	public JPopupMenu rightKeyMenu(JTree jTree) {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem equalItem = new JMenuItem("创建同级目录");
		rightKeyMenuListener(jTree, equalItem);
		JMenuItem downItem = new JMenuItem("创建下一级目录");
		rightKeyMenuListener(jTree, downItem);
		JMenuItem editItem = new JMenuItem("编辑当前目录");
		rightKeyMenuListener(jTree, editItem);
		JMenuItem deleteItem = new JMenuItem("删除当前目录");
		rightKeyMenuListener(jTree, deleteItem);
		menu.add(equalItem);
		menu.add(downItem);
		menu.add(editItem);
		menu.add(deleteItem);
		return menu;
	}

	// 右键菜单监听
	public void rightKeyMenuListener(final JTree jTree, JMenuItem item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createEqualcontent(jTree, e);
				deleteCurrentcontent(jTree, e);
				createChildrenContent(jTree, e);
				editCurrentContent(jTree, e);
			}
		});
	}

	// 新建同级目录
	public void createEqualcontent(JTree jTree, ActionEvent e) {
		TreePath path = jTree.getSelectionPath();
		if (e.getActionCommand().equals("创建同级目录")) {
			TreePath parentPath = path.getParentPath();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) parentPath
					.getLastPathComponent();
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
			node.add(newNode);

			// 将该节点插入数据库
			insertDatabaseOfNewNode(jTree, parentPath, newNode,"创建同级目录");

			// 刷新新建节点后的树
			DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
			TreeNode[] nodes = model.getPathToRoot(newNode);
			TreePath treePath = new TreePath(nodes);
			jTree.scrollPathToVisible(treePath);
			jTree.updateUI();
		}
	}
	//创建子目录
	public void createChildrenContent(JTree jTree,ActionEvent e){
		TreePath path=jTree.getSelectionPath();
		if(e.getActionCommand().equals("创建下一级目录")){
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
			node.add(newNode);
			// 将该节点插入数据库
			insertDatabaseOfNewNode(jTree, path, newNode,"创建下一级目录");
			// 刷新新建节点后的树
			DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
			TreeNode[] nodes = model.getPathToRoot(newNode);
			TreePath treePath = new TreePath(nodes);
			jTree.scrollPathToVisible(treePath);
			jTree.updateUI();
		}
	}
	//编辑当前节点
	public void editCurrentContent(JTree jTree, ActionEvent e){
		TreePath path = jTree.getSelectionPath();
		if (e.getActionCommand().equals("编辑当前目录")) {
			if(path!=null){
				jTree.startEditingAtPath(path);
			System.out.println("00000");
			jTree.getCellEditor().addCellEditorListener(new CellEditorListener(){

				public void editingCanceled(ChangeEvent e) {
					JOptionPane.showMessageDialog(null,"编辑失败! 编辑完成后请按  enter键确认");
				}

				public void editingStopped(ChangeEvent e) {
					
				}
				
			});
			}
		}
	}
	
	//删除当前目录
	public void deleteCurrentcontent(JTree jTree, ActionEvent e){
		TreePath path = jTree.getSelectionPath();
		if (e.getActionCommand().equals("删除当前目录")) {
			MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
			MedicineClassify classify=getSelectedNodeInformation(path);
			try {
				mcf.deleteMedicineClassify(classify);
			} catch (DeleteObjectException e1) {
				e1.printStackTrace();
			}
			DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode) path.getLastPathComponent();
			DefaultTreeModel model=(DefaultTreeModel) jTree.getModel();
			if(selectedNode!=null&&selectedNode.getParent()!=null){
				model.removeNodeFromParent(selectedNode);
			}
		}
	}

	// 向数据库插入新建节点的值
	public void insertDatabaseOfNewNode(JTree jTree, TreePath parentPath,
			DefaultMutableTreeNode newNode,String judge) {
		MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
		List<MedicineClassify> classifyList = null;
		int id = 0;
		try {
			classifyList = mcf.theLargestNumberOfMedicineClassify(null);
			id = classifyList.get(0).getId();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		MedicineClassify classify = getSelectedNodeInformation(parentPath);
		if(judge.equals("创建同级目录")){
			classify.setId(id + 1);
		}else if(judge.equals("创建下一级目录")){
			classify.setPid(classify.getId());
			classify.setId(id+1);
		}
		classify.setName(newNode.toString());
		try {
			mcf.addMedicineClassify(classify);
		} catch (AddObjectException e) {
			e.printStackTrace();
		}
	}

	// 递归创建树
	public void recursionCreateMedicineClassifyTree(
			MedicineClassifyService mcf, MedicineClassify classify,
			DefaultMutableTreeNode node) throws QueryObjectException {
		List<MedicineClassify> classifyList = mcf.getChildren(classify);
		if (!classifyList.isEmpty()) {
			for (MedicineClassify mc : classifyList) {
				DefaultMutableTreeNode childrenNode = new DefaultMutableTreeNode(
						mc.getName());
				node.add(childrenNode);
				recursionCreateMedicineClassifyTree(mcf, mc, childrenNode);
			}
		}
	}
}
