package test;

import org.junit.Before;
import org.junit.Test;

import dao.Dao;
import entity.YdManager;
import entity.YdUse;

public class TestCase {
	private Dao dao;
	@Before
	public void init(){
		dao = new Dao();
	}
	@Test
	public void test(){
		YdManager yd = dao.FindManager("admin");
		System.out.println(yd);
	}

}
