package com.example.demo.controller;

import com.example.demo.service.ConsignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(path = "/home")
@RestController
public class ConsignmentController {
    @Autowired
    ConsignmentServiceImpl consignmentServiceImpl;

    public final static String carrierName = "FreightmateCourierCo";
    public final static String prefix = "FMCC";
    public final static String accountNumber = "123ABC";
    public final static int digits = 10;
    public final static int lastUsedIndex = 19604;
    public final static int rangeStart = 19000;
    public final static int rangeEnd = 20000;

    @GetMapping("/result")
    public ResponseEntity<String> getConsignmentNoteNumber() {

        try {
            System.out.println("java start");
            String result = consignmentServiceImpl.consignmentNoteNumberGenerator(prefix, accountNumber, digits, lastUsedIndex, rangeStart, rangeEnd);
            System.out.println(carrierName + " consignment No is -> " + result);

            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
