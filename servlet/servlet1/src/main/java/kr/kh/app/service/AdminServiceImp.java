package kr.kh.app.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;

public class AdminServiceImp implements AdminService {

	private PostDAO postDao;

	public AdminServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertCommunity(String coName) {

		if (coName == null || coName.trim().length() == 0) {
			return false;
		}
		try {
			
			return postDao.insertCommunity(coName);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}