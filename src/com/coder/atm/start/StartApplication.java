/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coder.atm.start;

import com.coder.atm.operations.MockAtm;

/**
 *
 * @author Coder ACJHP
 */
public class StartApplication {
    
    public static void main(String[] args) {
        MockAtm operations = new MockAtm();
        operations.prepareApp();
    }
}
