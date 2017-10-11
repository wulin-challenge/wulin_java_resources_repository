import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
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
		tree = new JTree(root);
		tree.setEditable(true);
		tree.addMouseListener(this);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		popMenu = new JPopupMenu();
		addItem = new JMenuItem("添加");
		addItem.addActionListener(this);
		delItem = new JMenuItem("删除");
		editItem = new JMenuItem("修改");
		
		popMenu.add(addItem);
		popMenu.add(delItem);
		popMenu.add(editItem);
//		
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("节点1");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("节点2");
		DefaultMutableTreeNode node11 = new DefaultMutableTreeNode("节点11");
		root.add(node1);
		root.add(node2);
		node1.add(node11);
		this.add(tree);

	}

	public static void main(String[] args) {
		Test2 frame = new Test2();
		frame.setBounds(200, 200, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
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

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame f = new Frame();
		f.setBounds(20, 20,100, 100);
		f.setVisible(true);
	}
}
