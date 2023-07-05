package com.solvd.block3.utilities;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	private final static String MYBATIS_CONFIG = "mybatis/mybatis_config.xml";

	public static SqlSession openSession() {
		try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
			return session;
		} catch (IOException e) {
			throw new RuntimeException("Unable to create session");
		}
	}
}
