/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    /**
     * Test of validName method, of class Player.
     */
    @Test
    public void testValidNameGood() {
        System.out.println("validNameGood");
        String name = "ThisIsAUserName";
        boolean expResult = true;
        boolean result = Player.validName(name);
        assertEquals(expResult, result);
    }
    @Test
    public void testValidNameBad() {
        System.out.println("validNameBad");
        String name = "ABC";
        boolean expResult = false;
        boolean result = Player.validName(name);
        assertEquals(expResult, result);
    }
    @Test
    public void testValidNameBoundary() {
        System.out.println("validNameBoundary");
        String name = "123456";
        boolean expResult = true;
        boolean result = Player.validName(name);
        assertEquals(expResult, result);
    }
    
}
