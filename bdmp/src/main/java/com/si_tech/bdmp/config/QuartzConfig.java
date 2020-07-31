package com.si_tech.bdmp.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.si_tech.bdmp.controller.QuartzController;
import com.si_tech.bdmp.quartz.QuartzJob_1;
import com.si_tech.bdmp.quartz.QuartzJob_2;

@Configuration
public class QuartzConfig {
	String localtime1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	//jobdetail
	@Bean
	public JobDetail myJobDetail() {
		String localtime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob_1.class).withIdentity("myJob1", "myJobGroup1")
				// JobDataMap可以给任务execute传递参数
				.usingJobData("dataTime",localtime)
				.storeDurably().build();
		return jobDetail;
	}   	
	@Bean
	public JobDetail myJobDetail_2() {
		
		JobDetail jobDetail = JobBuilder.newJob(QuartzController.class).withIdentity("myJob2", "myJobGroup1")
				// JobDataMap可以给任务execute传递参数
				.usingJobData("dataTime",localtime1)
				.storeDurably().build();
		return jobDetail;
	}
	@Bean
	public JobDetail myJobDetail_3() {
		String localtime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob_2.class).withIdentity("myJob3", "myJobGroup1")
				.usingJobData("dataTime",localtime)
				.storeDurably().build();
		return jobDetail;
	}
	
	
	
	
    //trigger
	@Bean
	public Trigger myTrigger() {
		Trigger trigger = TriggerBuilder.newTrigger().forJob(myJobDetail())
				.withIdentity("myTrigger1", "myTriggerGroup1").usingJobData("job_trigger_param", "job_trigger_param1")
				.startNow()
				//.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
				.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? 2020"))
				.build();
		return trigger;
	}
	@Bean
	public Trigger myTrigger_2() {
		Trigger trigger = TriggerBuilder.newTrigger().forJob(myJobDetail_2())
				.withIdentity("myTrigger2", "myTriggerGroup1").usingJobData("job_trigger_param", "job_trigger_param1")
				.startNow()
				//.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
				.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? 2020"))
				.build();
		return trigger;
	}
	@Bean
	public Trigger myTrigger_3() {
		Trigger trigger = TriggerBuilder.newTrigger().forJob(myJobDetail_3())
				.withIdentity("myTrigger3", "myTriggerGroup1").usingJobData("job_trigger_param", "job_trigger_param1")
				.startNow()
				//.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ? 2020"))
				.build();
		return trigger;
	}
}
