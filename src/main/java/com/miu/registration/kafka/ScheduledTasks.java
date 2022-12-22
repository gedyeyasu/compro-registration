package com.miu.registration.kafka;
import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.domain.RegistrationGroup;
import com.miu.registration.domain.Student;
import com.miu.registration.service.Impl.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private  RegistrationEventService registrationEventService;

    @Value("${topic}")
    private String topic;

    @Autowired
    private EmailPublisher emailPublisher;

    //cron task that runs once every day and checks if reminder should be sent
    //run a task every day at 12:00 AM (midnight), "run at the 0th minute of the 0th hour every day".
    @Scheduled(cron = "0 16,20 0 * * *")
    //@Scheduled(cron = "0 */2 * ? * *")
    public void runTaskBasedOnRegistrationEndDate() {
//        emailPublisher.publish(topic,new EmailMessage("teddymeselu@gmail.com", "Please Update your Registration since its about to be closed","Course Registration is about to be Expired!"));
//    }
        List<RegistrationEvent> registrationEvents = registrationEventService.getAllRegistrationEvent();
        for(RegistrationEvent registrationEvent: registrationEvents){
            LocalDate endDate = registrationEvent.getEndDate();
            if(endDate.isEqual(LocalDate.now())){
                    for(RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroups()){
                        for(Student student: registrationGroup.getStudents()){
                                emailPublisher.publish(topic,new EmailMessage(student.getEmail(), "Please Update your Registration since its about to be closed","Course Registration is about to be Expired!"));
                        }
                    }

            }
        }
    }
}
