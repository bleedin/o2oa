package com.x.okr.assemble.control.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.okr.assemble.control.service.ExcuteWorkReportCreateService;

/**
 * 定时代理，定时对需要汇报的工作发起工作汇报拟稿的待办
 * 
 * @author LIYI
 *
 */
public class WorkReportCreate implements Job {

	private static Logger logger = LoggerFactory.getLogger(ExcuteWorkReportCreateService.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			new ExcuteWorkReportCreateService().execute();
			logger.info("Timertask WorkReportCreate completed and excute success.");
		} catch (Exception e) {
			logger.error(e);
			throw new JobExecutionException(e);
		}

	}

}