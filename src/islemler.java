import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;



public class islemler {
	private Connection con = null;
	
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	/*Veritabanı bağlantısı burada gerçekleşir*/
	public islemler() {
		String url="jdbc:mysql://"+Database.host + ":"+Database.port+"/"+Database.db_ismi+"?useunicode=true&characterEncoding=utf8";
		try {
			con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);//Database.java içindeki değerleri çektik
			System.out.println("Bağlantı başarılı");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bağlantı başarısız");
			e.printStackTrace();//hatanın nerede olduğunu gösteren kod
		}
	}
	
	public void goruntule() {
		String sorgu="Select * from bilgiler";
		try {
			statement = con.createStatement();//sql bağlantı üzerinden statement oluşturduk
			//statement.executeQuery(sorgu);
			ResultSet rs =statement.executeQuery(sorgu);//değer döndürdüğü için result olarak tanımlarız
			
			while (rs.next()) {//next(): okunacak daha fazla değer var ise yoksa döngü sonlanır zaten
				int id =rs.getInt("BilgiID");
				String Aciklama = rs.getString("Aciklama");
				String Kategori = rs.getString("Kategori");
				String OnBilgi = rs.getString("OnBilgi");
				System.out.println("ID: "+id+" Kategori: "+Kategori+" OnBilgi: "+OnBilgi);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String RastgeleOnBilgi(int bilgi) {
		String sorgu="Select OnBilgi from bilgiler where BilgiID="+bilgi;
		try {
			statement = con.createStatement();//sql bağlantı üzerinden statement oluşturduk
			//statement.executeQuery(sorgu);//değer döndürdüğü için result olarak tanımlarız
			ResultSet rs =statement.executeQuery(sorgu);
			
			while (rs.next()) {//next(): okunacak daha fazla değer var ise yoksa döngü sonlanır zaten
				String OnBilgi = rs.getString("OnBilgi");
				System.out.println("OnBilgi: "+OnBilgi);
				return OnBilgi;//sorgu sonucunu döndür
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String BilgiAciklamasi(int bilgi) {
		String sorgu="Select Aciklama from bilgiler where BilgiID="+bilgi;
		try {
			statement = con.createStatement();//sql bağlantı üzerinden statement oluşturduk
			//statement.executeQuery(sorgu);//değer döndürdüğü için result olarak tanımlarız
			ResultSet rs =statement.executeQuery(sorgu);
			
			while (rs.next()) {//next(): okunacak daha fazla değer var ise yoksa döngü sonlanır zaten
				String Aciklama = rs.getString("Aciklama");
				System.out.println("Aciklama: "+Aciklama);
				return Aciklama;//sorgu sonucunu döndür
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	/*Kullanici Fonksiyonları*/
	public void kullanicibilgisi() {
		String sorgu="Select * from kullanicilar";
		try {
			statement = con.createStatement();//sql bağlantı üzerinden statement oluşturduk
			//statement.executeQuery(sorgu);//değer döndürdüğü için result olarak tanımlarız
			ResultSet rs =statement.executeQuery(sorgu);
			
			while (rs.next()) {//next(): okunacak daha fazla değer var ise yoksa döngü sonlanır zaten
				String KullaniciAdi = rs.getString("KullaniciAdi");
				String Sifre = rs.getString("Sifre");
				String KullaniciID = rs.getString("KullaniciID");
				System.out.println("Kullanıcı Adı: "+KullaniciAdi+" Şifre :"+Sifre+" KullaniciID :"+KullaniciID);
			//sorgu sonucunu döndür
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static boolean kullaniciEkle(String kullaniciAdi, String sifre) {
	      
		 try {
		        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";

		        // Bağlantıyı oluşturma
		        Connection conn = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);

		        // Sorgu hazırlama
		        String sorgu = "INSERT INTO kullanicilar (KullaniciAdi, Sifre) VALUES (?, ?)";
		        PreparedStatement statement = conn.prepareStatement(sorgu);
		        statement.setString(1, kullaniciAdi);
		        statement.setString(2, sifre);

		        // Sorguyu çalıştırma ve sonucu alma
		        int ekle = statement.executeUpdate();

		        // Bağlantıyı kapatma
		        conn.close();

		        // Ekleme başarılı mı kontrol etme
		        boolean eklemeBasarili = ekle > 0;
		        if (eklemeBasarili) {
		            System.out.println("Kullanıcı başarıyla eklendi!");
		        } else {
		            System.out.println("Kullanıcı eklenirken bir hata oluştu!");
		        }
		        return eklemeBasarili;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		
	 }
	 public static String kullanicikontrol(String kullaniciAdi, String sifre) {
	        boolean varMi = false;
	        try {
	            String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";

	            // Bağlantıyı oluşturma
		        Connection conn = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);

	            // Sorguyu hazırlama
	            String sorgu = "SELECT * FROM kullanicilar WHERE KullaniciAdi = ? AND Sifre = ?";
	            PreparedStatement statement = conn.prepareStatement(sorgu);
	            statement.setString(1, kullaniciAdi);
	            statement.setString(2, sifre);

	            // Sorguyu çalıştırma ve sonucu alma
	            ResultSet rs = statement.executeQuery();
	            if (rs.next()) {
				
					String KullaniciID = rs.getString("KullaniciID");
					String KullaniciAdi = rs.getString("KullaniciAdi");
					String Sifre = rs.getString("sifre");
					//System.out.println("Kullanıcı Adı: "+KullaniciAdi+" Şifre :"+Sifre+" KullaniciID :"+KullaniciID);
				//sorgu sonucunu döndür
	                return KullaniciID;
	            
	                //varMi = true;
	            }
	            // Bağlantıyı kapatma
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
	
	 
	 public static void haberkayit(String KullaniciID, int BilgiID) {
         try {
                String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";

                // Bağlantıyı oluşturma
                Connection conn = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);

                // Sorgu hazırlama
                String sorgu = "INSERT INTO kullanicibilgileri (KullaniciID, BilgiID) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(sorgu);
                statement.setString(1, KullaniciID);
                statement.setInt(2, BilgiID);

                // Sorguyu çalıştırma ve sonucu alma
                int ekle = statement.executeUpdate();

                // Bağlantıyı kapatma
                conn.close();

                // Ekleme başarılı mı kontrol etme
                boolean eklemeBasarili = ekle > 0;
                if (eklemeBasarili) {
                    System.out.println("Haber başarıyla kullanıcının sistemine eklendi!");
                } else {
                    System.out.println("Haber kullanıcının sistemine eklenirken bir hata oluştu!");
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
     }
	
	
	
	/*Sorgu testleri için*/
	public static void main(String[] args) {
		islemler islemler = new islemler();
		//islemler.goruntule();
		//islemler.RastgeleOnBilgi(2);
		//islemler.BilgiAciklamasi(2);
		//String sonuc= islemler.kullanicikontrol("YigitG", "12345sj");
		//System.out.println(sonuc);
		
		//haberkayit("1", "5");
		
	}
	
}
