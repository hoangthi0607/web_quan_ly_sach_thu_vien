package ptit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NHANVIEN {
@Id
private String MANV;
private String TENDANGNHAP;
private String TENNV;
private String MATKHAU;
private String SDT;
private String DIACHI;
private int TUOI;
private String CMND;
private String GIOITINH;
public String getMANV() {
	return MANV;
}
public void setMANV(String mANV) {
	MANV = mANV;
}
public String getTENDANGNHAP() {
	return TENDANGNHAP;
}
public void setTENDANGNHAP(String tENDANGNHAP) {
	TENDANGNHAP = tENDANGNHAP;
}
public String getTENNV() {
	return TENNV;
}
public void setTENNV(String tENNV) {
	TENNV = tENNV;
}
public String getMATKHAU() {
	return MATKHAU;
}
public void setMATKHAU(String mATKHAU) {
	MATKHAU = mATKHAU;
}
public String getSDT() {
	return SDT;
}
public void setSDT(String sDT) {
	SDT = sDT;
}
public String getDIACHI() {
	return DIACHI;
}
public void setDIACHI(String dIACHI) {
	DIACHI = dIACHI;
}
public int getTUOI() {
	return TUOI;
}
public void setTUOI(int tUOI) {
	TUOI = tUOI;
}
public String getCMND() {
	return CMND;
}
public void setCMND(String cMND) {
	CMND = cMND;
}
public String getGIOITINH() {
	return GIOITINH;
}
public void setGIOITINH(String gIOITINH) {
	GIOITINH = gIOITINH;
}
public NHANVIEN(String mANV, String tENDANGNHAP, String tENNV, String mATKHAU, String sDT, String dIACHI, int tUOI,
		String cMND, String gIOITINH) {
	super();
	MANV = mANV;
	TENDANGNHAP = tENDANGNHAP;
	TENNV = tENNV;
	MATKHAU = mATKHAU;
	SDT = sDT;
	DIACHI = dIACHI;
	TUOI = tUOI;
	CMND = cMND;
	GIOITINH = gIOITINH;
}

}
