import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;


class User{
	
private String kullaniciadi;private String parola;//sağ tık> source> generate constructor useing field.                          
public User(String kullaniciadi, String parola) {
	super();
	this.kullaniciadi = kullaniciadi;
	this.parola = parola;
	//sağ tık> source> generate getters and setters.
}

public String getKullaniciadi() {
	return kullaniciadi;
}
public void setKullaniciadi(String kullaniciadi) {
	this.kullaniciadi = kullaniciadi;
}
public String getParola() {
	return parola;
}
public void setParola(String parola) {
	this.parola = parola;
}
}


public class kullanicigiris extends JFrame {
	/*gerekli class'lara erişim*/
	islemler islemler = new islemler();
	
	
	JPanel btn_yeniuye = new JPanel();
	JPanel btn_giris = new JPanel();
	JPanel kullanici_panel=new JPanel();
	
	
	/*Tasarım kodları:*/
	void setVisiblekullanici (JPanel panel_kullanici,JPanel panel_uye) {
		panel_kullanici.setVisible(false);	
		panel_uye.setVisible(true);
    }
	void setVisibleuye (JPanel panel_uye,JPanel panel_kullanici) {
		panel_uye.setVisible(false);	
		panel_kullanici.setVisible(true);
    }
	void setColorkullanici (JPanel panel_renk,JPanel btn_giris) {
		panel_renk.setBackground(new Color(39, 92, 82));
		panel_renk.setForeground(new Color(255,255,255));
		
		btn_giris.setBackground( new Color(240,240,240));
		btn_giris.setForeground(new Color(0,0,0));
    }
	void setColoruye (JPanel panel_renk,JPanel btn_giris) {
		panel_renk.setBackground(new Color(39, 92, 82));
		panel_renk.setForeground(new Color(255,255,255));
		
		btn_giris.setBackground( new Color(240,240,240));
		btn_giris.setForeground(new Color(0,0,0));
    }
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kullanici_adi_alani;
	private JPasswordField parola_alani;
	private JTextField uye_Adi;
	private JPasswordField Uye_Sifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullanicigiris frame = new kullanicigiris();
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
	public kullanicigiris() {
		setResizable(false);
		JPanel btn_yeniuye = new JPanel();
		
		setTitle("Giriş Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 582, 374);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(39, 92, 82));
		panel_3.setBounds(275, 0, 711, 663);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel kullanici_panel = new JPanel();
		{
			
			kullanici_panel.setBounds(148, 155, 465, 359);
			kullanici_panel.setBackground( new Color(0, 0, 0, 30) );
			panel_3.add(kullanici_panel);
			kullanici_panel.setLayout(null);	
		
		}
		
		kullanici_adi_alani = new JTextField();
		kullanici_adi_alani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kullanici_adi_alani.setBounds(42, 67, 367, 43);//42, 164, 367, 39
		kullanici_panel.add(kullanici_adi_alani);
		kullanici_adi_alani.setForeground(Color.BLACK);
		kullanici_adi_alani.setColumns(10);
		
		parola_alani = new JPasswordField();
		parola_alani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		parola_alani.setBounds(42, 164, 367, 39);
		kullanici_panel.add(parola_alani);
		parola_alani.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı Giriniz");
		lblNewLabel.setBounds(48, 23, 161, 34);
		kullanici_panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Şifre Giriniz\r\n");
		lblNewLabel_1.setBounds(42, 120, 140, 34);
		kullanici_panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JButton login = new JButton("Giriş Yap");
		login.setFocusable(false);
		login.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		login.setBounds(163, 265, 129, 35);
		kullanici_panel.add(login);
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(0, 64, 64));
		
		JPanel uye_panel = new JPanel();
		uye_panel.setBounds(148, 155, 465, 359);
		panel_3.add(uye_panel);
		uye_panel.setVisible(false);
		uye_panel.setLayout(null);
		uye_panel.setBackground(new Color(0, 0, 0, 30));
		
		uye_Adi = new JTextField();
		uye_Adi.setForeground(Color.BLACK);
		uye_Adi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uye_Adi.setColumns(10);
		uye_Adi.setBounds(42, 67, 367, 43);//42, 164, 367, 39
		uye_panel.add(uye_Adi);
		
		Uye_Sifre = new JPasswordField();
		Uye_Sifre.setForeground(Color.BLACK);
		Uye_Sifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Uye_Sifre.setBounds(42, 164, 367, 39);
		uye_panel.add(Uye_Sifre);
		
		JLabel lblKullancAdOluturunuz = new JLabel("Kullanıcı Adı Oluşturunuz");
		lblKullancAdOluturunuz.setForeground(Color.WHITE);
		lblKullancAdOluturunuz.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblKullancAdOluturunuz.setBackground(Color.WHITE);
		lblKullancAdOluturunuz.setBounds(48, 23, 179, 34);
		uye_panel.add(lblKullancAdOluturunuz);
		
		JLabel lblNewLabel_1_1 = new JLabel("Şifre Oluşturunuz\r\n");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(42, 120, 140, 34);
		uye_panel.add(lblNewLabel_1_1);
		
		JButton btnKaytOl = new JButton("Kayıt Ol");
		btnKaytOl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String kullanici_adi=uye_Adi.getText();
				String parola=new String(Uye_Sifre.getPassword());
				
				islemler.kullaniciEkle(kullanici_adi, parola);
				JOptionPane.showMessageDialog(btnKaytOl, "Kayıt başarılı");
				btn_yeniuye.setVisible(false);
				
				
			}
		});
		btnKaytOl.setForeground(Color.WHITE);
		btnKaytOl.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnKaytOl.setBackground(new Color(0, 64, 64));
		btnKaytOl.setBounds(163, 265, 129, 35);
		uye_panel.add(btnKaytOl);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(kullanicigiris.class.getResource("/Gorseller/Leaf_SadeBulanik.jpg")));
		lblNewLabel_3.setBounds(10, 10, 691, 643);
		panel_3.add(lblNewLabel_3);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullanicigiris kullanicigiris = new kullanicigiris();
				BilgiSistemi bilgiSistemi = new BilgiSistemi();
				
				String kullanici_adi=kullanici_adi_alani.getText();
				String parola=new String(parola_alani.getPassword());
				String kullaniciKontrol=islemler.kullanicikontrol(kullanici_adi, parola);
				
				//eğer kullanıcı var ise ana uygulamaya geç
				if(!kullaniciKontrol.equals("")) {
					kullaniciBilgisi kullaniciBilgisi = new kullaniciBilgisi();//giriş yapan kullanıcıID'sini belirlemek için
					kullaniciBilgisi.setKullaniciID(kullaniciKontrol);//dönen KullaniciID'yi set et
					
					
					kullanicigiris.setVisible(false);//bu formu gizle
					
					//hangi kullanıcı olduğunu id cinsinden verir
					System.out.println(islemler.kullanicikontrol(kullanici_adi, parola));
					dispose();
					bilgiSistemi.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(lblNewLabel_3, "Kayıt bulunamadı, lütfen kayıt olunuz.");
				}
				
			}
		});
	
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 0, 276, 663);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 128, 0));
		separator.setBounds(10, 158, 256, 19);
		panel_4.add(separator);
		
		JLabel txt_welcome = new JLabel("Hoş Geldiniz!");
		txt_welcome.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		txt_welcome.setBounds(67, 125, 173, 23);
		panel_4.add(txt_welcome);
		
		JLabel txt_aciklama = new JLabel("New label");
		txt_aciklama.setHorizontalTextPosition(SwingConstants.CENTER);
		txt_aciklama.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		txt_aciklama.setBounds(20, 158, 256, 123);
		txt_aciklama.setText("<html> <p align = 'center'> Programımız aracılığıyla seçtiğiniz bilgileri kaydetmek<br>ve <br>uygulama deneyiminizi artırmak için hesap oluşturmanız gerekmektedir.</p></html>");
	
		panel_4.add(txt_aciklama);
		
		JPanel btn_giris = new JPanel();
		btn_giris.setToolTipText("");
		btn_giris.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				setVisiblekullanici(uye_panel,kullanici_panel);
				setColoruye(btn_giris,btn_yeniuye);
				
				
				System.out.println("basıldı");
				
			}
		});
		btn_giris.setBounds(67, 340, 119, 37);
		panel_4.add(btn_giris);
		btn_giris.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Hesabım Var");
		lblNewLabel_2.setBounds(30, 10, 79, 13);
		btn_giris.add(lblNewLabel_2);
		
		//JPanel btn_yeniuye = new JPanel();
		btn_yeniuye.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//panel_gorunum();
				setVisiblekullanici(kullanici_panel,uye_panel);
				setColorkullanici(btn_yeniuye,btn_giris);
				
			}
		});
		btn_yeniuye.setBounds(67, 439, 119, 37);
		//
		
	
		panel_4.add(btn_yeniuye);
		btn_yeniuye.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hesabım Yok\r\n");
		lblNewLabel_2_1.setBounds(28, 10, 81, 13);
		btn_yeniuye.add(lblNewLabel_2_1);
	}
}
