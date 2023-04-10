package panel;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.*;
import java.awt.event.*;
import object.*;
import mode.*;

public class Panel_canvas extends JPanel implements MouseListener, MouseMotionListener{
    private static Panel_canvas instance = null;
    private static ArrayList<Object_base> item_lists = new ArrayList<Object_base>();
    public ArrayList<Object_base> selected_item = new ArrayList<Object_base>();
    private ArrayList<Arrow_base> relationship = new ArrayList<Arrow_base>();
    private ArrayList<Arrow_base> unsure_relation = new ArrayList<Arrow_base>();

    private Mode mode;

    public Random rand_gene = new Random();

    private int offset_x, offset_y;
    private int delta_x;
    private int delta_y;

    private Panel_canvas(){
        System.out.println("Panel_Canvas created");
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (Object_base item : item_lists){
            item.draw(g);
        }

        for(Arrow_base arr : unsure_relation){
            arr.draw(g);
        }

        for(Arrow_base arr : relationship){
            arr.draw(g);
        }

        int top_right_offsetX = offset_x;
        int top_right_offsetY = offset_y;
        int pos_deltax = delta_x;
        int pos_deltay = delta_y;
        if(delta_x < 0){
            top_right_offsetX = offset_x+delta_x;
            pos_deltax = pos_deltax*-1;
        }
        if(delta_y < 0){
            top_right_offsetY = top_right_offsetY+delta_y;
            pos_deltay = pos_deltay*-1;
        }
        g.drawRect(top_right_offsetX, top_right_offsetY, pos_deltax, pos_deltay);
    }

    public void addItem(Object_base obj){
        item_lists.add(obj);
        this.repaint();
    }

    public static Panel_canvas get_canvas(){
        if(instance == null){
            instance = new Panel_canvas();
        }
        
        return instance;
    }

    public void obj_btn_click(Mode mode){
        this.mode = mode;
    }

    private void set_offset(MouseEvent e){
        this.offset_x = e.getX();
        this.offset_y = e.getY();
    }

