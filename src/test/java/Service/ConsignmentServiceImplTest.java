package Service;

import com.example.demo.service.ConsignmentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsignmentServiceImplTest {

    @Test
    public void consignmentNoteNumberGeneratorTest(){

        ConsignmentServiceImpl cont= new ConsignmentServiceImpl();

        String prefix="FMCC";
        String accountNumber="ABCD9876";
        int  digits= 10;
        int lastUsedIndex=19604;
        int rangeStart=19000;
        int rangeEnd=20000;

        String result = cont.consignmentNoteNumberGenerator( prefix, accountNumber, digits,lastUsedIndex,rangeStart, rangeEnd);

        assertEquals(result, "FMCCABCD987600000196051");
    }

    @Test
    public void digitNot10Test(){

        ConsignmentServiceImpl cont= new ConsignmentServiceImpl();

        String prefix="FMCC";
        String accountNumber="ABCD9876";
        int  digits= 11;
        int lastUsedIndex=19604;
        int rangeStart=19000;
        int rangeEnd=20000;

        String result = cont.consignmentNoteNumberGenerator( prefix, accountNumber, digits,lastUsedIndex,rangeStart, rangeEnd);

        assertEquals(result, "FMCCABCD9876");
    }
}
