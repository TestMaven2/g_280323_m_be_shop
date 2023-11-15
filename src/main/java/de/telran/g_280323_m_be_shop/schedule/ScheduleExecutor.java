package de.telran.g_280323_m_be_shop.schedule;

import de.telran.g_280323_m_be_shop.domain.entity.jpa.Task;
import de.telran.g_280323_m_be_shop.service.jpa.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableScheduling
@EnableAsync
public class ScheduleExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleExecutor.class);

    private TaskService service;

    public ScheduleExecutor(TaskService service) {
        this.service = service;
    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = service.createTask("Fixed delay task");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayLongTimeTask() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Fixed delay long time task 3000");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayLongTimeTask() {
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Fixed delay long time task 7000");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateLongTimeTask() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Fixed rate long time task 3000");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateLongTimeTask() {
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Fixed rate long time task 7000");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedRate = 5000)
//    @Async
//    public void fixedRateLongTimeAsyncTask() {
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Fixed rate long time async task 7000");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedDelay = 5000, initialDelay = 20000)
//    public void initialDelayTask() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Initial delay task");
//        LOGGER.info(task.getDescription());
//    }

    // fixedDelay = 2 часа - 7200000 -> PT02H
//    @Scheduled(fixedDelayString = "PT03S")
//    public void anotherDelayFormatTask() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Another delay format task");
//        LOGGER.info(task.getDescription());
//    }

//    @Scheduled(fixedDelayString = "${interval}")
//    public void delayInPropertyTask() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Delay in property task");
//        LOGGER.info(task.getDescription());
//    }

    // 0 15 9-17 * * MON-FRI - будет выполняться в 15 минут каждого часа с 9 до 17 по будням
    // Задача, которая будет выполняться в 27 и 52 секунды.
//    @Scheduled(cron = "${cron-interval}")
//    public void cronExpressionTask() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Task task = service.createTask("Cron expression task");
//        LOGGER.info(task.getDescription());
//    }

    public static void executeScheduledTask(Task task) {
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
        scheduler.schedule(() -> LOGGER.info(task.getDescription()),
                new CronTrigger("0,10,20,30,40,50 * * * * *"));
    }

    public static void executeScheduledTaskOnce(Task task) {
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
        Instant executionTime = Instant.now().plusSeconds(20);
        scheduler.schedule(() -> LOGGER.info(task.getDescription()),
                executionTime);
    }
}