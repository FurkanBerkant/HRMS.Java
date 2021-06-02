package com.kodlamaio.hrms.emailService.fakeEmailService;

public class FakeEmailService {


    public void sendMail(String email, String message){
        System.out.println("Mail sent to: " + email + "\n" + "Message: " + message);
    }

    }
