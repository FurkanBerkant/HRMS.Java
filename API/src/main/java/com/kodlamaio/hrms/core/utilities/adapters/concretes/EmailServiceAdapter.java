package com.kodlamaio.hrms.core.utilities.adapters.concretes;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import com.kodlamaio.hrms.emailService.fakeEmailService.FakeEmailService;

@Service
public class EmailServiceAdapter implements EmailService{

	@Override
    public void sendMail(String email, String message) {
        FakeEmailService fakeEmailService = new FakeEmailService();
        fakeEmailService.sendMail(email, message);
    }
}
