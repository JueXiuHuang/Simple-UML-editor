package object;

import java.awt.*;
import object.*;

public class Object_class extends Object_base{
    public Object_class(int width, int height){
        super(width, height);
        this.small_height = height/3;
    }

    public Object_class(Object_class b){
        super(b);
        System.out.println("Object_class copied");
        this.second_y = b.second_y;
        this.third_y = b.third_y;
        this.small_height = b.small_height;
    }

    public void draw(Graphics g){
        second_y = start_y + this.small_height;
        third_y = start_y + this.small_height*2;
        g.drawRect(this.start_x, this.start_y, this.width, this.small_height);
        g.drawRect(this.start_x, this.second_y, this.width, this.small_height);
        g.drawRect(this.start_x, this.third_y, this.width, this.small_height);
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
    public Object_class deepCopy(){
        return new Object_class(this);
    }

    private int second_y;
    private int third_y;
    private int small_height;
}