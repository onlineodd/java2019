package java2019.com.java.project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java2019.com.java.project.controller.MovieCollectionControllerTwo;
import java2019.com.java.project.entity.MovieCollection;
import java2019.com.java.project.service.MovieCollectionService;
import java2019.com.java.project.service.impl.MovieCollectionServiceImpl;

@SuppressWarnings("serial")
public class MovieCollectionMainFrame extends JFrame {

	private static final String EXIT_ON_CLOSE = null;
	private JTable table;
	// 数据
	private Object[][] dataobObjects;
	private List<MovieCollection> list;
	private JTextField txtTitle;
	private JTextField txtDuration;
	private JTextField txtAuthor;
	private JTextField txtLink;
	private JTextField txtSummary;
	private JTextField txtType;
	private JTextField txtMid;

	private MovieCollectionService movieCollectionService;
	private int rowNum = -1;
	public MovieCollectionMainFrame() {
		setTitle("表格");
		setSize(1310, 1073);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		// 设置表格的标题栏
	
//		jtFilePath.getTableHeader().setFont(new Font("Dialog", 0, 12));
		String[] columuNameStrings = { "编号", "影名", "时长", "导演", "来源", "内容", "类型" };
		// 模拟一下数据
		movieCollectionService = new MovieCollectionServiceImpl();
		List<MovieCollection> list = movieCollectionService.findAll();
		dataobObjects = new Object[list.size()][columuNameStrings.length];
		for (int i = 0; i < list.size(); i++) {
			MovieCollection movieCollection = list.get(i);
			dataobObjects[i][0] = movieCollection.getmId();
			dataobObjects[i][1] = movieCollection.getmTitle();
			dataobObjects[i][2] = movieCollection.getmDuration();
			dataobObjects[i][3] = movieCollection.getmAuthor();
			dataobObjects[i][4] = movieCollection.getmLink();
			dataobObjects[i][5] = movieCollection.getmSummary();
			dataobObjects[i][6] = movieCollection.getmType();
		

		}
		DefaultTableModel defaultTableModel = TV(columuNameStrings); 
		table = new JTable(defaultTableModel);
		table.setRowHeight(50);
		table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 30));
		// 给表格添加监听，相应点击
		table.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// System.out.println("鼠标单击了");
				// 检测鼠标

				if (e.getClickCount() == 2) {
					System.out.println("鼠标双击了");
					// 获得双击了那行的数据
					rowNum = table.rowAtPoint(e.getPoint());
					System.out.println("双击了，下标" + rowNum + "数据");
					// 通过下标拿数据
					System.out.println("标题：" + dataobObjects[rowNum][1]);
					System.out.println(list.get(rowNum));
					MovieCollection movieCollection = list.get(rowNum);
					txtMid.setText(String.valueOf(movieCollection.getmId()));
					txtTitle.setText(movieCollection.getmTitle());
					txtDuration.setText(movieCollection.getmDuration());
					txtAuthor.setText(movieCollection.getmAuthor());
					txtLink.setText(movieCollection.getmLink());
					txtSummary.setText(movieCollection.getmSummary());
					txtType.setText(movieCollection.getmType());
					

				}
			}
		});
		// 表格数据比较多，所以需要一个可以滚动的面板
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setPreferredSize(new Dimension(0,300));
		add(jScrollPane,BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,270));
