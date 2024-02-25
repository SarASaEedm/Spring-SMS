/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;


/**
 *
 * @author engsa
 */
class SmsReguest {

    @NotBlank
    private static String phoneNumber; //destination
    @NotBlank
    private static String message;

    SmsReguest(@JsonProperty("phoneNumber") String phoneNumber, 
            @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

  public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsReguest{" + "phoneNumber=" + phoneNumber + ", message=" + message + '}';
    }

}
