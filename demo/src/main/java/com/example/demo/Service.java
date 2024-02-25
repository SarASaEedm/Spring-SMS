/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;
    private final SmsProcessor smsProcessor;

    @Autowired
    public Service(@Qualifier("twilio") SmsSender smsSender, SmsProcessor smsProcessor) {
        this.smsSender = smsSender;
        this.smsProcessor = smsProcessor;
    }

    public void sendSms(SmsReguest smsRequest) {
        smsSender.sendSms(smsRequest);
        // Store the SMS data after sending
        storeSmsData(smsRequest.getPhoneNumber(), "+15512240006", smsRequest.getMessage());
    }

    private void storeSmsData(String toNumber, String fromNumber, String message) {
        smsProcessor.storeSmsData(toNumber, fromNumber, message);
    }
}
