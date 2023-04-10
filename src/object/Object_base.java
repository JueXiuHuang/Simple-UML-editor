package object;

import java.awt.*;
import java.util.*;

public abstract class Object_base extends Base{
    public Object_base(int width, int height){
        this.height = height;
        this.width = width;
    }

    public Object_base(Object_base b){
        super(b);
        //System.out.println("Object_base copied");
        this.height = b.height;
        this.width = b.width;
    }

    public boolean inRange(int topLeft_x, int topLeft_y, int delta_x, int delta_y){
        if(this.start_x>=topLeft_x && this.start_x+this.width<=topLeft_x+delta_x
            && this.start_y>=topLeft_y && this.start_y+this.height<=topLeft_y+delta_y){
                return true;
            }else{
                return false;
            }
    }

    public boolean contains(int mouse_x, int mouse_y){
        if(mouse_x>=this.start_x && mouse_x<=this.start_x+this.width 
            && mouse_y>=this.start_y && mouse_y<=this.start_y+this.height){
                return true;
            }else{
                return false;
            }
    }

    //a = (y1-y2)/(x1-x2)
    //b = (x1y2-y1x2)/(x1-x2)
    public boolean line_slash(int mouse_x, int mouse_y){
        int x1 = start_x+width;
        int y1 = start_y;
        int x2 = start_x;
        int y2 = start_y+height;
        if((y1-y2)*mouse_x+(x2-x1)*mouse_y+x1*y2-x2*y1 >= 0){
            // at left hand side
            return true;
        } else{
            // at right hand side
            return false;
        }
    }

    //a = (y1-y2)/(x1-x2)
    //b = (x1y2-y1x2)/(x1-x2)
    public boolean line_backslash(int mouse_x, int mouse_y){
        int x1 = start_x;
        int y1 = start_y;
        int x2 = start_x+width;
        int y2 = start_y+height;

        if((y1-y2)*mouse_x+(x2-x1)*mouse_y+x1*y2-x2*y1 >= 0){
            // at left hand side
            return true;
        } else{
            // at right hand side
            return false;
        }
    }

    public int getH(){
        return this.height;
    }

    public int getW(){
        return this.width;
    }

    public void drag(int delta_x, int delta_y){
        set_pos(start_x+delta_x, start_y+delta_y);
    }

    public void change_name(String name){
        this.name = name;
    }

    public void set_selected(boolean status){
        this.selected = status;
    }

    public Object get_group_id(){
        return group_id.peek();
    }

    public void add_group(double id){
        group_id.push(id);
    }

    public void remove_group(){
        group_id.pop();
    }

    public boolean in_group(){
        return !group_id.empty();
    }

    public abstract Object_base deepCopy();

    protected String name = "";
    protected int height;
    protected int width;
    protected Stack group_id = new Stack();
    protected boolean selected = false;
    protected int connection_port_size = 10;
}