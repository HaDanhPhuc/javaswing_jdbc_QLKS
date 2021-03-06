package GUI;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.SystemColor;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.ItemEvent;
	import java.awt.event.ItemListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

	import javax.swing.DefaultComboBoxModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
	import javax.swing.UIManager;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.TitledBorder;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.table.TableModel;
	import javax.swing.table.TableRowSorter;

import Dao.QLKhachHang;
import Dao.XuLyChung;
import Entity.KhachHang;






	public class CapNhatKH extends JFrame implements ActionListener,MouseListener{
		private JPanel khung;
		
		private JLabel lblMaKH;
		private JLabel lblTenKH;
		private JLabel lblCmnd;
		private JLabel lblQueQuan;
		private JLabel lblPhai;
		private JLabel lblTimKiem;
		private JLabel lblsdt;

		private JComboBox<String>  combobox,combobox1;
		private JTextField txtMaKH;
		private JTextField txtTenKH;
		private JTextField txtCmnd;
		private JTextField txtTimKiem;
		private JTextField txtsdt;
		
		
		private JTable tableKH;
		private DefaultTableModel tableModelKH;
		private JTable table1;
		private DefaultTableModel tableModel1;
		private JTable table3;
		private DefaultTableModel tableModel3;
		
		private JButton btnXoa;
		private JButton btnSua;
		private JButton btnTimKiem;
		private JButton btnThoat;
		private JButton btnThem;
		private JButton btnLammoi;
		public CapNhatKH() {
			setResizable(false);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("H??? TH??NG QU???N L?? KH??CH S???N");
			setBounds(300, 100, 1300, 700);
			khung = new JPanel();
			khung.setBackground(new Color(100,149,237));
			khung.setForeground(new Color(173, 216, 230));
			khung.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(khung);
			khung.setLayout(null);
			
			JLabel lblQLSV = new JLabel("TI???N H??NH C???P NH???T KH??CH H??NG");
			lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblQLSV.setForeground(new Color(0,0,0));
			lblQLSV.setBounds(370, 22, 600, 35);
			khung.add(lblQLSV);
			
			JPanel p1 = new JPanel();
			p1.setForeground(new Color(0,255,255));
			p1.setBackground(new Color(143,188,143));
			p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th??ng tin kh??ch h??ng ",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			p1.setBounds(0, 80, 430, 684);
			khung.add(p1);
			p1.setLayout(null);
			
			String[]headers1 = {"M?? kh??ch h??ng","T??n kh??ch h??ng","CMND","Qu?? qu??n","Gioi T??nh","S??? ??i???n tho???i"};
			tableModelKH = new DefaultTableModel(headers1,0);
			JPanel pnTable= new JPanel();
			pnTable.setBounds(450, 100,800,570);
			pnTable.setBackground(new Color(204, 204, 204));
			pnTable.setBackground(new Color(204, 204, 204));
			pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s??ch Kh??ch h??ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			pnTable.setLayout(new GridLayout(1, 0, 0, 0));
			khung.add(pnTable);
			JScrollPane scroll;
			tableKH = new JTable(tableModelKH);
			tableKH.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			pnTable.add( scroll = new JScrollPane(tableKH, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			

			/*String[]headers2 = {"Ma?? ph??ng","Tr???ng th??i","S??? ng?????i","?????a ch???","T??n Ch??? Tr???","S??? ??i???n tho???i"};
			tableModel1 = new DefaultTableModel(headers2,0);
			JPanel pnTable1= new JPanel();
			pnTable1.setBounds(440,255 ,840,170);
			pnTable1.setBackground(new Color(204, 204, 204));
			pnTable1.setBackground(new Color(204, 204, 204));
			pnTable1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s??ch ph??ng tr???ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			pnTable1.setLayout(new GridLayout(1, 0, 0, 0));
			khung.add(pnTable1);
			JScrollPane scroll1;
			pnTable1.add( scroll1 = new JScrollPane(table1 = new JTable(tableModel1) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			}));
			scroll1.setBackground(new Color(102, 0, 102));
			table1.setForeground(new Color(0, 0, 0));
			table1.setBackground(new Color(204, 204, 204));
			table1.setRowHeight(25);
			table1.setAutoCreateRowSorter(true);
			scroll1.setViewportView(table1);
			String[]headers3 = {"Ma?? ph??ng","Tr???ng th??i","S??? ng?????i","?????a ch???","T??n Ch??? Tr???","S??? ??i???n tho???i"};
			tableModel3 = new DefaultTableModel(headers3,0);
			JPanel pnTable2= new JPanel();
			pnTable2.setBounds(440, 85,840,170);
			pnTable2.setBackground(new Color(204, 204, 204));
			pnTable2.setBackground(new Color(204, 204, 204));
			pnTable2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s??ch ph??ng ??a?? ??????t", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			pnTable2.setLayout(new GridLayout(1, 0, 0, 0));
			khung.add(pnTable2);
			JScrollPane scroll3;
			pnTable2.add( scroll3 = new JScrollPane(table3 = new JTable(tableModel3) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			}));
			scroll3.setBackground(new Color(102, 0, 102));
			table3.setForeground(new Color(0, 0, 0));
			table3.setBackground(new Color(204, 204, 204));
			table3.setRowHeight(25);
			table3.setAutoCreateRowSorter(true);
			scroll3.setViewportView(table3);
			*/
			//KetNoiDatabase.getInstance().Connect();
			//updateDataBang2();
			//updateDataBang1();
			//updateDataBang3();
			
			
			lblMaKH= new JLabel("M?? Kh??ch h??ng:");
			lblMaKH .setBounds(10, 50, 120, 14);
			p1.add(lblMaKH );		
			txtMaKH  = new JTextField();
			txtMaKH .setBounds(140, 47, 200, 20);
			p1.add(txtMaKH );
			txtMaKH .setColumns(10);
			
			lblTenKH = new JLabel("T??n kh??ch h??ng:");
			lblTenKH .setBounds(10, 100, 120, 14);
			p1.add(lblTenKH);		
			txtTenKH  = new JTextField();
			txtTenKH .setBounds(140, 97, 200, 20);
			p1.add(txtTenKH );
			txtTenKH .setColumns(10);
			
			lblCmnd = new JLabel("S??? CMND:");
			lblCmnd .setBounds(10, 150, 120, 14);
			p1.add(lblCmnd );		
			txtCmnd  = new JTextField();
			txtCmnd.setBounds(140, 147, 200, 20);
			p1.add(txtCmnd);
			txtCmnd.setColumns(10);
			
			lblQueQuan = new JLabel("Qu?? qu??n:");
			lblQueQuan.setBounds(10, 200, 120, 14);
			p1.add(lblQueQuan );		
			combobox1 = new JComboBox();
			combobox1.setBounds(140, 197, 200, 20);
			p1.add(combobox1);
			combobox1.addItem("-   -");
			combobox1.addItem("An Giang");
			combobox1.addItem("B?? R???a - V??ng T??u");
			combobox1.addItem("B???c Giang");
			combobox1.addItem("B???c K???n");
			combobox1.addItem("B???c Li??u");
			combobox1.addItem("B???c Ninh");
			combobox1.addItem("B???n Tre");
			combobox1.addItem("B??nh ?????nh");
			combobox1.addItem("B??nh D????ng");
			combobox1.addItem("B??nh Ph?????c");
			combobox1.addItem("B??nh Thu???n");
			combobox1.addItem("C?? Mau");
			combobox1.addItem("C???n Th??");
			combobox1.addItem("Cao B???ng");
			combobox1.addItem("???? N???ng");
			combobox1.addItem("?????k L???k");
			combobox1.addItem("?????k N??ng");
			combobox1.addItem("??i???n Bi??n");
			combobox1.addItem("?????ng Nai");
			combobox1.addItem("?????ng Th??p");
			combobox1.addItem("Gia Lai");
			combobox1.addItem("H?? Giang");
			combobox1.addItem("H?? Nam");
			combobox1.addItem("H?? N???i");
			combobox1.addItem("H?? T??nh");
			combobox1.addItem("H???i D????ng");
			combobox1.addItem("H???i Ph??ng");
			combobox1.addItem("H???u Giang");
			combobox1.addItem("H??a B??nh");
			combobox1.addItem("H??ng Y??n");
			combobox1.addItem("Kh??nh H??a");
			combobox1.addItem("Ki??n Giang");
			combobox1.addItem("Kon Tum");
			combobox1.addItem("Lai Ch??u");
			combobox1.addItem("L??m ?????ng");
			combobox1.addItem("L???ng S??n");
			combobox1.addItem("L??o Cai");
			combobox1.addItem("Long An");
			combobox1.addItem("Nam ?????nh");
			combobox1.addItem("Ngh??? An");
			combobox1.addItem("Ninh B??nh");
			combobox1.addItem("Ninh Thu???n");
			combobox1.addItem("Ph?? Th???");
			combobox1.addItem("Ph?? Y??n");
			combobox1.addItem("Qu???ng B??nh");
			combobox1.addItem("Qu???ng Nam");
			combobox1.addItem("Qu???ng Ng??i");
			combobox1.addItem("Qu???ng Ninh");
			combobox1.addItem("Qu???ng Tr???");
			combobox1.addItem("S??c Tr??ng");
			combobox1.addItem("S??n La");
			combobox1.addItem("T??y Ninh");
			combobox1.addItem("Th??i B??nh");
			combobox1.addItem("Th??i Nguy??n");
			combobox1.addItem("Thanh H??a");
			combobox1.addItem("Th???a Thi??n Hu???");
			combobox1.addItem("Ti???n Giang");
			combobox1.addItem("Th??nh ph??? H??? Ch?? Minh");
			combobox1.addItem("Tr?? Vinh");
			combobox1.addItem("Tuy??n Quang");
			combobox1.addItem("V??nh Long");
			combobox1.addItem("V??nh Ph??c");
			combobox1.addItem("Y??n B??i");

			
			lblPhai = new JLabel("Gi???i t??nh:");
			lblPhai.setBounds(10, 250, 120, 14);
			p1.add(lblPhai);
			combobox = new JComboBox();
			combobox.setBounds(140, 247, 200, 20);
			p1.add(combobox);
			combobox.addItem("- -");
			combobox.addItem("Nam");
			combobox.addItem("Nu");
			
			lblsdt = new JLabel("S??? ??i???n tho???i:");
			lblsdt .setBounds(10, 300, 200, 14);
			p1.add(lblsdt );		
			txtsdt  = new JTextField();
			txtsdt .setBounds(140, 297, 200, 20);
			p1.add(txtsdt );
			txtsdt.setColumns(10);
			
			
			
			
			btnThem = new JButton("Th??m");
			btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			btnThem.setForeground(new Color(255, 255, 255));
			btnThem.setBackground(new Color(0,0,205));
			btnThem.setBounds(20, 400, 100, 40);
			p1.add(btnThem);
			
			btnXoa = new JButton("X??a");
			btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnXoa.setForeground(new Color(255, 255, 255));
			btnXoa.setBackground(new Color(0,0,205));
			btnXoa.setBounds(130,400, 100, 40);
			p1.add(btnXoa);
			
			btnSua = new JButton("S???a");
			btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnSua.setForeground(new Color(255, 255, 255));
			btnSua.setBackground(new Color(0,0,205));
			btnSua.setBounds(240,400, 100, 40);
			p1.add(btnSua);
			
			btnLammoi = new JButton("L??m m???i");
			btnLammoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnLammoi.setForeground(new Color(255, 255, 255));
			btnLammoi.setBackground(new Color(0,0,205));
			btnLammoi.setBounds(40,470, 120, 40);
			p1.add(btnLammoi);
			
			btnThoat = new JButton("Tho??t");
			btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThoat.setForeground(new Color(255, 255, 255));
			btnThoat.setBackground(new Color(0,0,205));
			btnThoat.setBounds(170,470, 120, 40);
			p1.add(btnThoat);
			
			
			lblTimKiem= new JLabel("Nh???p th??ng tin c???n t??m:");
			lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTimKiem.setBounds(800, 60, 340, 35);
			khung.add(lblTimKiem);
			txtTimKiem= new JTextField();
			txtTimKiem.setBounds(1000,67, 150, 25);
			khung.add(txtTimKiem);
			btnTimKiem = new JButton("T??m");
			btnTimKiem.setForeground(new Color(255, 255, 255));
			btnTimKiem.setBackground(new Color(0,0,205));
			btnTimKiem.setBounds(1160, 70, 70, 25);
			khung.add(btnTimKiem);
			
				
			txtMaKH.setEditable(false);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			
			btnThem.addActionListener(this);
			btnLammoi.addActionListener(this);
			btnTimKiem.addActionListener(this);
			btnThoat.addActionListener(this);
			btnXoa.addActionListener(this);
			btnSua.addActionListener(this);
			
			tableKH.addMouseListener(this);
			
			updatetabaleData();

		//xu ly tim kiem 
		//public void TimKiem() {
			txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	                TimKiemKeyRelease(evt);
	            }
	            
				private void TimKiemKeyRelease(KeyEvent evt) {
					DefaultTableModel tableModel = (DefaultTableModel)tableKH.getModel();
					String search = txtTimKiem.getText();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
					tableKH.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(search));
				}
	        });
		}
		public void updatetabaleData() {
			QLKhachHang qlkh=new QLKhachHang();
			tableModelKH.getDataVector().removeAllElements();
			ArrayList<KhachHang> dskh = qlkh.layDanhSachKH();
			String temp;
			for (KhachHang kh : dskh) {
				temp = kh.toString();
				tableModelKH.addRow(temp.split(";"));
			}
			txtMaKH.setEditable(false);
			txtMaKH.setText(XuLyChung.layMaKH());
		}

		/*private void updateDataBang1() {
			QuanLiSinhVienDP qlsvdp  = new QuanLiSinhVienDP();
			List<SinhVienDP>list = qlsvdp.docTuBangSinhVienDP();
			for(SinhVienDP s : list) {
				String[] rowdata = {s.getMaSV(),s.getTenSinhVien(),s.getGioiTinh(),s.getSoDienThoai(),s.getCmnd(),s.getQueQuan(),s.getNgayVaoPhong(),s.getMaPhong()+""};
				tableModel.addRow(rowdata);
			}
			table.setModel(tableModel);
		}
		private void updateDataBang2() {
			QuanLiPhongTro qlpt = new QuanLiPhongTro();
			List<PhongTro>list = qlpt.docbangPhongTrong();
			for(PhongTro s : list) {
				String[] rowdata = {s.getMaPhong(),s.getTrangThai(),s.getSoNguoi(),s.getDiaChi(),s.getTenChuTro(),s.getSdt()+""};
				tableModel1.addRow(rowdata);
			}
			table1.setModel(tableModel1);
		}
		private void updateDataBang3() {
			QuanLiPhongTro qlpt = new QuanLiPhongTro();
			List<PhongTro>list = qlpt.docbangPhongdadat();
			for(PhongTro s : list) {
				String[] rowdata = {s.getMaPhong(),s.getTrangThai(),s.getSoNguoi(),s.getDiaChi(),s.getTenChuTro(),s.getSdt()+""};
				tableModel3.addRow(rowdata);
			}
			table3.setModel(tableModel3);
		}
		public static void main(String[] args) {
			/////////////Ph???i Theo m???u///////////////////////
			java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new GiaoDienDatPhong().setVisible(true);
	            }
	        });
		}*/

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o=e.getSource();
			if(o.equals(btnThem)){
				ThemKH();
				
			}
			if(o.equals(btnXoa)) {
				xoaKH();
			}
			if(o.equals(btnSua)) {
				suaKH();
			}
			
			if(o.equals(btnThoat))
			{
				new giaodienChinh().setVisible(true);
				this.dispose();
			}	
			
			if(o.equals(btnLammoi)){
				LamMoi();
			}
			
			
		}
		public void LamMoi() {
			txtMaKH.setText(XuLyChung.layMaKH());
			txtTenKH.setText("");
			txtsdt.setText("");
			txtCmnd.setText("");
			combobox.setSelectedIndex(0);
			combobox1.setSelectedIndex(0);
			txtTimKiem.setText("");
			txtTimKiem.requestFocus();
			
		}
		public void ThemKH() {
			// TODO Auto-generated method stub
			QLKhachHang qlkh=new QLKhachHang();
			
			if (kiemtrathemKH()) {
				if (qlkh.themkhachhanh(txtMaKH.getText(),txtTenKH.getText(),txtCmnd.getText(), combobox1.getSelectedItem().toString(),combobox.getSelectedItem().toString(),  txtsdt.getText() )) {
					for (int i = tableModelKH.getRowCount() - 1; i >= 0; i--) {
						tableModelKH.removeRow(i);
					}
					
					JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!!!");
					updatetabaleData();
					LamMoi();
					//restartKH();
					
				} else {
					JOptionPane.showMessageDialog(this, "Tr??ng m??!!!");
				}
			}

		}
		public boolean kiemtrathemKH() {
			// TODO Auto-generated method stub
			String makh = txtMaKH.getText().trim();
			String ten = txtTenKH.getText().trim();
			String cmnd=txtCmnd.getText().trim();
			//String quequan=combobox1.getSelectedItem().toString();
			//String gioitinh=combobox.getSelectedItem().toString();
			String sdt = txtsdt.getText().trim();
			if (!(makh.length() > 0 && XuLyChung.kiemTraMaKhachHang(makh))) {
				JOptionPane.showMessageDialog(this, "M?? khach hang ph???i theo m???u:^KH[0-9]{1,8}$");
				return false;
			}
			if (!(ten.length() > 0)) {
				JOptionPane.showMessageDialog(this, "T??n khach hang kh??ng ???????c r???ng!!!");
				return false;
			}
			if (!(XuLyChung.kiemTraCMND(cmnd))) {
				JOptionPane.showMessageDialog(this, "S??? ch???ng minh th??? c??n c?????c ph???i d???ng s??? ");
				return false;
				
			}
			
			if (!(XuLyChung.kiemTraSoDT(sdt))) {
				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i theo m???u:(^0[0-9]{9}$)|(^01[0-9]{11}$)");
				return false;
				
			}
			

			return true;
		}
		
		public void xoaKH() {
			// TODO Auto-generated method stub
			QLKhachHang qlkh=new QLKhachHang();
					int row = tableKH.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(this, "B???n ch??a ch???n d??ng c???n x??a");
				return;
			} else {
				int hoi = JOptionPane.showConfirmDialog(this, "Ban co chac chan xoa khong?", "Chu y",
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					 qlkh.xoaKHang(tableKH.getValueAt(row, 0).toString());
					tableModelKH.removeRow(row);
					LamMoi();
					updatetabaleData();
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				}
			}
		}
		public void suaKH() {
			// TODO Auto-generated method stub
			QLKhachHang qlkh=new QLKhachHang();
			//KhachHang a = qlkh.timTheoMa(txtMaKH.getText());
			if (kiemtrathemKH()) {
				//if (a != null) {
					int hoi = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n S???a", "Ch?? ??!!!",
							JOptionPane.YES_NO_OPTION);
					if (hoi == JOptionPane.YES_OPTION) {
						qlkh.capNhatkhachhanh(txtMaKH.getText(), txtTenKH.getText(),txtCmnd.getText(),combobox1.getSelectedItem().toString(), combobox.getSelectedItem().toString(),txtsdt.getText() );
						for (int i = tableModelKH.getRowCount() - 1; i >= 0; i--) {
							tableModelKH.removeRow(i);
						}
						JOptionPane.showMessageDialog(this, "S???a th??nh c??ng!!!");
						LamMoi();
						updatetabaleData();
						btnSua.setEnabled(false);
						btnXoa.setEnabled(false);

					}

				} else {
					JOptionPane.showMessageDialog(this, "S???a kh??ng th??nh c??ng , sai m??!!!");
				}
			}
		//}
		
		
		/*private boolean kiemloi(){
			String tensv = txtTenPhong.getText().trim();
			String Mssv = txtTenKH.getText().trim();
			String Cmnd = txtCmnd.getText().trim();
			String ngayVao = txtNgayVao.getText().trim();
			//String SoDienThoai = txtSoDienThoai.getText().trim();
			//String maPhong = txtMaPhong.getText().trim();
			if(!(tensv.length()>0 ))
			{
				JOptionPane.showMessageDialog(this, "T??n nh????p kh??ng ????????c nh????p s????");
				txtTenKH.requestFocus();
				return false;
			}
			if(!(Mssv.length()>0 && Mssv.matches("[SV]{2}\\d{2,3}")))
			{

				JOptionPane.showMessageDialog(this, "Ma?? S???? Sinh vi??n theo ??i??nh da??ng [SV]{2}\\d{2,3}");
				txtCmnd.requestFocus();
				return false;
			}
			if(!(Cmnd.length()>0 && Cmnd.matches("\\d{9}"))){
				JOptionPane.showMessageDialog(this, "S???? Ch????ng Minh Nh??n d??n g????m 9 s???? t???? 0-9");
				txtCmnd.requestFocus();
				return false;
			}
			if(!(ngayVao.length()>0 && ngayVao.matches("^\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}$"))){

			JOptionPane.showMessageDialog(this, "Nh????p nga??y Va??o theo ??i??nh da??ng 0000-00-00 , N??m-Tha??ng-Nga??y< nga??y hi????n ta??i ");
			txtNgayVao.requestFocus();
				return false;
				}
		/*	if(!(maPhong.length()>0 && maPhong.matches("[A-Z]\\d{2,3}"))) {
				JOptionPane.showMessageDialog(this, "Ma?? Pho??ng co?? ??i??nh da??ng [A-Z]\\d{3}");
				txtMaPhong.requestFocus();
				return false;
			}
			if(!(SoDienThoai.length()>0 && SoDienThoai.matches("^0[0-9]{8}$")))
			{
				JOptionPane.showMessageDialog(this, "S???? ??i????n thoa??i theo m????u ^0[0-9]{8}$");
				txtSoDienThoai.requestFocus();
				return false;
			}
			return true;
		}
		/*public void themSinhVienDP() {

			if(kiemloi())
		{

				if(qlsvdp.ThemSinhVienDP(txtMaSinhVien.getText(), txtTenSinhVien.getText(), 
						combobox.getSelectedItem().toString(), txtSoDienThoai.getText(),txtCmnd.getText(), 
						combobox1.getSelectedItem().toString(), txtNgayVao.getText(), txtMaPhong.getText())){	

					Object[]rowdata = {txtMaSinhVien.getText(), txtTenSinhVien.getText(), 
							combobox.getSelectedItem().toString(), txtSoDienThoai.getText(),txtCmnd.getText(), 
							combobox1.getSelectedItem().toString(), txtNgayVao.getText(), txtMaPhong.getText()};
					tableModel.addRow(rowdata);
						XoaRong();
					//xoadongphongtrong();
					JOptionPane.showMessageDialog(this, "??????t Tro?? Tha??nh C??ng");
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Ma?? Sinh Vi??n  Tru??ng Ho????c Ma?? Pho??ng Kh??ng T????n Ta??i");
				}
			}

		}*/
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			int row  = tableKH.getSelectedRow();
			txtMaKH.setText(tableKH.getValueAt(row, 0).toString());
			txtTenKH.setText(tableKH.getValueAt(row, 1).toString());
			txtCmnd.setText(tableKH.getValueAt(row, 2).toString());
			combobox1.setSelectedItem(tableKH.getValueAt(row,3).toString());	
			combobox.setSelectedItem (tableKH.getValueAt(row,4).toString());	
			txtsdt.setText(tableKH.getValueAt(row, 5).toString());
			
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

