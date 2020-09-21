package top.cla.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import top.cla.dao.BookTypeDao;
import top.cla.model.BookType;
import top.cla.util.DbUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BookTypeManage extends JInternalFrame {
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao btd = new BookTypeDao();
	private BookType totalBt = new BookType();
	
	private JTextField text_select_name;
	private JTable table_booktype;
	private JTextField text_form_id;
	private JTextField text_form_name;
	private JTextField text_form_desc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManage frame = new BookTypeManage();
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
	public BookTypeManage() {
		setFrameIcon(new ImageIcon(BookTypeManage.class.getResource("/images/bookTypeManager.png")));
		setClosable(true);
		setBounds(100, 100, 1000, 600);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/bookTypeMsg.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 992, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_form_id = new JTextField();
		text_form_id.setEditable(false);
		text_form_id.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u540D\u79F0\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_form_name = new JTextField();
		text_form_name.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_form_desc = new JTextField();
		text_form_desc.setColumns(10);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exchangeBookTypeActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/modify.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/delete.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_2)
									.addGap(18)
									.addComponent(text_form_desc))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(text_form_id, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(101)
									.addComponent(lblNewLabel_2_1)
									.addGap(18)
									.addComponent(text_form_name, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(310)
							.addComponent(button_1)
							.addGap(146)
							.addComponent(button_2)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(text_form_name, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_form_id, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_form_desc, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		panel_1.setLayout(gl_panel_1);
		
		table_booktype = new JTable();
		table_booktype.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showBookTypeMessageMousePressed(e);
			}
		});
		table_booktype.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_booktype.getColumnModel().getColumn(1).setPreferredWidth(208);
		table_booktype.getColumnModel().getColumn(2).setPreferredWidth(210);
		scrollPane.setViewportView(table_booktype);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_select_name = new JTextField();
		text_select_name.setFont(new Font("宋体", Font.PLAIN, 16));
		text_select_name.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBookTypeNameActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/search.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(101)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(text_select_name, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(35))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_select_name, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.showBookTypeTable(totalBt);
	}
	
	/*
	 * 指定图书类型名字进行查询
	 */
	protected void selectBookTypeNameActionPerformed(ActionEvent e) {
		String selectName = text_select_name.getText();//获取用户输入的查询字符串
		BookType bt = new BookType();
		bt.setBookTypeName(selectName);
		this.showBookTypeTable(bt);
	}
	
	/**
	 * 删除一条图书类别信息
	 * @param e
	 */
	protected void deleteActionPerformed(ActionEvent e) {
		int id = Integer.parseInt(text_form_id.getText());//获取选中的id值
		Connection con = null;
		
		try {
			con = dbUtil.getCon();//连接数据库
			boolean result = btd.deleteBookType(con, id);//调用删除图书类别方法删除选中的图书
			//判断是否删除成功
			if(result) {
				//删除成功
				JOptionPane.showMessageDialog(null, "删除成功！");
				
				//清空整个表单
				text_form_id.setText("");
				text_form_name.setText("");
				text_form_desc.setText("");
				
				this.showBookTypeTable(new BookType());//再遍历一遍整张图书类型表
			}else {
				//删除失败
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/*
	 * 修改一条图书类别信息
	 */
	protected void exchangeBookTypeActionPerformed(ActionEvent e) {
		int id = Integer.parseInt(text_form_id.getText());
		String name = text_form_name.getText();
		String desc = text_form_desc.getText();
		
		BookType bt = new BookType(name,desc);
		bt.setId(id);
		Connection con = null;
		
		try {
			con = dbUtil.getCon();//连接数据库
			boolean result = btd.updateBookType(con, id, bt);//修改数据库
			if(result) {
				JOptionPane.showMessageDialog(null, "修改成功!");
				showBookTypeTable(new BookType());//再执行一遍查询数据库并在表格中遍历出来
			}else {
				JOptionPane.showMessageDialog(null, "修改失败!");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 点击表格某一行将此行内容显示到表单上供用户修改
	 * @param e
	 */
	protected void showBookTypeMessageMousePressed(MouseEvent e) {
		int row = table_booktype.getSelectedRow();
		//在特定的行和列找到他们的值并在表单中显示出来
		text_form_id.setText(table_booktype.getValueAt(row, 0).toString());
		text_form_name.setText(table_booktype.getValueAt(row, 1).toString());
		text_form_desc.setText(table_booktype.getValueAt(row, 2).toString());
	}

	/*
	 * 查询数据库并将查询到的结果显示在表格组件中，如果传入的对象里的图书类别名称为空，则遍历整个图书类别表；如果不为空则按照图书类别进行模糊查询
	 */
	@SuppressWarnings("unchecked")
	public void showBookTypeTable(BookType bt) {
		DefaultTableModel tbModel = (DefaultTableModel)table_booktype.getModel();//在表格对象中获取一个模板对象
		tbModel.setRowCount(0);//将表格设置成0行,作用是清空整张表，避免之前的显示结果影响新的显示
		Connection con = null;
		try {
			con = dbUtil.getCon();//连接数据库
			//查询数据库，并将查询到的结果遍历显示在表格之中
			ResultSet result = btd.selectBookType(con, bt);
			while(result.next()) {
			Vector v = new Vector();//创建一个表格行容器
			 v.add(result.getInt("id"));
			 v.add(result.getString("bookTypeName"));
			 v.add(result.getString("bookTypeDesc"));
			 tbModel.addRow(v);//将一行添加到表中
		    }
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
