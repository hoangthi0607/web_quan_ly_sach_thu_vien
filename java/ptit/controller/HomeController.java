package ptit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptit.DAO.ILoginDAO;
import ptit.entity.NHANVIEN;
import ptit.entity.SACH;



@Controller
@Transactional
public class HomeController{
@Autowired(required=true)
ILoginDAO LoginDAO;
@Autowired
SessionFactory factory;
@RequestMapping("/index")
public String showForm() {
return "/index";
}
@RequestMapping("login")
public String showLogin() {
return "/login";
}
@RequestMapping(value="login",params="linklogout")
public String showLogins(HttpServletRequest request) {
	HttpSession session = request.getSession();
	session.setAttribute("username",null);
return "/index";
}
@RequestMapping("registration")
public String showRegistration() {
return "/registration";
}

@RequestMapping(value="login.htm",method=RequestMethod.POST)
public String checkuser(@RequestParam(value="username",required=false) String username,@RequestParam(value="password",required=false)String password,ModelMap model,HttpServletRequest request) {
boolean loginFlag=LoginDAO.validateUser(username,password);
if(loginFlag==false) {
	model.addAttribute("message","bạn đã nhập sai tài khoản hoặc mật khẩu");
	return "login";}
else {
	HttpSession session = request.getSession();
	session.setAttribute("username",username);
return "index";
}
}
@RequestMapping(value="Register.htm",method=RequestMethod.POST)
public String createaccount(@RequestParam(value="username",required=false) String username,@RequestParam(value="ten",required=false) String ten
                            ,@RequestParam(value="pass",required=false) String pass,@RequestParam(value="re_pass",required=false) String re_pass
                            ,@RequestParam(value="contact",required=false) String contact,@RequestParam(value="diachi",required=false) String diachi
                            ,@RequestParam(value="tuoi",required=false) String tuoi,@RequestParam(value="cmnd",required=false) String cmnd,@RequestParam(value="gioitinh",required=false) String gioitinh
                            ,ModelMap model) {
if(pass.equals(re_pass)==false) {
model.addAttribute("message","bạn đã nhập sai mật khẩu");
return "registration";
}
int tuoii=Integer.parseInt(tuoi);
Session session=factory.openSession();
Transaction t=session.beginTransaction();
try {
NHANVIEN nv=new NHANVIEN(username,username,ten,pass,contact,diachi,tuoii,cmnd,gioitinh);
session.save(nv);
t.commit();
model.addAttribute("message","bạn đã đăng ký tài khoản thành công,vui lòng đăng nhập");

}
catch(Exception e) {
t.rollback();
model.addAttribute("message",tuoii);
return "registration";
}
finally {
session.close();
}
return "login";
} 
@RequestMapping("khosach")
public String khosach(ModelMap model) {
Session session=factory.getCurrentSession();
String hql="FROM SACH";
Query query=session.createQuery(hql);
List<SACH> list=query.list();
model.addAttribute("sachs",list);
return "khosach";
}
public List<SACH> searchProducts(String product_name){
Session session =factory.getCurrentSession();
String hql="FROM SACH where TENSACH LIKE :TENSACH";
Query query=session.createQuery(hql);
query.setParameter("TENSACH","%"+product_name+"%");
List<SACH> list=query.list();
return list;
}
@RequestMapping(value="khosach",params="btnsearch")
public String searchPro(HttpServletRequest request,ModelMap model) {
List<SACH> sachs=this.searchProducts(request.getParameter("searchInput"));
model.addAttribute("sachs",sachs);
return "khosach";
}
@RequestMapping(value="insertsach",method=RequestMethod.GET)
public String insert(ModelMap model) {
model.addAttribute("sach",new SACH());
return "insertsach";
}
@RequestMapping(value="insertsach",method=RequestMethod.POST)
public String insert1(ModelMap model,@ModelAttribute("sach") SACH sach) {
Session session=factory.openSession();
Transaction t =session.beginTransaction();
try {
session.save(sach);
t.commit();
//model.addAttribute("message","Thêm mới thành công");
}
catch(Exception e) {
t.rollback();
model.addAttribute("message","Thêm mới thất bại");
return "insertsach";
}
finally {
session.close();
}
return "redirect:khosach.htm";
}
public SACH getSach(String id){
	Session session=factory.getCurrentSession();
	String hql="FROM SACH where MASACH= :id";
	Query query=session.createQuery(hql);
	query.setParameter("id",id);
	SACH list=(SACH)query.list().get(0);
	return list;
}
@RequestMapping(value="khosach/{id}.htm",params="linkEdit")
public String edit(ModelMap model,@ModelAttribute("sach") SACH sach,@PathVariable("id")String id) {
model.addAttribute("sach",this.getSach(id));
return "updatesach";
}
public Integer updateSach(SACH sach) {
Session session=factory.openSession();
Transaction t=session.beginTransaction();
try{session.update(sach);
t.commit();
}
catch(Exception e) {
t.rollback();
return 0;
}
finally {
session.close();
}
return 1;
}
@RequestMapping(value="updatesach",method=RequestMethod.POST)
public String editSach(ModelMap model,@ModelAttribute("sach")SACH sach) {
Integer temp=this.updateSach(sach);
if(temp!=0) {
model.addAttribute("message","Update thành công");}
else
model.addAttribute("message","Update thất bại");

return "updatesach";
}
public Integer deleteSach(SACH sach) {
	Session session=factory.openSession();
	Transaction t=session.beginTransaction();
	try{session.delete(sach);
	t.commit();
	}
	catch(Exception e) {
	t.rollback();
	return 0;
	}
	finally {
	session.close();
	}
	return 1;	
}
@RequestMapping(value="/khosach/{id}.htm",params="linkDelete")
public String deleteSach(ModelMap model,@ModelAttribute("sach")SACH sach,@PathVariable("id") String id) {
Integer temp=this.deleteSach(this.getSach(id));
if(temp!=0) {
model.addAttribute("message","Delete thành công");}
else {
model.addAttribute("message","Delete thất bại");
}
return "redirect:/khosach.htm";
}
}

