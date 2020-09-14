package com.yjc.impl;

import com.yjc.service.QuartzService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class QuartzServiceImpl implements QuartzService {
    @Override
    public void execute() {
//        try {
//            StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
//            Scheduler scheduler = schedulerFactory.getScheduler();
//
//            JobDetail jobDetail = JobBuilder.newJob(QuartzServiceImpl.class).withIdentity("yjc", "yjcGroup").build();
//            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("yjc", "yjcTrigger")
//                    .startAt(Date.from(LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant()))
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();
//            scheduler.scheduleJob(jobDetail, trigger);
//            scheduler.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("123");

    }
//
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("测试运行定时器");
//    }


}
