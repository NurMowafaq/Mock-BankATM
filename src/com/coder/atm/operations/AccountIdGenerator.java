/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coder.atm.operations;

import java.util.Random;

/**
 *
 * @author MacbookPro
 */
public class AccountIdGenerator {
    
    public String generateId() {
        
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        
        int dashCount = 0;
        
        for(int i=1; i < 17; i++) {
            int num = random.nextInt(10);
            builder.append(num);
            if(i % 4 == 0 && dashCount != 3) {
                builder.append("-");
                dashCount++;
            }
                
        }
        return builder.toString();
    }
}
