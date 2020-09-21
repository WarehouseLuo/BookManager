package top.cla.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class MainView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setResizable(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 850);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u83DC\u5355");
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/images/base.png")));
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_1 = new JMenuItem("   \u4FEE\u6539\u5BC6\u7801   ");
		mnNewMenu.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("   \u9000\u51FA\u7CFB\u7EDF   ");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainView.class.getResource("/images/bookManager.png")));
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("   \u56FE\u4E66\u6DFB\u52A0   ");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("   \u56FE\u4E66\u7EF4\u62A4   ");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1_1 = new JMenu("\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_1_1.setIcon(new ImageIcon(MainView.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu_1_1.setForeground(Color.BLACK);
		mnNewMenu_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("   \u7C7B\u522B\u6DFB\u52A0   ");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBookTypeView();//显示添加图书类型窗口
			}
		});
		mnNewMenu_1_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("   \u7C7B\u522B\u7EF4\u62A4   ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageActionPerformed();
			}
		});
		mnNewMenu_1_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1_2 = new JMenu("\u5173\u4E8E");
		mnNewMenu_1_2.setIcon(new ImageIcon(MainView.class.getResource("/images/about.png")));
		mnNewMenu_1_2.setForeground(Color.BLACK);
		mnNewMenu_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("   \u5E2E\u52A9  ");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpActionPerformed(e);//显示帮助窗口
			}
		});
		mnNewMenu_1_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	    desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 显示帮助窗口
	 * @param e
	 */
	protected void helpActionPerformed(ActionEvent e) {
		helpView hv = new helpView();
		hv.setVisible(true);
		desktopPane.add(hv);
	}

	/**
	 * 显示图书类型管理窗口
	 */
	protected void BookTypeManageActionPerformed() {
		BookTypeManage btm = new BookTypeManage();
		btm.setVisible(true);
		desktopPane.add(btm);
	}

	/**
	 * 显示添加图书类型窗口
	 */
	protected void showBookTypeView() {
		BookTypeAddView btav = new BookTypeAddView();
		btav.setVisible(true);
		desktopPane.add(btav);
	}
}
