package cnpm.recipe.model;
import java.sql.Date;

public class Event {
	private int id;
	private int id_user;
	private String tenuser;
	private String ten;
	private String mota;	
	private Date tgbatdau;
	private Date tgketthuc;
	private int soluong;
	private String hinhanh;
	private String hinhanhquangcao;
	private String giaithuong;
	
	
	public Event() {}


	

	




	public Event(int id, int id_user, String tenuser, String ten, String mota, Date tgbatdau, Date tgketthuc,
			int soluong, String hinhanh, String hinhanhquangcao, String giaithuong) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.tenuser = tenuser;
		this.ten = ten;
		this.mota = mota;
		this.tgbatdau = tgbatdau;
		this.tgketthuc = tgketthuc;
		this.soluong = soluong;
		this.hinhanh = hinhanh;
		this.hinhanhquangcao = hinhanhquangcao;
		this.giaithuong = giaithuong;
	}



	

	public String getHinhanhquangcao() {
		return hinhanhquangcao;
	}









	public void setHinhanhquangcao(String hinhanhquangcao) {
		this.hinhanhquangcao = hinhanhquangcao;
	}









	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	

	public String getTenuser() {
		return tenuser;
	}




	public void setTenuser(String tenuser) {
		this.tenuser = tenuser;
	}




	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}


	public Date getTgbatdau() {
		return tgbatdau;
	}


	public void setTgbatdau(Date tgbatdau) {
		this.tgbatdau = tgbatdau;
	}


	public Date getTgketthuc() {
		return tgketthuc;
	}


	public void setTgketthuc(Date tgketthuc) {
		this.tgketthuc = tgketthuc;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public String getHinhanh() {
		return hinhanh;
	}


	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}


	public String getGiaithuong() {
		return giaithuong;
	}


	public void setGiaithuong(String giaithuong) {
		this.giaithuong = giaithuong;
	}


	
}
