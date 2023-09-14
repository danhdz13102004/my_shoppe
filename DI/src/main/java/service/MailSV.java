package service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import service.MsgInterface;

@Component
@Primary
public class MailSV implements MsgInterface {
    @PostConstruct
    public void init() {
        System.out.println("CT run sau khi chay");
    }
    @PreDestroy
    public void end() {
        System.out.println("CT run truoc khi bi huy");
    }
    @Override
    public String sendEmail() {
        return "loading 99";
    };

    public String sendMenu() {return "món ngon rất tuyệt";}
}
