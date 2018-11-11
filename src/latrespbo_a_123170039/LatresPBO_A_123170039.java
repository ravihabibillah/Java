/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latrespbo_a_123170039;

import TheController.ControllerLogin;
import TheModel.ModelLogin;
import TheView.ViewLogin;

/**
 *
 * @author DELL
 */
public class LatresPBO_A_123170039 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ViewLogin theView = new ViewLogin();
        ModelLogin theModel = new ModelLogin();
        ControllerLogin theController = new ControllerLogin(theView,theModel);
    }
    
}