    public void change_name(String name){
        if(selected_item.size() != 0){
            selected_item.get(0).change_name(name);
        }
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(this.mode != null){
            if(this.mode.get_obj() != null){
                Object_base tempBase;
                this.mode.get_obj().set_pos(e.getX(), e.getY());
                tempBase = this.mode.get_obj().deepCopy();

                addItem(tempBase);
                System.out.println(item_lists.size());
            }else if(this.mode.get_arrow() != null){
            }else{}
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        if(this.mode != null){
            if(this.mode.get_obj()!=null){
            } else if(this.mode.get_arrow()!=null){
                
                selected_item.clear();
                for(Object_base item : item_lists){
                    if(item.contains(e.getX(), e.getY())){
                        selected_item.add(item);
                    }
                }
                if(selected_item.size()>0){
                    System.out.println("Item selected!");
                    Object_base item = selected_item.get(0);

                    this.unsure_relation.add(this.mode.get_arrow().deepCopy());
                    
                    if(item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
                        unsure_relation.get(0).set_parent(selected_item.get(0), 0, selected_item.get(0).getH()/2);
                    } else if(item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
                        unsure_relation.get(0).set_parent(selected_item.get(0), selected_item.get(0).getW()/2, 0);
                    } else if(!item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
                        unsure_relation.get(0).set_parent(selected_item.get(0), selected_item.get(0).getW()/2, selected_item.get(0).getH());
                    } else if(!item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
                        unsure_relation.get(0).set_parent(selected_item.get(0), selected_item.get(0).getW(), selected_item.get(0).getH()/2);
                    }
                }else{
                    this.unsure_relation.clear();
                }
            } else{
                set_offset(e);
                ArrayList<Object_base> temp_items = new ArrayList<Object_base>();
                for(Object_base item : item_lists){
                    if(item.contains(e.getX(), e.getY())){
                        temp_items.add(item);
                    }
                }
                System.out.println(temp_items.size());
                if(temp_items.size() == 0){
                    if(selected_item.size() != 0){
                        for(Object_base item : selected_item){
                            item.set_selected(false);
                            this.repaint();
                        }
                    }
                    selected_item.clear();
                } else{
                    if(selected_item.size() != 0){
                        for(Object_base item : selected_item){
                            item.set_selected(false);
                            this.repaint();
                        }
                        selected_item.clear();
                    }
                    if(temp_items.get(0).in_group()){
                        for(Object_base item : item_lists){
                            if(item.in_group() && item.get_group_id().equals(temp_items.get(0).get_group_id())){
                                selected_item.add(item);
                                item.set_selected(true);
                                //System.out.println("find friend!");
                                //System.out.println(selected_item.size());
                            }
                        }
                        //System.out.println(selected_item.size());
                        //System.out.println("selected item in some group");
                    } else {
                        selected_item.add(temp_items.get(0));
                        selected_item.get(0).set_selected(true);
                    }
                    this.repaint();
                }
                if(selected_item.size()>0){
                    System.out.println("Item selected!");   
                }else{
                    System.out.println("Nothing selectedQQ");
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){
        //System.out.println("released");
        if(this.mode.get_arrow()!=null && this.unsure_relation.size()!=0){
            selected_item.clear();
            for(Object_base item : item_lists){
                if(item.contains(e.getX(), e.getY())){
                    selected_item.add(item);
                }
            }
            if(selected_item.size() == 0){
                unsure_relation.clear();
                this.repaint();
            } else{
                Object_base item = selected_item.get(0);

                if(item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
                    unsure_relation.get(0).set_child(selected_item.get(0), 0, selected_item.get(0).getH()/2);
                } else if(item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
                    unsure_relation.get(0).set_child(selected_item.get(0), selected_item.get(0).getW()/2, 0);
                } else if(!item.line_slash(e.getX(), e.getY()) && item.line_backslash(e.getX(), e.getY())){
                    unsure_relation.get(0).set_child(selected_item.get(0), selected_item.get(0).getW()/2, selected_item.get(0).getH());
                } else if(!item.line_slash(e.getX(), e.getY()) && !item.line_backslash(e.getX(), e.getY())){
                    unsure_relation.get(0).set_child(selected_item.get(0), selected_item.get(0).getW(), selected_item.get(0).getH()/2);
                }

                relationship.add(unsure_relation.get(0));
                unsure_relation.clear();

                this.repaint();
            }
        } else if(this.mode.get_obj()!=null){
        } else {
            ArrayList<Object> group_list = new ArrayList<Object>();
            for(Object_base item : item_lists){
                int x_ = offset_x;
                int y_ = offset_y;
                int dx = delta_x;
                int dy = delta_y;
                if(dx<0){
                    x_ = x_+dx;
                    dx = dx*-1;
                }
                if(dy<0){
                    y_ = y_+dy;
                    dy = dy*-1;
                }
                if(item.inRange(x_, y_, dx, dy)){
                    item.set_selected(true);
                    selected_item.add(item);
                    if(item.in_group() && !group_list.contains(item.in_group())){
                        group_list.add(item.get_group_id());
                    }
                }
            }
            for(Object_base item : item_lists){
                if(item.in_group() && group_list.contains(item.get_group_id())
                    && !selected_item.contains(item)){
                        item.set_selected(true);
                        selected_item.add(item);
                }
            }
            offset_x = offset_y = delta_x = delta_y = 0;
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e){
        if(this.mode != null){
            if(this.mode.get_obj() != null){
            } else if(this.mode.get_arrow() != null){
                if(unsure_relation.size() != 0){
                    unsure_relation.get(0).set_end(e.getX(), e.getY());
                    repaint();
                }
            } else{
                if(selected_item.size() != 0){
                    delta_x = e.getX()-offset_x;
                    delta_y = e.getY()-offset_y;
                    set_offset(e);
                    for(Object_base item : selected_item){
                        item.drag(delta_x, delta_y);
                    }
                    this.repaint();
                    delta_x = 0;
                    delta_y = 0;
                } else{
                    //System.out.println("HI");
                    delta_x = e.getX()-offset_x;
                    delta_y = e.getY()-offset_y;
                    this.repaint();
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e){}
}