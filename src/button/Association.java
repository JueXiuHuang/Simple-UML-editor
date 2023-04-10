package button;
import javax.swing.*;

import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import object.*;
import panel.*;
import mode.*;

public class Association extends Button{
    public Association(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Association clicked!");

        // this is old version
        /*
        Panel_canvas canvas = Panel_canvas.get_canvas();
        Arrow_asso arr = new Arrow_asso();
        Mode mode = new Mode();
        mode.set_arrow(arr);
        canvas.obj_btn_click(mode);
        */
        
        // this is new version
        New_canvas canvas = New_canvas.get_canvas();
        Service service = new Association_service();
        canvas.set_service(service);
    }
}