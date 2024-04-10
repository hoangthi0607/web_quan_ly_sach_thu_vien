package ptit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SACH {
@Id
private String MASACH;
private String TENSACH;
private String SOTRANG;
private String NGONNGU;
private String SOLUONGTON;
public String getMASACH() {
	return MASACH;
}
public void setMASACH(String mASACH) {
	MASACH = mASACH;
}
public String getTENSACH() {
	return TENSACH;
}
public void setTENSACH(String tENSACH) {
	TENSACH = tENSACH;
}
public String getSOTRANG() {
	return SOTRANG;
}
public void setSOTRANG(String sOTRANG) {
	SOTRANG = sOTRANG;
}
public String getNGONNGU() {
	return NGONNGU;
}
public void setNGONNGU(String nGONNGU) {
	NGONNGU = nGONNGU;
}
public String getSOLUONGTON() {
	return SOLUONGTON;
}
public void setSOLUONGTON(String sOLUONGTON) {
	SOLUONGTON = sOLUONGTON;
}
public NHA_XB getNHA_XB() {
	return NHA_XB;
}
public void setNHA_XB(NHA_XB nHA_XB) {
	NHA_XB = nHA_XB;
}

public THELOAI getTHELOAI() {
	return THELOAI;
}
public void setTHELOAI(THELOAI tHELOAI) {
	THELOAI = tHELOAI;
}
@ManyToOne
@JoinColumn(name="MANXB")
private NHA_XB NHA_XB;
@ManyToOne
@JoinColumn(name="MATL")
private THELOAI THELOAI;
}
