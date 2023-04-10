package mode;

import object.*;

public class Mode{
    public void Mode(){
        obj = null;
        arrow = null;
    }

    public Object_base get_obj(){
        return this.obj;
    }

    public void set_obj(Object_base obj){
        this.obj = obj;
    }

    public Arrow_base get_arrow(){
        return this.arrow;
    }

    public void set_arrow(Arrow_base arrow){
        this.arrow = arrow;
    }
    
    private Object_base obj;
    private Arrow_base arrow;
}