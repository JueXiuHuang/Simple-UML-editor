package ui;

import javax.swing.*;
import java.awt.*;
import button.*;
import panel.*;

import object.*;

public class UI extends JFrame{
    // constructor
    public UI(String title){
        super(title);
        this.setSize(1200, 760);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        panel_btn = new Panel_btn();
        mainContainer.add(panel_btn, BorderLayout.WEST);
        
        //panel_canvas = Panel_canvas.get_canvas();
        //mainContainer.add(panel_canvas, BorderLayout.CENTER );
        
        canvas = New_canvas.get_canvas();
        mainContainer.add(canvas, BorderLayout.CENTER );

        menu = new Menu_bar();
        mainContainer.add(menu, BorderLayout.NORTH);
        this.setVisible(true);
    }

    private Container mainContainer;
    private Panel_btn panel_btn;
    //private static Panel_canvas panel_canvas;
    private New_canvas canvas;
    private Menu_bar menu;
}