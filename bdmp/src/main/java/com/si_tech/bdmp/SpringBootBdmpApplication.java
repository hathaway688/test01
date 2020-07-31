package com.si_tech.bdmp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.si_tech.bdmp.mapper")
public class SpringBootBdmpApplication {
   public static void main(String[] args) {
	   SpringApplication.run(SpringBootBdmpApplication.class, args);
/*	   Timer timer =new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				 System.out.println("TimerTask1 run" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			}
		},1000,5000);//延迟1s执行，之后每隔5s运行一次
*/		
/*	   ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5);
	   executorService.scheduleWithFixedDelay(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
             System.out.println("ScheduledThreadPoolExecutor1 run:"+now);
		}
	},1,2,TimeUnit.SECONDS);*/	   
   }
   
	/*@Scheduled(cron = "1/5 * * * * ?" )
	public void timeTest2() {
		 System.out.println("springScheduled run:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));	
	}*/  
}
