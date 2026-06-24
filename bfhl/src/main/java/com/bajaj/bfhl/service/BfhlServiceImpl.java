//package com.bajaj.bfhl.service;
//
//public class BfhlServiceImpl {
//}

package com.bajaj.bfhl.service;

import com.bajaj.bfhl.dto.RequestDTO;
import com.bajaj.bfhl.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BfhlServiceImpl implements BfhlService {

    // ✏️ CHANGE THESE TO YOUR DETAILS
    private static final String FULL_NAME = "Drishti_Garg";       // e.g. "john_doe"
    private static final String DOB       = "22082005";        // e.g. "17091999"
    private static final String EMAIL     = "drishti0330.be23@chitkara.edu.in";
    private static final String ROLL      = "2310990330";

    @Override
    public ResponseDTO processData(RequestDTO request) {
        List<String> data = request.getData();

        List<String> oddNumbers      = new ArrayList<>();
        List<String> evenNumbers     = new ArrayList<>();
        List<String> alphabets       = new ArrayList<>();
        List<String> specialChars    = new ArrayList<>();
        long sum = 0;
        StringBuilder alphabetChain = new StringBuilder();

        for (String item : data) {
            if (isNumber(item)) {
                long num = Long.parseLong(item);
                sum += num;
                if (num % 2 == 0) evenNumbers.add(item);
                else              oddNumbers.add(item);
            } else if (isAlphabet(item)) {
                alphabets.add(item.toUpperCase());
                // collect every character (for multi-char strings like "ABCD")
                for (char c : item.toCharArray()) {
                    alphabetChain.append(c);
                }
            } else {
                specialChars.add(item);
            }
        }

        // Build concat_string: reverse all alphabet chars, alternating caps
        String reversed = alphabetChain.reverse().toString();
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            concat.append(i % 2 == 0 ? Character.toUpperCase(c)
                    : Character.toLowerCase(c));
        }

        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setUserId(FULL_NAME + "_" + DOB);
        response.setEmail(EMAIL);
        response.setRollNumber(ROLL);
        response.setOddNumbers(oddNumbers);
        response.setEvenNumbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecialCharacters(specialChars);
        response.setSum(String.valueOf(sum));
        response.setConcatString(concat.toString());

        return response;
    }

    private boolean isNumber(String s) {
        try { Long.parseLong(s); return true; }
        catch (NumberFormatException e) { return false; }
    }

    private boolean isAlphabet(String s) {
        return s.chars().allMatch(Character::isLetter);
    }
}