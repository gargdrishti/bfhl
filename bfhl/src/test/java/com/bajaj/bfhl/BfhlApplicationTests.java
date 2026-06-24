//package com.bajaj.bfhl;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class BfhlApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
package com.bajaj.bfhl;

import com.bajaj.bfhl.dto.RequestDTO;
import com.bajaj.bfhl.dto.ResponseDTO;
import com.bajaj.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class BfhlApplicationTests {

    private final BfhlServiceImpl service = new BfhlServiceImpl();

    @Test
    public void testExampleA() {
        RequestDTO req = new RequestDTO();
        req.setData(Arrays.asList("a", "1", "334", "4", "R", "$"));

        ResponseDTO res = service.processData(req);

        assertTrue(res.isSuccess());
        assertEquals(Arrays.asList("1"), res.getOddNumbers());
        assertEquals(Arrays.asList("334", "4"), res.getEvenNumbers());
        assertEquals(Arrays.asList("A", "R"), res.getAlphabets());
        assertEquals(Arrays.asList("$"), res.getSpecialCharacters());
        assertEquals("339", res.getSum());
        assertEquals("Ra", res.getConcatString());
    }

    @Test
    public void testEmptyNumbers() {
        RequestDTO req = new RequestDTO();
        req.setData(Arrays.asList("A", "ABCD", "DOE"));

        ResponseDTO res = service.processData(req);
        assertEquals("0", res.getSum());
        assertEquals("EoDdCbAa", res.getConcatString());
    }
}