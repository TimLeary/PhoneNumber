/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumber.controller;
import java.awt.event.*;
/**
 *
 * @author David
 */
public class StartController implements ActionListener{
    public void actionPerformed(ActionEvent e){
        java.awt.Toolkit.getDefaultToolkit().beep();
    }
}
