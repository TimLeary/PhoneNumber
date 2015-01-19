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
public class Param {
    public static void main(String[] args) {
        CExample hugo = new CExample();
        CDummy arrow = new CDummy();
        int result;
        
        double value = 10.5;
        
        arrow.value = 100;
        System.out.println("A paraméter hívása elött:\t" + value + "\t" + arrow.value);
        result = hugo.doSomething(value, arrow);
        System.out.println("A paraméter hívása után:\t" + value + "\t" + arrow.value);
    }
}
