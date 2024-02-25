/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author engsa
 */
@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
    private final TwilioConfig twilioconfig;
    public TwilioSmsSender(TwilioConfig twilioconfig) {
        this.twilioconfig = twilioconfig;
    }

    @Override
    public void sendSms(SmsReguest smsReguest) {
     //   if (isPhoneNumberValid(smsReguest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsReguest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioconfig.getTrailNumber());
            String message = smsReguest.getMessage();
            MessageCreator creator = Message.creator(to,from,message);
     try {
            // Send the SMS message
            creator.create();
            LOGGER.info("SMS sent: {}", smsReguest);
        } catch (Exception e) {
            LOGGER.error("Error sending SMS: {}", e.getMessage());
    
        }
 
    }

}
