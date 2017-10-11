

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class Test2 extends JFrame implements MouseListener,ActionListener{
	JTree tree;
	JPopupMenu popMenu;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem editItem;
	public Test2() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
		
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("节点1");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("节点2");
		DefaultMutableTreeNode node11 = new DefaultMutableTreeNode("节点11");
		root.add(node1);
		root.add(node2);
		node1.add(node11);
		
		tree = new JTree(root);
		tree.setEditable(true);
		tree.addMouseListener(this);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		
		popMenu = new JPopupMenu();
		addItem = new JMenuItem("添加子节点");
		addItem.addActionListener(this);
		delItem = new JMenuItem("删除");
		editItem = new JMenuItem("修改");
		
		popMenu.add(addItem);
		popMenu.add(delItem);
		popMenu.add(editItem);
		
		tree.getCellEditor().addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent arg0) {
				System.out.println("编辑结束");
			}
			
			@Override
			public void editingCanceled(ChangeEvent arg0) {
				System.out.println("编辑取消");
			}
		});   
		
		tree.setCellRenderer(new MyRenderer());
		this.add(tree);
		
	}

	public static void main(String[] args) {
		Test2 frame = new Test2();
		frame.setBounds(200, 200, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent e) {
		TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用
		if (path == null) {
			return;
		}
		tree.setSelectionPath(path);
		
		if (e.getButton() == 3) {
			popMenu.show(tree, e.getX(), e.getY());
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
		parent.add(newNode);
		
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		TreeNode[] nodes = model.getPathToRoot(newNode);  
        TreePath path = new TreePath(nodes);  
        tree.scrollPathToVisible(path);  
        tree.updateUI();
        
        TreePath newNodePath = new TreePath(newNode.getPath());
		tree.getSelectionModel().addSelectionPath(newNodePath);
		
		tree.getCellEditor().addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent arg0) {
				System.out.println("编辑结束");
			}
			
			@Override
			public void editingCanceled(ChangeEvent arg0) {
				System.out.println("编辑取消");
			}
		});   
	}
}
