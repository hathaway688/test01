package demo001;

import java.util.List;

import javax.activation.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sitech.mybatis.SpringBootMybatisApplication;
import com.sitech.mybatis.controller.MusicController;
import com.sitech.mybatis.dao.Music;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootMybatisApplication.class) 
public class MyTest {
	@Autowired
	private MusicController musiccontroller;
	@Autowired
	DataSource dataSource;

    
	
	
	@Test
	public void insertTest() {
		System.out.println("asdasdasd");
        /*System.out.println(dataSource.getConnection());*/
	}
}
