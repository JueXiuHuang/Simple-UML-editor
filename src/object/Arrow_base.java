package object;

import object.*;

public abstract class Arrow_base extends Base{
    public Arrow_base(){}

    public Arrow_base(Arrow_base b){
        super(b);
        System.out.println("Arrow_base copied");
        this.parent = b.parent;
        this.child = b.child;
        this.parent_delta_x = b.parent_delta_x;
        this.parent_delta_y = b.parent_delta_y;
        this.child_delta_x = b.child_delta_x;
        this.child_delta_y = b.child_delta_y;
    }

    public void set_parent(Object_base p, int delta_x, int delta_y){
        this.parent = p;
        this.parent_delta_x = delta_x;
        this.parent_delta_y = delta_y;
    }

    public void set_child(Object_base c, int delta_x, int delta_y){
        this.child = c;
        this.child_delta_x = delta_x;
        this.child_delta_y = delta_y;
    }

    public void set_end(int mouse_x, int mouse_y){
        this.end_x = mouse_x;
        this.end_y = mouse_y;
    }

    public void update(){
        this.start_x = this.parent.getX()+this.parent_delta_x;
        this.start_y = this.parent.getY()+this.parent_delta_y;
        if(this.child != null){
            this.end_x = this.child.getX()+this.child_delta_x;
            this.end_y = this.child.getY()+this.child_delta_y;
        }
    }

    public abstract Arrow_base deepCopy();

    public void drag(int mouse_x, int mouse_y){
        this.end_x = mouse_x;
        this.end_y = mouse_y;
    }

    protected Object_base parent;
    protected int parent_delta_x;
    protected int parent_delta_y;
    protected Object_base child;
    protected int child_delta_x;
    protected int child_delta_y;

    protected int end_x;
    protected int end_y;
}