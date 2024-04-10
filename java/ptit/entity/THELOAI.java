package ptit.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class THELOAI {
@Id
private String MATL;
private String TENTL;
public String getMATL() {
	return MATL;
}
public void setMATL(String mATL) {
	MATL = mATL;
}
public String getTENTL() {
	return TENTL;
}
public void setTENTL(String tENTL) {
	TENTL = tENTL;
}
@OneToMany(mappedBy="THELOAI",fetch=FetchType.EAGER)
private Collection<SACH> SACHS;
public Collection<SACH> getSACHS() {
	return SACHS;
}
public void setSACHS(Collection<SACH> sACHS) {
	SACHS = sACHS;
}
}
