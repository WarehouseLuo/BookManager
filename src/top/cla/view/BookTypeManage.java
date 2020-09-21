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
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 18));
		
		text_form_id = new JTextField();
		text_form_id.setEditable(false);
		text_form_id.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u540D\u79F0\uFF1A");
		lblNewLabel_2_1.setFont(new Font("����", Font.PLAIN, 18));
		
		text_form_name = new JTextField();
		text_form_name.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		lblNewLabel_2_2.setFont(new Font("����", Font.PLAIN, 18));
		
		text_form_desc = new JTextField();
		text_form_desc.setColumns(10);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exchangeBookTypeActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/modify.png")));
		button_1.setFont(new Font("����", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/delete.png")));
		button_2.setFont(new Font("����", Font.PLAIN, 14));
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
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		
		text_select_name = new JTextField();
		text_select_name.setFont(new Font("����", Font.PLAIN, 16));
		text_select_name.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBookTypeNameActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeManage.class.getResource("/images/search.png")));
		button.setFont(new Font("����", Font.PLAIN, 14));
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
	 * ָ��ͼ���������ֽ��в�ѯ
	 */
	protected void selectBookTypeNameActionPerformed(ActionEvent e) {
		String selectName = text_select_name.getText();//��ȡ�û�����Ĳ�ѯ�ַ���
		BookType bt = new BookType();
		bt.setBookTypeName(selectName);
		this.showBookTypeTable(bt);
	}
	
	/**
	 * ɾ��һ��ͼ�������Ϣ
	 * @param e
	 */
	protected void deleteActionPerformed(ActionEvent e) {
		int id = Integer.parseInt(text_form_id.getText());//��ȡѡ�е�idֵ
		Connection con = null;
		
		try {
			con = dbUtil.getCon();//�������ݿ�
			boolean result = btd.deleteBookType(con, id);//����ɾ��ͼ����𷽷�ɾ��ѡ�е�ͼ��
			//�ж��Ƿ�ɾ���ɹ�
			if(result) {
				//ɾ���ɹ�
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				
				//���������
				text_form_id.setText("");
				text_form_name.setText("");
				text_form_desc.setText("");
				
				this.showBookTypeTable(new BookType());//�ٱ���һ������ͼ�����ͱ�
			}else {
				//ɾ��ʧ��
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
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
	 * �޸�һ��ͼ�������Ϣ
	 */
	protected void exchangeBookTypeActionPerformed(ActionEvent e) {
		int id = Integer.parseInt(text_form_id.getText());
		String name = text_form_name.getText();
		String desc = text_form_desc.getText();
		
		BookType bt = new BookType(name,desc);
		bt.setId(id);
		Connection con = null;
		
		try {
			con = dbUtil.getCon();//�������ݿ�
			boolean result = btd.updateBookType(con, id, bt);//�޸����ݿ�
			if(result) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
				showBookTypeTable(new BookType());//��ִ��һ���ѯ���ݿⲢ�ڱ���б�������
			}else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * ������ĳһ�н�����������ʾ�����Ϲ��û��޸�
	 * @param e
	 */
	protected void showBookTypeMessageMousePressed(MouseEvent e) {
		int row = table_booktype.getSelectedRow();
		//���ض����к����ҵ����ǵ�ֵ���ڱ�����ʾ����
		text_form_id.setText(table_booktype.getValueAt(row, 0).toString());
		text_form_name.setText(table_booktype.getValueAt(row, 1).toString());
		text_form_desc.setText(table_booktype.getValueAt(row, 2).toString());
	}

	/*
	 * ��ѯ���ݿⲢ����ѯ���Ľ����ʾ�ڱ������У��������Ķ������ͼ���������Ϊ�գ����������ͼ�����������Ϊ������ͼ��������ģ����ѯ
	 */
	@SuppressWarnings("unchecked")
	public void showBookTypeTable(BookType bt) {
		DefaultTableModel tbModel = (DefaultTableModel)table_booktype.getModel();//�ڱ������л�ȡһ��ģ�����
		tbModel.setRowCount(0);//��������ó�0��,������������ű�����֮ǰ����ʾ���Ӱ���µ���ʾ
		Connection con = null;
		try {
			con = dbUtil.getCon();//�������ݿ�
			//��ѯ���ݿ⣬������ѯ���Ľ��������ʾ�ڱ��֮��
			ResultSet result = btd.selectBookType(con, bt);
			while(result.next()) {
			Vector v = new Vector();//����һ�����������
			 v.add(result.getInt("id"));
			 v.add(result.getString("bookTypeName"));
			 v.add(result.getString("bookTypeDesc"));
			 tbModel.addRow(v);//��һ����ӵ�����
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
