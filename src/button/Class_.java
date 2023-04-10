package button;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import object.*;
import panel.*;
import mode.*;

public class Class_ extends Button{
    public Class_(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Class_ clicked!");

        // this is old version
        /*
        Panel_canvas canvas = Panel_canvas.get_canvas();
        Object_class obj = new Object_class(100, 90);
        Mode mode = new Mode();
        mode.set_obj(obj);
        canvas.obj_btn_click(mode);
        */
        
        // this is new version
        New_canvas canvas = New_canvas.get_canvas();
        Service service = new Class_service();
        canvas.set_service(service);
    }
}