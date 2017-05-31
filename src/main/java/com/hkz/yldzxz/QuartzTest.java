package com.hkz.yldzxz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String[] args) {

		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();	
			//创建任务 
			JobDetail job = JobBuilder.newJob(HelloWorldJob.class).withIdentity("myJob", "group").build();
			//创建任务触发器 设置任务条件：立刻开始任务，每两秒执行一次，永远执行
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group").startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
					.build();
			//绑定
			scheduler.scheduleJob(job, trigger);
			//开始启动任务
			scheduler.start();
			//休眠10s
			Thread.sleep(10000);
			//结束任务
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
