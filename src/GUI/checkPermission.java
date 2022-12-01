/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GUI;

import java.awt.Component;
import javax.swing.JOptionPane;


public interface checkPermission {
    default void hienThiErrorMess(){    // cast cho component invoke method nay
        JOptionPane.showMessageDialog( (Component)this, "Bạn không có quyền sử dụng chức năng này!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
