package top.cla.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import top.cla.dao.BookTypeDao;
import top.cla.model.BookType;
import top.cla.util.DbUtil;
import top.cla.util.StringUtil;

@SuppressWarnings("serial")
public class BookTypeAddView extends JInternalFrame {
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao btd = new BookTypeDao();
	
	private JTextField text_type_name;
	private JTextArea text_type_describe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddView frame = new BookTypeAddView();
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
	public BookTypeAddView() {
		setClosable(true);
		setFrameIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/add.png")));
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 1000, 600);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/bookTypeAdd.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 22));
		
		text_type_name = new JTextField();
		text_type_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_type_name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/reset.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_type_describe = new JTextArea();
		text_type_describe.setFont(new Font("Monospaced", Font.PLAIN, 18));
		text_type_describe.setLineWrap(true);
		
		JButton btnNewButton_1_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookTypeActionPerformed(e);
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/add.png")));
		btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(122)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_type_describe, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_type_name, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)))
					.addGap(217))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(271)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(205)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(276, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(text_type_name)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(text_type_describe, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(48))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(84)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(78))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 重置所有表单信息
	 * @param e
	 */
	protected void resetActionPerformed(ActionEvent e) {
		text_type_name.setText("");
		text_type_describe.setText("");
	}

	/**
	 * 添加图书类型进入数据库
	 * @param e
	 */
	protected void addBookTypeActionPerformed(ActionEvent e) {
		Connection con = null;
		
		//将用用户输入的值赋值给变量
		String typeName = text_type_name.getText();
		String typeDesc = text_type_describe.getText();
		
		//创建图书类型对象
		BookType bt = new BookType(typeName,typeDesc);
		
		if(StringUtil.strIsEmpty(typeName)) {
			JOptionPane.showMessageDialog(null, "图书类别不能为空！");
			return;
		}
		
		
		try {
			con = dbUtil.getCon();//连接数据库
			int suc = btd.addBookType(con, bt);//添加图书类型进入数据库
			
			//判断是否添加成功
			if(suc == 1) {
				JOptionPane.showMessageDialog(null, "添加图书类型成功！");
				text_type_name.setText("");
				text_type_describe.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "添加图书类型失败！");
				text_type_name.setText("");
				text_type_describe.setText("");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//断开数据库连接
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
