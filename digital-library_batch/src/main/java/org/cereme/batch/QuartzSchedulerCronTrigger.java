package org.cereme.batch;

import org.quartz.*;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;


public class QuartzSchedulerCronTrigger implements ILatch {
	private CountDownLatch latch = new CountDownLatch(1);
	public static void main(String[] args) throws Exception {	
		QuartzSchedulerCronTrigger quartzSchedulerExample = new QuartzSchedulerCronTrigger();
		quartzSchedulerExample.fireJob();
	}
	
	public void fireJob() throws SchedulerException, InterruptedException {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		Scheduler scheduler = schedFact.getScheduler();
		scheduler.getListenerManager().addSchedulerListener(new MySchedulerListener(scheduler));
		scheduler.start();
		
		// define the job and tie it to our HelloJob class
		JobBuilder jobBuilder = JobBuilder.newJob(MyJob.class);
		JobDataMap data = new JobDataMap();
		data.put("latch", this);
		
		JobDetail jobDetail = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerListener")
				.usingJobData(data)
				.withIdentity("myJob", "group1")
				.build();
		
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int min = rightNow.get(Calendar.MINUTE);
		
		System.out.println("Current time: " + new Date());
		
		// Fire at curent time + 1 min every day
		Trigger trigger = TriggerBuilder.newTrigger()
		.withIdentity("myTrigger", "group1")
		.startAt(DateBuilder.todayAt(07, 49, 20))
		.withSchedule(CronScheduleBuilder.cronSchedule("0 " + (min + 1) + " " + hour + " * * ? *"))		
		.build();
		
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail, trigger);
		latch.await();
		System.out.println("All triggers executed. Shutdown scheduler");
		scheduler.shutdown();
	}
	
	public void countDown() {
		latch.countDown();
	}
}
