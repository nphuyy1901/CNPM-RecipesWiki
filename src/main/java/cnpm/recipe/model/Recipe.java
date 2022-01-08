package cnpm.recipe.model;

import java.sql.Date;

public class Recipe {
	private int id;
	private int idUser;
	private String ten;
	private String moTa;
	private String nguyenLieu;
	private String hinhAnh;
	private int luotThich;
	private Date tgDang;
	private int tgThucHien;
	
	public Recipe(int id, int idUser, String ten, String moTa, String nguyenLieu, String hinhAnh, int luotThich,
			Date tgDang, int tgThucHien) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.ten = ten;
		this.moTa = moTa;
		this.nguyenLieu = nguyenLieu;
		this.hinhAnh = hinhAnh;
		this.luotThich = luotThich;
		this.tgDang = tgDang;
		this.tgThucHien = tgThucHien;
	}
	public Recipe() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getNguyenLieu() {
		return nguyenLieu;
	}
	public void setNguyenLieu(String nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getLuotThich() {
		return luotThich;
	}
	public void setLuotThich(int luotThich) {
		this.luotThich = luotThich;
	}
	public Date getTgDang() {
		return tgDang;
	}
	public void setTgDang(Date tgDang) {
		this.tgDang = tgDang;
	}
	public int getTgThucHien() {
		return tgThucHien;
	}
	public void setTgThucHien(int tgThucHien) {
		this.tgThucHien = tgThucHien;
	}
	
}