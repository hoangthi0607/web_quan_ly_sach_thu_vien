package ptit.DAO.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ptit.DAO.ILoginDAO;
@Repository
public class LoginDAOimpl implements ILoginDAO {
@Autowired(required=true)
JdbcTemplate jdbcTemplate;
	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		int Count=jdbcTemplate.queryForObject("select count(*) from NHANVIEN where TENDANGNHAP=? and MATKHAU=?",Integer.class,username,password);
		if(Count==1)return true;
		else
		return false;
	}

}
