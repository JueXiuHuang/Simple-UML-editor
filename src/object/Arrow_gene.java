package object;

import object.*;
import java.awt.*;
import java.lang.*;

public class Arrow_gene extends Arrow_base{
    public Arrow_gene(){
    }

    public Arrow_gene(Arrow_gene b){
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
        /*
        double line_length = Math.sqrt(Double.valueOf((this.start_x-this.end_x)*(this.start_x-this.end_x)
            +(this.start_y-this.end_y)*(this.start_y-this.end_y)));
        double vec_x = Double.valueOf(this.start_x-this.end_x)/line_length*25;
        double vec_y = Double.valueOf(this.start_y-this.end_y)/line_length*25;
        double angle = 30;
        double p1_x = vec_x*Math.cos(-1*angle)-vec_y*Math.sin(-1*angle);
        double p1_y = vec_x*Math.sin(-1*angle)+vec_y*Math.cos(-1*angle);
        double p2_x = vec_x*Math.cos(angle)-vec_y*Math.sin(angle);
        double p2_y = vec_x*Math.sin(angle)+vec_y*Math.cos(angle);
        */

        int[] x = {end_x, (int)p1_x+this.end_x, (int)p2_x+this.end_x};
        int[] y = {end_y, (int)p1_y+this.end_y, (int)p2_y+this.end_y};

        g.fillPolygon(x, y, 3);
        //g.drawLine((int)p2_x+this.end_x, (int)p2_y+this.end_y, this.end_x, this.end_y);
    }

    @Override
    public Arrow_gene deepCopy(){
        return new Arrow_gene(this);
    }
}