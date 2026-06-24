//package com.bajaj.bfhl.service;
//
//public interface BfhlService {
//}

package com.bajaj.bfhl.service;

import com.bajaj.bfhl.dto.RequestDTO;
import com.bajaj.bfhl.dto.ResponseDTO;

public interface BfhlService {
    ResponseDTO processData(RequestDTO requestDTO);
}