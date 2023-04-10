package button;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import object.*;
import panel.*;
import mode.*;

public class UseCase extends Button{
    public UseCase(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("UseCase clicked!");

        // this is old version
        /*
        Panel_canvas canvas = Panel_canvas.get_canvas();
        Object_usecase obj = new Object_usecase(100, 70);
        Mode mode = new Mode();
        mode.set_obj(obj);
        canvas.obj_btn_click(mode);
        */
        
        // this is new version
        New_canvas canvas = New_canvas.get_canvas();
        Service service = new UseCase_service();
        canvas.set_service(service);
    }
}