import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BilgiEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	islemler Islemler = new islemler();
	//BilgiEkrani bilgiEkrani = new BilgiEkrani();
	
	BilgiSistemi bilgiSistemi;//sınıf düzeyinde tanımladık
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BilgiSistemi bilgiSistemi = new BilgiSistemi();//nesneyi burada oluşturduk
					BilgiEkrani frame = new BilgiEkrani(bilgiSistemi);
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
	
	
	
	/*BilgiID'sine göre açıklamayı getir*/
	public BilgiEkrani(BilgiSistemi bilgiSistemi) {
		
		
		setResizable(false);//
		this.bilgiSistemi = bilgiSistemi; // Parametre olarak gelen BilgiSistemi nesnesini sınıf düzeyindeki nesneye atadık
		JLabel Aciklama_Gorsel = new JLabel("New label");
		Aciklama_Gorsel.setBackground(new Color(0, 0, 0));
		//BilgiEkrani bilgiEkrani = new BilgiEkrani();
		
		//bilgiSistemi.BilgiIDGonder(WIDTH);
		//islemler.BilgiAciklamasi(id); // gelen id olacak
		//Islemler.BilgiAciklamasi(bilgiSistemi.BilgiID);
		
		
		//Açıklamayı BilgiID sine göre getiren kodlar
		System.out.println("BilgiID="+bilgiSistemi.getBilgiID());
		Aciklama_Gorsel.setIcon(new ImageIcon(
				BilgiSistemi.class.getResource("/BilgiEkrani/" +bilgiSistemi.getBilgiID()+ ".jpg")));//BilgiID'sine göre Görselini getir
		
		/*TextArea için scroolbar:
		JScrollPane sPane = new JScrollPane(txt_Aciklama,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(sPane);
		*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 984, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 89, 435, 435);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
		Aciklama_Gorsel.setBounds(0, 0, 435, 435);
		panel_1.add(Aciklama_Gorsel);
		
		JButton btn_Sonraki = new JButton("SONRAKİ");
		btn_Sonraki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//BilgiEkrani.this.bilgiSistemi.setVisible(true);//önceki formu getir
				dispose();
				
			}
		});
		btn_Sonraki.setForeground(new Color(255, 255, 255));
		btn_Sonraki.setFocusable(false);
		btn_Sonraki.setIcon(new ImageIcon("C:\\Users\\pc\\Downloads\\icons8-arrow-24.png"));
		btn_Sonraki.setBackground(new Color(39,92,87));
		btn_Sonraki.setBounds(769, 573, 128, 37);
		panel.add(btn_Sonraki);
		
		JButton btn_Kaydet = new JButton("KAYDETME");
		btn_Kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciBilgisi kullaniciBilgisi = new kullaniciBilgisi();
				System.out.println(kullaniciBilgisi.getKullaniciID());
				
				Islemler.haberkayit(kullaniciBilgisi.getKullaniciID(),bilgiSistemi.getBilgiID());//tabloya BilgiID'li alanı ekle
				JOptionPane.showMessageDialog(btn_Kaydet, "Bilgi kayıt edilmiştir.");
			}
		});
		btn_Kaydet.setForeground(new Color(255, 255, 255));
		btn_Kaydet.setFocusable(false);
		btn_Kaydet.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Kaydet.setIcon(new ImageIcon(BilgiEkrani.class.getResource("/Icons/kaydet.png")));
		btn_Kaydet.setBackground(new Color(39,92,87));
		btn_Kaydet.setBounds(611, 573, 128, 37);
		panel.add(btn_Kaydet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(513, 46, 461, 516);
		panel.add(scrollPane);
		
		JTextArea txt_Aciklama = new JTextArea();
		txt_Aciklama.setBackground(new Color(39,92,87));
		txt_Aciklama.setForeground(new Color(230,230,230));
		txt_Aciklama.setWrapStyleWord(true);
		scrollPane.setViewportView(txt_Aciklama);
		txt_Aciklama.setText(Islemler.BilgiAciklamasi(bilgiSistemi.getBilgiID()));//açıklamayı text'e ata
		
		
		txt_Aciklama.setFont(new Font("Candara Light", Font.BOLD, 17));
		txt_Aciklama.setLineWrap(true);
		txt_Aciklama.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 984, 661);
		lblNewLabel.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/natural-marble-pattern-background2.png")));
		panel.add(lblNewLabel);
		panel.setComponentZOrder(lblNewLabel, panel.getComponentCount() - 1); // En alta yerleştir
	}
}
