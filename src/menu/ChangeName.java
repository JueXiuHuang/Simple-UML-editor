package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import panel.*;

public class ChangeName extends JMenuItem implements ActionListener{
    public ChangeName(String name){
        super(name);
        addActionListener(this);
        //canvas = Panel_canvas.get_canvas();
        canvas = New_canvas.get_canvas();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("ChangeName clicked!");

        JFrame naming = new JFrame("Change Object Name");
        naming.setSize(500, 200);
        naming.getContentPane().setLayout(new GridLayout(0, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JTextField text_field =  new JTextField("Name");
        panel.add(text_field);
        naming.getContentPane().add(panel);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        ok = new JButton("OK");
        panel.add(ok);
        cancel = new JButton("cancel");
        panel.add(cancel);

        naming.getContentPane().add(panel);

        naming.setLocationRelativeTo(null);
        naming.setVisible(true);

        ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.change_name(text_field.getText());
				naming.dispose();
			}
		});

        cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				naming.dispose();
			}
		});
    }

    private JButton ok, cancel;
    private New_canvas canvas;
}