//		panel.setBackground(Color.YELLOW);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		JLabel lbltitle = new JLabel("影名：");
		lbltitle.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lbltitle.setBounds(150, 45, 100, 50);
		panel.add(lbltitle);
		txtTitle = new JTextField();
		txtTitle.setBounds(260, 45, 200, 50);
		txtTitle.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel.add(txtTitle);
		panel.setLayout(null);
		JLabel lblsname = new JLabel("时长：");
		lblsname.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblsname.setBounds(500, 45, 100, 50);
		panel.add(lblsname);
		txtDuration = new JTextField();
		txtDuration.setBounds(610,45, 200, 50);
		txtDuration.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel.add(txtDuration);
		JLabel lblSbirthday = new JLabel("导演：");
		lblSbirthday.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblSbirthday.setBounds(850, 45, 100,50);
		panel.add(lblSbirthday);
		txtAuthor = new JTextField();
		txtAuthor.setBounds(960, 45, 200, 50);
		txtAuthor.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel.add(txtAuthor);
		JLabel lblsphone = new JLabel("来源：");
		lblsphone.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblsphone.setBounds(150, 115, 100, 50);
		panel.add(lblsphone);
		txtLink = new JTextField();
		txtLink.setBounds(260, 115, 200, 50);
		txtLink.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel.add(txtLink);
		JLabel lblsaddres = new JLabel("内容：");
		lblsaddres.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblsaddres.setBounds(500, 115, 100, 50);
		panel.add(lblsaddres);
		txtSummary = new JTextField();
		txtSummary.setBounds(610, 115, 200, 50);
		txtSummary.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel.add(txtSummary);
		JLabel lblStype = new JLabel("类型：");
		lblStype.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblStype.setBounds(850, 115, 100, 50);
		panel.add(lblStype);
		txtType = new JTextField();
		txtType.setBounds(960, 115, 200, 50);
		txtType.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel.add(txtType);
		txtMid = new JTextField();
		panel.add(txtMid);
		JButton butadd = new JButton("保    存");
		butadd.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		butadd.setBounds(100, 200, 200, 50);
		panel.add(butadd);
		butadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 保存电影信息
				// 拿到输入的电影信息
				String Title = txtTitle.getText();
				String Duration = txtDuration.getText();
				String Author = txtAuthor.getText();
				String Link = txtLink.getText();
				String Summary = txtSummary.getText();
				String Type = txtType.getText();
				// 需要校验
				if ((!"".equals(Title)) && (!"".equals(Duration)) && (!"".equals(Author)) && (!"".equals(Link))
						&& (!"".equals(Summary)) && (!"".equals(Type))) {
					MovieCollection movieCollection = new MovieCollection();
					movieCollection.setmTitle(Title);
					movieCollection.setmDuration(Duration);
					movieCollection.setmAuthor(Author);
					movieCollection.setmLink(Link);
					movieCollection.setmSummary(Summary);
					movieCollection.setmType(Type);
					
					// 实例一个StudentSerivice,完成插入操作
					MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
					boolean isok = movieCollectionService.save(movieCollection);
					if (isok) {
						// 成功
						// 刷新表格，把新的数据显示出来
						DefaultTableModel defaultTableModel = TV(columuNameStrings);
						// 重新设置table中的新模型
						table.setModel(defaultTableModel);
						// 更新UI
						table.updateUI();
						txtTitle.setText("");
						txtDuration.setText("");
						txtAuthor.setText("");
						txtLink.setText("");
						txtSummary.setText("");
						txtType.setText("");
					} else {
						// 失败
						JOptionPane.showMessageDialog(null, "插入失败");
						
					}

				}
			}

		});
		JButton butUpdate = new JButton("修    改");
		butUpdate.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		butUpdate.setBounds(400, 200, 200, 50);
		panel.add(butUpdate);
		butUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rowNum > -1) {
					System.out.println("选择了记录");
					MovieCollection movieCollection = list.get(rowNum);
					String Title = txtTitle.getText();
					String Duration = txtDuration.getText();
					String Author = txtAuthor.getText();
					String Link = txtLink.getText();
					String Summary = txtSummary.getText();
					String Type = txtType.getText();

					// 需要校验
					if ((!"".equals(Title)) && (!"".equals(Duration)) && (!"".equals(Author)) && (!"".equals(Link))
							&& (!"".equals(Summary)) && (!"".equals(Type))) {
						movieCollection.setmTitle(Title);
						movieCollection.setmDuration(Duration);
						movieCollection.setmAuthor(Author);
						movieCollection.setmLink(Link);
						movieCollection.setmSummary(Summary);
						movieCollection.setmType(Type);

						MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
						boolean isok = movieCollectionService.update(movieCollection);
						if (isok) {
							DefaultTableModel defaultTableModel = TV(columuNameStrings);
							table.setModel(defaultTableModel);
							// 更新UI
							table.updateUI();
							txtTitle.setText("");
							txtDuration.setText("");
							txtAuthor.setText("");
							txtLink.setText("");
							txtSummary.setText("");
							txtType.setText("");
							rowNum = -1;
						} else {
							JOptionPane.showMessageDialog(null, "修改失败！");
						}
					}
				} else {
					System.out.println("未选择记录");
				}

			}
		});
		JButton butdelete = new JButton("删    除");
		butdelete.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		butdelete.setBounds(700, 200, 200, 50);
		panel.add(butdelete);
		butdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rowNum > -1) {
					System.out.println("选择了记录");
					@SuppressWarnings("unused")
					MovieCollection movieCollection = list.get(rowNum);
					String id = txtMid.getText();

					MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
					boolean isok = movieCollectionService.delete(Integer.parseInt(id));
					if (isok) {
						DefaultTableModel defaultTableModel = TV(columuNameStrings);
						table.setModel(defaultTableModel);
						// 更新UI
						table.updateUI();
						txtTitle.setText("");
						txtDuration.setText("");
						txtAuthor.setText("");
						txtLink.setText("");
						txtSummary.setText("");
						txtType.setText("");
						rowNum = -1;
					} else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				} else {
					System.out.println("未选择记录");
				}
			}

		});
		JButton but = new JButton("返    回");
		but.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		but.setBounds(1000, 200, 200, 50);
		panel.add(but);
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MovieCollectionControllerTwo();
				setVisible(false);
			}
		});
		// jScrollPane.setSize(500,400);
		add(jScrollPane);
		setVisible(true);
	}

	private DefaultTableModel TV(String[] columuNameStrings) {
		movieCollectionService = new MovieCollectionServiceImpl();
		List<MovieCollection> list = movieCollectionService.findAll();
		dataobObjects = new Object[list.size()][columuNameStrings.length];
		for (int i = 0; i < list.size(); i++) {
			MovieCollection movieCollection = list.get(i);
			dataobObjects[i][0] = movieCollection.getmId();
			dataobObjects[i][1] = movieCollection.getmTitle();
			dataobObjects[i][2] = movieCollection.getmDuration();
			dataobObjects[i][3] = movieCollection.getmAuthor();
			dataobObjects[i][4] = movieCollection.getmLink();
			dataobObjects[i][5] = movieCollection.getmSummary();
			dataobObjects[i][6] = movieCollection.getmType();
		
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataobObjects, columuNameStrings) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		return defaultTableModel;
	}

	@SuppressWarnings("unused")
	private void add(JScrollPane jScrollPane, JLabel label, String north) {
		// TODO Auto-generated method stub
		
	}

	private void setDefaultCloseOperation(String exitOnClose) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	private DefaultTableModel refreshTableData(String[] columuNameStrings,
			MovieCollectionService movieCollectionService) {
		list = movieCollectionService.findAll();
		// 把list数据转存到dataobObjects中
		dataobObjects = new Object[list.size()][columuNameStrings.length];
		for (int i = 0; i < list.size(); i++) {
			MovieCollection movieCollection = list.get(i);
			dataobObjects[i][0] = movieCollection.getmId();
			dataobObjects[i][1] = movieCollection.getmTitle();
			dataobObjects[i][2] = movieCollection.getmDuration();
			dataobObjects[i][3] = movieCollection.getmAuthor();
			dataobObjects[i][4] = movieCollection.getmLink();
			dataobObjects[i][5] = movieCollection.getmSummary();
			dataobObjects[i][6] = movieCollection.getmType();

		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataobObjects, columuNameStrings);
		return defaultTableModel;
	}
}
