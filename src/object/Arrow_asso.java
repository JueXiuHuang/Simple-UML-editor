package object;

import object.*;
import java.awt.*;
import java.lang.*;

public class Arrow_asso extends Arrow_base{
    public Arrow_asso(){
    }

    public Arrow_asso(Arrow_asso b){
    }

    public void draw(Graphics g){
        this.update();
        g.drawLine(this.start_x, this.start_y, this.end_x, this.end_y);
        double line_length = 25.0;
        double ang = 15+180;
        double px = Double.valueOf(this.start_x-this.end_x);
        double py = Double.valueOf(this.start_y-this.end_y);
        double d = Math.sqrt(px*px+py*py);
        double p1_x = px*Math.cos(ang) - py*Math.sin(ang);
        double p1_y = px*Math.sin(ang) + py*Math.cos(ang);
        p1_x = p1_x/d*line_length;
        p1_y = p1_y/d*line_length;

        double p2_x = px*Math.cos(-1*ang) - py*Math.sin(-1*ang);
        double p2_y = px*Math.sin(-1*ang) + py*Math.cos(-1*ang);
        p2_x = p2_x/d*line_length;
        p2_y = p2_y/d*line_length;
        
        g.drawLine((int)p1_x+this.end_x, (int)p1_y+this.end_y, this.end_x, this.end_y);
        g.drawLine((int)p2_x+this.end_x, (int)p2_y+this.end_y, this.end_x, this.end_y);
    }

    @Override
    public Arrow_asso deepCopy(){
        return new Arrow_asso(this);
    }
}