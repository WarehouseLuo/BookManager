package top.cla.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import top.cla.dao.UserDao;
import top.cla.model.User;
import top.cla.util.DbUtil;
import top.cla.util.StringUtil;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField text_user_name;
	private DbUtil dataBase = new DbUtil();
	private UserDao userdao = new UserDao();
	private JPasswordField text_passward;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/images/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/logo.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("华文细黑", Font.BOLD, 38));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/userName.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(LoginView.class.getResource("/images/password.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_user_name = new JTextField();
		text_user_name.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLoginActionPerformed(e);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/images/login.png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/addUser.png")));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("\u6700\u7EC8\u89E3\u91CA\u6743\u5F52\u7F57\u7AE3\u6E90\u6240\u6709");
		
		text_passward = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(133)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_passward, 297, 297, 297)
								.addComponent(text_user_name, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(419, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(text_user_name, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_passward, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置弹窗居中显示
		this.setLocationRelativeTo(null);
	}
	

	public void userLoginActionPerformed(ActionEvent evt) {
		
		//从输入框获取用户输入信息
		String loginName = this.text_user_name.getText();
		String loginPassward = new String(this.text_passward.getPassword());
		
		if(StringUtil.strIsEmpty(loginName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");//弹窗显示
			return;
		}
		
		if(StringUtil.strIsEmpty(loginPassward)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");//弹窗显示
			return;
		}
		
		User u = new User(loginName,loginPassward);//实例化一个用户对象
		Connection con = null;
		
		
		//连接数据库
		try {
			con = dataBase.getCon();//与数据库建立连接
			User resultUser = userdao.login(con, u);//登录操作
			
			//判断是否登录成功
			if(resultUser != null) {
				dispose();//关闭当前登录窗口
				new MainView().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "您输入的账号或密码有误，请重新输入");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dataBase.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
