package com.hkz.yldzxz;  
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorldJob implements Job{

	public HelloWorldJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job HelloWorld!");
	}

}
