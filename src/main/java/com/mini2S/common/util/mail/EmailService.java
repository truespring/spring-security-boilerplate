package com.mini2S.common.util.mail;

public interface EmailService {
    void sendEmail(String toAddress, String subject, String body);
}
