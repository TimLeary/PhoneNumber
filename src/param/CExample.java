/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package param;

/**
 *
 * @author David
 */
public class CExample {
    int value;
    
    int doSomething(double para1,CDummy para2){
        para1 = 0;
        para2.value = 50;
        
        return 0;
    }
}
