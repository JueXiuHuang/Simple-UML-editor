package object;

import java.awt.*;

public abstract class Base{
    public Base(){}
    public Base(Base b){
        System.out.println("Base copied");
        this.start_x = b.start_x;
        this.start_y = b.start_y;
    }

    public void set_pos(int x, int y){
        this.start_x = x;
        this.start_y = y;
    }

    public int getX(){
        return start_x;
    }

    public int getY(){
        return start_y;
    }

    public void set_depth(int d){
        this.depth = d;
    }

    public abstract void draw(Graphics g);
    public abstract void drag(int delta_x, int delta_y);

    protected int start_x, start_y;
    protected int depth;
}