package TheController;

import TheModel.*;
import TheView.*;
import java.awt.event.*;

public class ControllerLogin {

    ViewLogin theView;
    ModelLogin theModel;

    public ControllerLogin(ViewLogin theView, ModelLogin theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addLoginListener(new LoginButtonListener());
    }

    private class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String username = theView.getUserField();
            String password = theView.getPassField();
            if ((theModel.getUsername().equals(username)) && (theModel.getPassword().equals(password))) {
                theView.displaySuccess("Login Succesful!!");
                theView.dispose();
                ViewForm view = new ViewForm();
                ModelForm model = new ModelForm();
                ControllerForm control = new ControllerForm(view,model);
            }
            else{
                theView.displayFailed("Wrong Username or Password!!");
            }
        }
    }
}
