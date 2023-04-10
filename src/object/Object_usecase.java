package object;

import java.awt.*;
import object.*;

public class Object_usecase extends Object_base{
    public Object_usecase(int width, int height){
        super(width, height);
    }

    public Object_usecase(Object_usecase b){
        super(b);
        //System.out.println("Object_usecase copied");
    }

    public void draw(Graphics g){
        g.drawOval(this.start_x, this.start_y, this.width, this.height);

        int string_width = g.getFontMetrics().stringWidth(this.name);
        int string_height = g.getFontMetrics().getAscent();
        string_width = this.start_x + (this.width-string_width)/2;
        string_height = this.start_y + string_height;
        g.drawString(this.name, string_width, string_height);

        if(this.selected){
            int port_x;
            int port_y;
            port_x = this.start_x+(this.width-this.connection_port_size)/2;
            port_y = this.start_y-this.connection_port_size;
            g.fillRect(port_x, port_y, this.connection_port_size, this.connection_port_size);
            port_x = this.start_x-this.connection_port_size;
            port_y = this.start_y+(this.height-this.connection_port_size)/2;
            g.fillRect(port_x, port_y, this.connection_port_size, this.connection_port_size);
            port_x = this.start_x+(this.width-this.connection_port_size)/2;
            port_y = this.start_y+this.height;
            g.fillRect(port_x, port_y, this.connection_port_size, this.connection_port_size);
            port_x = this.start_x+this.width;
            port_y = this.start_y+(this.height-this.connection_port_size)/2;
            g.fillRect(port_x, port_y, this.connection_port_size, this.connection_port_size);
        }
    }

    @Override
    public Object_usecase deepCopy(){
        return new Object_usecase(this);
    }
}