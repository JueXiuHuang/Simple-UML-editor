package button;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import object.*;
import panel.*;
import mode.*;

public class Select extends Button{
    public Select(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Select clicked!");

        // this is old version
        /*
        Panel_canvas canvas = Panel_canvas.get_canvas();
        Mode mode = new Mode();
        canvas.obj_btn_click(mode);
        */
        
        // this is new version
        New_canvas canvas = New_canvas.get_canvas();
        Service service = new Select_service();
        canvas.set_service(service);
    }
}