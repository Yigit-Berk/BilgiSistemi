import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.security.PublicKey;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BilgiSistemi extends JFrame {
	private int indis=0;//her buton tıklanınca sonraki değer gelsin
	
	islemler islemler = new islemler();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int BilgiID;
	
	public void setBilgiID(int id) {
        this.BilgiID = id;
    }
	
	public int getBilgiID() { 
        return BilgiID;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BilgiSistemi frame = new BilgiSistemi();
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
	public BilgiSistemi() {
		
		
		/*Rastgele bilginin OnBilgisini getir*/
		JLabel AnaBilgi = new JLabel("Ana Bilgi");
		AnaBilgi.setHorizontalAlignment(SwingConstants.TRAILING);
		AnaBilgi.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/Hoscakal.jpg")));
		AnaBilgi.setHorizontalTextPosition(SwingConstants.LEADING);
		JLabel lbl_BilgiAciklama = new JLabel("çok sessiz bir yer...");
		lbl_BilgiAciklama.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		/*1.jpg denemesi*/
		//int BilgiID=1;//veritabanından gelen
		
		////GunlukBilgiler[5]={random,random,random,random,random};
		//int GunlukBilgiler[]= {1,2,3,4,5};
		//Rastegele bilgi seçme
		//Random random = new Random();
		/*Aynı verileri yazamasın*/
		/*
		for (int i = 0; i < 5; i++) {
			int deger = random.nextInt(5);
			int z=0;
			do {
				if(GunlukBilgiler[z]==deger)
				{
					//System.out.println("if çalıştı");
					break;
				}
				else{
					GunlukBilgiler[i]=deger;
				}
				z++;
			}while(z<GunlukBilgiler.length);
			
		}
		System.out.println("----------");
		*/
		
		int GunlukBilgiler[] = new int[6];

        Random random = new Random();

        for (int i = 0; i < 6; i++) {

            int deger;
            boolean isDuplicate;

            do {
                deger = random.nextInt(1,20);
                isDuplicate = false;

                for (int j = 0; j < i; j++) {
                    if (GunlukBilgiler[j] == deger) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            GunlukBilgiler[i] = deger;
            System.out.println(GunlukBilgiler[i]);
        }
        System.out.println("----------");
			//islemler.RastgeleOnBilgi(1);
			lbl_BilgiAciklama.setText(islemler.RastgeleOnBilgi(GunlukBilgiler[0]));
			AnaBilgi.setIcon(new ImageIcon(
					BilgiSistemi.class.getResource("/Gorseller/" + GunlukBilgiler[0] + ".jpg")));
		
			
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);//Farklı çözünürlükler açısından 1366x768 max kabul edildi
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 92, 82));
		panel.setBounds(0, 0, 984, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		AnaBilgi.setForeground(new Color(255, 255, 255));
		AnaBilgi.setBorder(new LineBorder(new Color(255, 255, 255)));
		AnaBilgi.setBounds(349, 27, 266, 273);
		panel.add(AnaBilgi);
		
		JLabel YeniBilgi = new JLabel("yeni bilgi");
		YeniBilgi.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/QuestionMark.jpg")));
		YeniBilgi.setForeground(new Color(255, 255, 255));
		YeniBilgi.setHorizontalAlignment(SwingConstants.CENTER);
		YeniBilgi.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		YeniBilgi.setBounds(564, 57, 234, 213);
		panel.add(YeniBilgi);
		
		JLabel EskiBilgi = new JLabel("eski bilgi");
		EskiBilgi.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/QuestionMark.jpg")));
		EskiBilgi.setForeground(new Color(255, 255, 255));
		EskiBilgi.setHorizontalAlignment(SwingConstants.CENTER);
		EskiBilgi.setBorder(new LineBorder(new Color(255, 255, 255)));
		EskiBilgi.setBounds(169, 57, 234, 213);
		panel.add(EskiBilgi);
		
		JLabel lblNewLabel_2 = new JLabel("BİLGİ SİSTEMİ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Candara", Font.BOLD, 21));
		lblNewLabel_2.setBounds(26, 27, 141, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/arkaplanYesil2-edited.jpg")));
		lblNewLabel_3.setBounds(0, 0, 984, 330);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 331, 984, 330);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel btn_icerik = new JPanel();
		btn_icerik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//islemler.BilgiAciklamasi(indis);
				BilgiID = GunlukBilgiler[indis];
				System.out.println("ilgimi çekti indi: "+BilgiID);
				
				BilgiSistemi bilgiSistemi = new BilgiSistemi(); // Burada BilgiSistemi nesnesi oluşturuluyor
				bilgiSistemi.setBilgiID(BilgiID);//bilgiID'yi gönder
				
				BilgiEkrani bilgiEkrani = new BilgiEkrani(bilgiSistemi);
				bilgiEkrani.setVisible(true);
			}
		});
		btn_icerik.setBackground(new Color(39, 92, 82));
		btn_icerik.setBounds(112, 248, 190, 57);
		panel_1.add(btn_icerik);
		btn_icerik.setLayout(null);
		
		JLabel lbl_ilgimiCekti = new JLabel("İLGİMİ ÇEKTİ");
		lbl_ilgimiCekti.setForeground(new Color(255, 255, 255));
		lbl_ilgimiCekti.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_ilgimiCekti.setBounds(10, 11, 170, 35);
		btn_icerik.add(lbl_ilgimiCekti);
		
		JPanel btn_sonrakiIcerik = new JPanel();
		btn_sonrakiIcerik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ilgimi çekmedi tuşlandı");
				
				indis++;//indis 1'den başla
				if (indis < GunlukBilgiler.length-1) {//1 eksiği olmalı ki sonraki bilgi sadece görüntülensin getirilmesin
					System.out.println("Görsel no: " + GunlukBilgiler[indis]);
					try {
						
						EskiBilgi.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/" + GunlukBilgiler[indis-1] + ".jpg")));
						
						YeniBilgi.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/" + GunlukBilgiler[indis+1] + ".jpg")));
						
						
						AnaBilgi.setIcon(new ImageIcon(
						BilgiSistemi.class.getResource("/Gorseller/" + GunlukBilgiler[indis] + ".jpg")));
						
						lbl_BilgiAciklama.setText(islemler.RastgeleOnBilgi(GunlukBilgiler[indis]));
					} catch (Exception e2) {
						System.out.println("Görsele ulaşılamadı" + e2);
					}
					//indis++;//indis 1'den başla
				}
				else {
					EskiBilgi.setVisible(false);
					YeniBilgi.setVisible(false);
					AnaBilgi.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/Hoscakal.jpg")));
					lbl_BilgiAciklama.setVisible(false);
					JOptionPane.showMessageDialog(btn_sonrakiIcerik, "Günlük bilgi limitine ulaşıldı.");
					System.out.println("Günlük Bilgi limitine ulaşıldı.");
				}
			}
		});
		btn_sonrakiIcerik.setLayout(null);
		btn_sonrakiIcerik.setBackground(new Color(39, 92, 82));
		btn_sonrakiIcerik.setBounds(359, 248, 190, 57);
		panel_1.add(btn_sonrakiIcerik);
		
		JLabel lbl_ilgimiCekmedi = new JLabel("İLGİMİ ÇEKMEDİ");
		lbl_ilgimiCekmedi.setForeground(Color.WHITE);
		lbl_ilgimiCekmedi.setFont(new Font("Cascadia Mono", Font.BOLD, 17));
		lbl_ilgimiCekmedi.setBounds(10, 11, 170, 35);
		btn_sonrakiIcerik.add(lbl_ilgimiCekmedi);
		
		JPanel btn_Cikis = new JPanel();
		btn_Cikis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_Cikis.setLayout(null);
		btn_Cikis.setBackground(new Color(39, 92, 82));
		btn_Cikis.setBounds(605, 248, 190, 57);
		panel_1.add(btn_Cikis);
		
		JLabel lbl_bugunlukYeterli = new JLabel("Bugünlük Yeterli");
		lbl_bugunlukYeterli.setForeground(Color.WHITE);
		lbl_bugunlukYeterli.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_bugunlukYeterli.setBounds(10, 11, 170, 35);
		btn_Cikis.add(lbl_bugunlukYeterli);
		
		JCheckBox check_zatenBiliniyor = new JCheckBox("Zaten Biliyorum");
		check_zatenBiliniyor.setOpaque(false);
		check_zatenBiliniyor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		check_zatenBiliniyor.setForeground(new Color(0, 0, 0));
		check_zatenBiliniyor.setBackground(new Color(255, 255, 255));
		check_zatenBiliniyor.setBounds(801, 248, 127, 57);
		panel_1.add(check_zatenBiliniyor);
		
		
		lbl_BilgiAciklama.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_BilgiAciklama.setForeground(new Color(39, 92, 82));
		lbl_BilgiAciklama.setBounds(36, 11, 907, 191);
		panel_1.add(lbl_BilgiAciklama);
		
		JPanel btn_Kaydet = new JPanel();
		btn_Kaydet.setLayout(null);
		btn_Kaydet.setBackground(new Color(39, 92, 82));
		btn_Kaydet.setBounds(25, 248, 77, 57);
		panel_1.add(btn_Kaydet);
		
		JLabel lbl_Kaydet = new JLabel("");
		lbl_Kaydet.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Icons/Bilgilerim2.png")));
		lbl_Kaydet.setForeground(Color.WHITE);
		lbl_Kaydet.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Kaydet.setBounds(10, 11, 57, 35);
		btn_Kaydet.add(lbl_Kaydet);
		
		JLabel ArkaPlan_AltPanel = new JLabel("New label");
		ArkaPlan_AltPanel.setIcon(new ImageIcon(BilgiSistemi.class.getResource("/Gorseller/natural-marble-pattern-background2.png")));
		ArkaPlan_AltPanel.setBounds(0, 0, 984, 330);
		panel_1.add(ArkaPlan_AltPanel);
		
		
	}
}
