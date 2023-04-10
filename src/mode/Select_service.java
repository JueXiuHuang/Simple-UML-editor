package mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import object.Object_base;

public class Select_service extends Service{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int[] offsets = this.canvas.get_offset();
		int offset_x = offsets[0];
		int offset_y = offsets[1];
		if(this.canvas.selected_item.size() != 0){
			int delta_x = e.getX()-offset_x;
            int delta_y = e.getY()-offset_y;
            this.canvas.set_offset(e);
            for(Object_base item : this.canvas.selected_item){
                item.drag(delta_x, delta_y);
            }
            this.canvas.repaint();
            delta_x = 0;
            delta_y = 0;
            
        } else{
            //System.out.println("HI");
            int delta_x = e.getX()-offset_x;
            int delta_y = e.getY()-offset_y;
            int[] inputs = new int[2];
            inputs[0] = delta_x;
            inputs[1] = delta_y;
            this.canvas.set_delta(inputs);
            this.canvas.repaint();
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.canvas.set_offset(e);
        ArrayList<Object_base> temp_items = new ArrayList<Object_base>();
        for(Object_base item : this.canvas.item_lists){
            if(item.contains(e.getX(), e.getY())){
                temp_items.add(item);
            }
        }
        System.out.println(temp_items.size());
        if(temp_items.size() == 0){
            if(this.canvas.selected_item.size() != 0){
                for(Object_base item : this.canvas.selected_item){
                    item.set_selected(false);
                    this.canvas.repaint();
                }
            }
            this.canvas.selected_item.clear();
        } else{
            if(this.canvas.selected_item.size() != 0){
                for(Object_base item : this.canvas.selected_item){
                    item.set_selected(false);
                    this.canvas.repaint();
                }
                this.canvas.selected_item.clear();
            }
            if(temp_items.get(0).in_group()){
                for(Object_base item : this.canvas.item_lists){
                    if(item.in_group() && item.get_group_id().equals(temp_items.get(0).get_group_id())){
                    	this.canvas.selected_item.add(item);
                        item.set_selected(true);
                        //System.out.println("find friend!");
                        //System.out.println(selected_item.size());
                    }
                }
                //System.out.println(selected_item.size());
                //System.out.println("selected item in some group");
            } else {
            	this.canvas.selected_item.add(temp_items.get(0));
            	this.canvas.selected_item.get(0).set_selected(true);
            }
            this.canvas.repaint();
        }
        if(this.canvas.selected_item.size()>0){
            System.out.println("Item selected!");   
        }else{
            System.out.println("Nothing selectedQQ");
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ArrayList<Object> group_list = new ArrayList<Object>();
        for(Object_base item : this.canvas.item_lists){
        	int[] xy = this.canvas.get_offset();
        	int[] dxy = this.canvas.get_delta();
        	int x_ = xy[0];
        	int y_ = xy[1];
        	int dx = dxy[0];
        	int dy = dxy[1];
            
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
                this.canvas.selected_item.add(item);
                if(item.in_group() && !group_list.contains(item.in_group())){
                    group_list.add(item.get_group_id());
                }
            }
        }
        for(Object_base item : this.canvas.item_lists){
            if(item.in_group() && group_list.contains(item.get_group_id())
                && !this.canvas.selected_item.contains(item)){
                    item.set_selected(true);
                    this.canvas.selected_item.add(item);
            }
        }
        this.canvas.set_offset(0, 0);
        this.canvas.set_delta(0, 0);
        this.canvas.repaint();
	}

}
