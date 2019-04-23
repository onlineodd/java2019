package java2019.com.java.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java2019.com.java.project.controller.MovieCollectionControllerTwo;
import java2019.com.java.project.entity.MovieCollection;
import java2019.com.java.project.service.MovieCollectionService;
import java2019.com.java.project.service.impl.MovieCollectionServiceImpl;

@SuppressWarnings("serial")
public class MovieFindV extends JFrame {
	private MovieCollectionService movieCollectionService;

	private Object[][] dataobObjects;
	private List<MovieCollection> list;
	private JTable table;
	private JScrollPane jScrollPane;
	private JTextField txtTitle;
	private JTextField txtDuration;
	private JTextField txtAuthor;
	private JTextField txtLink;
	private JTextField txtSummary;
	private JTextField txtType;
	private JTextField txtMid;
	private int rowNum = -1;

	public MovieFindV() {
		setTitle("查询");
		setSize(1310,1073);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		String[] columuNameStrings = { "编号", "影名", "时长", "导演", "来源", "内容", "类型" };

		// 模拟一下数据
	
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataobObjects, columuNameStrings) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable(defaultTableModel);
		table.setRowHeight(100);
		table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN,30));
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
				if (e.getClickCount() == 2) {
					rowNum = table.rowAtPoint(e.getPoint());
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

		jScrollPane = new JScrollPane(table);
		jScrollPane.setPreferredSize(new Dimension(0, 300));
		add(jScrollPane, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 270));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		JLabel jLabel = new JLabel("title:");
		jLabel.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		jLabel.setBounds(20, 30, 120, 60);
		panel.add(jLabel);
		txtTitle = new JTextField();
		txtTitle.setBounds(160, 30, 240, 60);
		txtTitle.setFont(new  Font("微软雅黑", Font.PLAIN, 48));
		panel.add(txtTitle);
		JButton butselect = new JButton("查    询");
		butselect.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		butselect.setBounds(160, 200, 250, 60);
		panel.add(butselect);
		butselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String title = txtTitle.getText();
				if (!"".equals(title)) {
					MovieCollection movieCollection = new MovieCollection();
					movieCollection.setmId(0);
					movieCollection.setmTitle(title);
					movieCollectionService = new MovieCollectionServiceImpl();
					List<MovieCollection> list = movieCollectionService.findTitle(title);
					dataobObjects = new Object[list.size()][columuNameStrings.length];

					for (int i = 0; i < list.size(); i++) {
						movieCollection = list.get(i);
						dataobObjects[i][0] = movieCollection.getmId();
						dataobObjects[i][1] = movieCollection.getmTitle();
						dataobObjects[i][2] = movieCollection.getmDuration();
						dataobObjects[i][3] = movieCollection.getmAuthor();
						dataobObjects[i][4] = movieCollection.getmLink();
						dataobObjects[i][5] = movieCollection.getmSummary();
						dataobObjects[i][6] = movieCollection.getmType();
						
					}
					
					DefaultTableModel defaultTableModel1 = new DefaultTableModel(dataobObjects, columuNameStrings) {
						@Override
						public boolean isCellEditable(int row, int column) {
							// TODO Auto-generated method stub
							return false;
						}
					};
					table.setModel(defaultTableModel1);
					table.updateUI();

				} else {
					MovieCollection movieCollection = new MovieCollection();
					movieCollection.setmId(0);
					movieCollection.setmTitle(title);
					movieCollectionService = new MovieCollectionServiceImpl();
					List<MovieCollection> list = movieCollectionService.findAll();
					dataobObjects = new Object[list.size()][columuNameStrings.length];

					for (int i = 0; i < list.size(); i++) {
						movieCollection = list.get(i);
						dataobObjects[i][0] = movieCollection.getmId();
						dataobObjects[i][1] = movieCollection.getmTitle();
						dataobObjects[i][2] = movieCollection.getmDuration();
						dataobObjects[i][3] = movieCollection.getmAuthor();
						dataobObjects[i][4] = movieCollection.getmLink();
						dataobObjects[i][5] = movieCollection.getmSummary();
						dataobObjects[i][6] = movieCollection.getmType();
				
					}
				
					DefaultTableModel defaultTableModel1 = new DefaultTableModel(dataobObjects, columuNameStrings) {
						@Override
						public boolean isCellEditable(int row, int column) {
							// TODO Auto-generated method stub
							return false;
						}
					};
					table.setModel(defaultTableModel1);
					table.updateUI();
				}
			}
		});
		JButton button = new JButton("返      回");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		button.setBounds(900, 200, 240, 60);
		panel.add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MovieCollectionControllerTwo();
				setVisible(false);
			}
		});
		add(jScrollPane);
		setVisible(true);
	}
}
