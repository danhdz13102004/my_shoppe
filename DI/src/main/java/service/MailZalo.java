package service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MailZalo implements MsgInterface{

    @Override
    public String sendEmail() {
        return "Tai khoan cua quy khach con 0đ";
    }
    @Override
    public String sendMenu() {
        return "Day la zalo";
    }
}
