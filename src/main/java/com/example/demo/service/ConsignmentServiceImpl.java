package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ConsignmentServiceImpl {
    public String consignmentNoteNumberGenerator (String prefix, String accountNumber,  int  digits, int lastUsedIndex, int rangeStart, int rangeEnd) {

        String resValue = "";
        resValue = resValue + prefix+accountNumber;


        String zeroNumber = "00000";

        if(digits == 10) {

            //Validate the range
            if(lastUsedIndex >= rangeStart && lastUsedIndex <= rangeEnd) {
                lastUsedIndex = lastUsedIndex+1;
                zeroNumber = zeroNumber + lastUsedIndex;


                //  ..................calculation of the checksum..........................

                String first = "";
                String second = "";
                int lenValue = zeroNumber.length();
                for(int i = lenValue-1; i >= 0; i--) {
                    if(i % 2 == 0) {
                        second = second + zeroNumber.charAt(i);
                    }
                    else {
                        first = first + zeroNumber.charAt(i);
                    }

                }


                int firstNumber  = Integer.parseInt(first);

                int secoundNumber = Integer.parseInt(second);
                int rem1 = 0, sum1 = 0, sum2 = 0, rem2 = 0;

                while(firstNumber != 0 ){

                    rem1 = firstNumber % 10;
                    sum1 = sum1 + rem1;
                    firstNumber = firstNumber / 10;
                }

                while(secoundNumber != 0 ){
                    rem2 = secoundNumber % 10;
                    sum2 = sum2 + rem2;
                    secoundNumber = secoundNumber / 10;
                }

                int multi3Number = sum1 * 3;
                int multi7Number = sum2 * 7;

                int sumOfMulti3NumberMulti7Number = multi3Number+multi7Number;

                int rem3 = sumOfMulti3NumberMulti7Number % 10;
                int checksum = 10 - rem3;

                zeroNumber = zeroNumber + checksum;
                resValue = resValue + zeroNumber;
            }

        }

        return resValue;
    }
}
