package ptit.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NHA_XB {
@Id
private String MANXB;
private String DIACHI;
private String SDT;
private String TEN;
public String getMANXB() {
	return MANXB;
}
public void setMANXB(String mANXB) {
	MANXB = mANXB;
}
public String getDIACHI() {
	return DIACHI;
}
public void setDIACHI(String dIACHI) {
	DIACHI = dIACHI;
}
public String getSDT() {
	return SDT;
}
public void setSDT(String sDT) {
	SDT = sDT;
}
public String getTEN() {
	return TEN;
}
public void setTEN(String tEN) {
	TEN = tEN;
}
@OneToMany(mappedBy="NHA_XB",fetch=FetchType.EAGER)
private Collection<SACH> SACHS;
public Collection<SACH> getSACHS() {
	return SACHS;
}
public void setSACHS(Collection<SACH> sACHS) {
	SACHS = sACHS;
}
}
