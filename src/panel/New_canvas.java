package panel;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import object.Arrow_base;
import object.Object_base;
import mode.Service;

public class New_canvas extends JPanel implements MouseListener, MouseMotionListener{
	
	private static New_canvas instance = null;
    public ArrayList<Object_base> item_lists = new ArrayList<Object_base>();
    public ArrayList<Object_base> selected_item = new ArrayList<Object_base>();
    public ArrayList<Arrow_base> relationship = new ArrayList<Arrow_base>();
    public ArrayList<Arrow_base> unsure_relation = new ArrayList<Arrow_base>();
    private Service service;
    
    public Random rand_gene = new Random();
    
    private int offset_x, offset_y;
    private int delta_x;
    private int delta_y;
    
    private New_canvas(){
        System.out.println("New_Canvas created");
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
    
    public void set_offset(MouseEvent e){
        this.offset_x = e.getX();
        this.offset_y = e.getY();
    }
    
    public void set_offset(int x, int y){
        this.offset_x = x;
        this.offset_y = y;
    }
    
    public int[] get_offset(){
    	int[] ret = new int[2];
    	ret[0] = this.offset_x;
    	ret[1] = this.offset_y;
    	return ret;
    }
    
    public void set_delta(int[] inputs){
    	this.delta_x = inputs[0];
    	this.delta_y = inputs[1];
    }
    
    public void set_delta(int x, int y){
    	this.delta_x = x;
    	this.delta_y = y;
    }
    
    public int[] get_delta(){
    	int[] ret = new int[2];
    	ret[0] = this.delta_x;
    	ret[1] = this.delta_y;
    	return ret;
    }
    
    public void change_name(String name){
        if(selected_item.size() != 0){
            selected_item.get(0).change_name(name);
        }
        this.repaint();
    }
    
    public void addItem(Object_base obj){
        item_lists.add(obj);
        this.repaint();
    }
    
    public static New_canvas get_canvas(){
        if(instance == null){
            instance = new New_canvas();
        }
        
        return instance;
    }
    
    public void set_service(Service service) {
    	this.service = service;
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.service.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.service.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.service.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.service.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
