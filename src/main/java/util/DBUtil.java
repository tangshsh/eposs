package util;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.dbcp.BasicDataSource;
//������
public class DBUtil {
	private static BasicDataSource ds;
	static{
		//���ز���
		Properties p=new Properties();
		
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//��ȡ����
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initSize = p.getProperty("init_size");
			String maxSize = p.getProperty("max_size");
			//�������ӳ�
			ds = new BasicDataSource();
			//���ò���
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(Integer.parseInt(initSize));
			ds.setMaxActive(Integer.parseInt(maxSize));
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����db.properties�ļ�ʧ��",e);
			
		}
	}
	/**
	 * �����ӳش��������ӣ���ʵ���������ӳ��ṩ
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	/**
	 * ���ӳ��ṩ��ʵ���࣬��close�����ڲ��߼���
	 * �����ӹ黹�����ӳأ��������������ʱ=�����е����ݣ�
	 * ���ҽ����ӱ��Ϊ����״̬��
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�黹����ʧ��",e);
			}
		}
	}
	public static void roolback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ع�����ʧ��.",e);
			}
		}else{
			System.out.println("��������һ���մ�");
		}
	}

}
