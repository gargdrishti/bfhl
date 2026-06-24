//package com.bajaj.bfhl.controller;
//
//public class BfhlController {
//}
package com.bajaj.bfhl.controller;

import com.bajaj.bfhl.dto.RequestDTO;
import com.bajaj.bfhl.dto.ResponseDTO;
import com.bajaj.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @PostMapping
    public ResponseEntity<ResponseDTO> processData(@RequestBody RequestDTO request) {
        ResponseDTO response = bfhlService.processData(request);
        return ResponseEntity.ok(response);
    }
}
