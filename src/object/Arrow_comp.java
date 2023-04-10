package object;

import object.*;
import java.awt.*;

public class Arrow_comp extends Arrow_base{
    public Arrow_comp(){
    }

    public Arrow_comp(Arrow_comp b){
    }

    public void draw(Graphics g){
        this.update();
        g.drawLine(this.start_x, this.start_y, this.end_x, this.end_y);
        int circle_rad = 12;
        g.drawOval(this.end_x-(circle_rad/2), this.end_y-(circle_rad/2), circle_rad, circle_rad);
        //g.setColor(Color.CYAN);
        g.fillOval(this.end_x-(circle_rad/2), this.end_y-(circle_rad/2), circle_rad, circle_rad);
    }

    @Override
    public Arrow_comp deepCopy(){
        return new Arrow_comp(this);
    }

}