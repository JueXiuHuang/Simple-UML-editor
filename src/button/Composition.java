package button;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import object.*;
import panel.*;
import mode.*;

public class Composition extends Button{
    public Composition(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Composition clicked!");

        // this is old version
        /*
        Panel_canvas canvas = Panel_canvas.get_canvas();
        Arrow_comp arr = new Arrow_comp();
        Mode mode = new Mode();
        mode.set_arrow(arr);
        canvas.obj_btn_click(mode);
        */
        
        // this is new version
        New_canvas canvas = New_canvas.get_canvas();
        Service service = new Composition_service();
        canvas.set_service(service);
    }
}