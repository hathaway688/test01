package com.si_tech.bdmp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootTest
@EnableScheduling
public class QuartzTest {

	/*@Test
	public void timeTest() {
		Timer timer =new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 System.out.println("TimerTask1 run" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			}
		},5000);//延时1s，之后每隔5s运行一次
		//System.out.println("TimerTask1 run" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}*/
	
	@Test
	@Scheduled(cron = "1/5 * * * * ?" )
	public void timeTest2() {
		 System.out.println("springScheduled run:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));	
	}
	
}
