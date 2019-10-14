import javax.swing.JOptionPane;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class UserGUI {

    public static void main(String[] args) {



        Client user01 = new Client();

        user01.setPassword("OwO");
        user01.setUsername("juan");


        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Log in", "Register"};
        String initialSelection = "Log in";
        Object selection = JOptionPane.showInputDialog(null, "What do you want to do?",
                "Menu", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);

        if(selection == "Log in"){
        String SignInUsername = JOptionPane.showInputDialog("Nickname");

        if (SignInUsername.equals(user01.getUsername())) {

            String SignInPassword = JOptionPane.showInputDialog("Password");

            if(SignInUsername.equals(user01.getUsername()) && SignInPassword.equals(user01.getPassword())){

            JOptionPane.showMessageDialog(null, "Successfully Logged in", "Main Menu", JOptionPane.PLAIN_MESSAGE);
        } else {
                JOptionPane.showMessageDialog(null, "Please, try again.", "Main Menu", JOptionPane.PLAIN_MESSAGE);}
        } else {
            JOptionPane.showMessageDialog(null, "Please, try again.", "Main Menu", JOptionPane.PLAIN_MESSAGE);
        }
    } else {
            JOptionPane.showMessageDialog(null, "Please, try again.", "Main Menu", JOptionPane.PLAIN_MESSAGE);}
        }
}
