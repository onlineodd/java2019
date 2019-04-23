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
	// ����
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
		setTitle("���");
		setSize(1310, 1073);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		// ���ñ��ı�����
	
//		jtFilePath.getTableHeader().setFont(new Font("Dialog", 0, 12));
		String[] columuNameStrings = { "���", "Ӱ��", "ʱ��", "����", "��Դ", "����", "����" };
		// ģ��һ������
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
		table.getTableHeader().setFont(new Font("΢���ź�", Font.PLAIN, 30));
		// �������Ӽ�������Ӧ���
		table.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		
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
				// System.out.println("��굥����");
				// ������

				if (e.getClickCount() == 2) {
					System.out.println("���˫����");
					// ���˫�������е�����
					rowNum = table.rowAtPoint(e.getPoint());
					System.out.println("˫���ˣ��±�" + rowNum + "����");
					// ͨ���±�������
					System.out.println("���⣺" + dataobObjects[rowNum][1]);
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
		// ������ݱȽ϶࣬������Ҫһ�����Թ��������
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setPreferredSize(new Dimension(0,300));
		add(jScrollPane,BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,270));
//		panel.setBackground(Color.YELLOW);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		JLabel lbltitle = new JLabel("Ӱ����");
		lbltitle.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lbltitle.setBounds(150, 45, 100, 50);
		panel.add(lbltitle);
		txtTitle = new JTextField();
		txtTitle.setBounds(260, 45, 200, 50);
		txtTitle.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		panel.add(txtTitle);
		panel.setLayout(null);
		JLabel lblsname = new JLabel("ʱ����");
		lblsname.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lblsname.setBounds(500, 45, 100, 50);
		panel.add(lblsname);
		txtDuration = new JTextField();
		txtDuration.setBounds(610,45, 200, 50);
		txtDuration.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		panel.add(txtDuration);
		JLabel lblSbirthday = new JLabel("���ݣ�");
		lblSbirthday.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lblSbirthday.setBounds(850, 45, 100,50);
		panel.add(lblSbirthday);
		txtAuthor = new JTextField();
		txtAuthor.setBounds(960, 45, 200, 50);
		txtAuthor.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		panel.add(txtAuthor);
		JLabel lblsphone = new JLabel("��Դ��");
		lblsphone.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lblsphone.setBounds(150, 115, 100, 50);
		panel.add(lblsphone);
		txtLink = new JTextField();
		txtLink.setBounds(260, 115, 200, 50);
		txtLink.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		panel.add(txtLink);
		JLabel lblsaddres = new JLabel("���ݣ�");
		lblsaddres.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lblsaddres.setBounds(500, 115, 100, 50);
		panel.add(lblsaddres);
		txtSummary = new JTextField();
		txtSummary.setBounds(610, 115, 200, 50);
		txtSummary.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		panel.add(txtSummary);
		JLabel lblStype = new JLabel("���ͣ�");
		lblStype.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lblStype.setBounds(850, 115, 100, 50);
		panel.add(lblStype);
		txtType = new JTextField();
		txtType.setBounds(960, 115, 200, 50);
		txtType.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		panel.add(txtType);
		txtMid = new JTextField();
		panel.add(txtMid);
		JButton butadd = new JButton("��    ��");
		butadd.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		butadd.setBounds(100, 200, 200, 50);
		panel.add(butadd);
		butadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �����Ӱ��Ϣ
				// �õ�����ĵ�Ӱ��Ϣ
				String Title = txtTitle.getText();
				String Duration = txtDuration.getText();
				String Author = txtAuthor.getText();
				String Link = txtLink.getText();
				String Summary = txtSummary.getText();
				String Type = txtType.getText();
				// ��ҪУ��
				if ((!"".equals(Title)) && (!"".equals(Duration)) && (!"".equals(Author)) && (!"".equals(Link))
						&& (!"".equals(Summary)) && (!"".equals(Type))) {
					MovieCollection movieCollection = new MovieCollection();
					movieCollection.setmTitle(Title);
					movieCollection.setmDuration(Duration);
					movieCollection.setmAuthor(Author);
					movieCollection.setmLink(Link);
					movieCollection.setmSummary(Summary);
					movieCollection.setmType(Type);
					
					// ʵ��һ��StudentSerivice,��ɲ������
					MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
					boolean isok = movieCollectionService.save(movieCollection);
					if (isok) {
						// �ɹ�
						// ˢ�±�񣬰��µ�������ʾ����
						DefaultTableModel defaultTableModel = TV(columuNameStrings);
						// ��������table�е���ģ��
						table.setModel(defaultTableModel);
						// ����UI
						table.updateUI();
						txtTitle.setText("");
						txtDuration.setText("");
						txtAuthor.setText("");
						txtLink.setText("");
						txtSummary.setText("");
						txtType.setText("");
					} else {
						// ʧ��
						JOptionPane.showMessageDialog(null, "����ʧ��");
						
					}

				}
			}

		});
		JButton butUpdate = new JButton("��    ��");
		butUpdate.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		butUpdate.setBounds(400, 200, 200, 50);
		panel.add(butUpdate);
		butUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rowNum > -1) {
					System.out.println("ѡ���˼�¼");
					MovieCollection movieCollection = list.get(rowNum);
					String Title = txtTitle.getText();
					String Duration = txtDuration.getText();
					String Author = txtAuthor.getText();
					String Link = txtLink.getText();
					String Summary = txtSummary.getText();
					String Type = txtType.getText();

					// ��ҪУ��
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
							// ����UI
							table.updateUI();
							txtTitle.setText("");
							txtDuration.setText("");
							txtAuthor.setText("");
							txtLink.setText("");
							txtSummary.setText("");
							txtType.setText("");
							rowNum = -1;
						} else {
							JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
						}
					}
				} else {
					System.out.println("δѡ���¼");
				}

			}
		});
		JButton butdelete = new JButton("ɾ    ��");
		butdelete.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		butdelete.setBounds(700, 200, 200, 50);
		panel.add(butdelete);
		butdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rowNum > -1) {
					System.out.println("ѡ���˼�¼");
					@SuppressWarnings("unused")
					MovieCollection movieCollection = list.get(rowNum);
					String id = txtMid.getText();

					MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
					boolean isok = movieCollectionService.delete(Integer.parseInt(id));
					if (isok) {
						DefaultTableModel defaultTableModel = TV(columuNameStrings);
						table.setModel(defaultTableModel);
						// ����UI
						table.updateUI();
						txtTitle.setText("");
						txtDuration.setText("");
						txtAuthor.setText("");
						txtLink.setText("");
						txtSummary.setText("");
						txtType.setText("");
						rowNum = -1;
					} else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("δѡ���¼");
				}
			}

		});
		JButton but = new JButton("��    ��");
		but.setFont(new Font("΢���ź�", Font.PLAIN, 30));
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
		// ��list����ת�浽dataobObjects��
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
