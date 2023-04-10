package panel;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import button.*;
import panel.*;

import java.io.File;
import java.awt.image.BufferedImage;


public class Panel_btn extends JPanel{
    public Panel_btn(){
        System.out.println("Btn_panel created");
        setLayout(new GridLayout(6, 1));

        btn_select = new Select();
        btn_select.set_icon("/img_source/select.PNG");

        btn_asso = new Association();
        btn_asso.set_icon("/img_source/association.PNG");

        btn_gene = new Generalization();
        btn_gene.set_icon("/img_source/generalization.PNG");

        btn_comp = new Composition();
        btn_comp.set_icon("/img_source/composition.PNG");

        btn_class = new Class_();
        btn_class.set_icon("/img_source/class.PNG");

        btn_usecase = new UseCase();
        btn_usecase.set_icon("/img_source/usecase.PNG");

        add(btn_select);
        add(btn_asso);
        add(btn_gene);
        add(btn_comp);
        add(btn_class);
        add(btn_usecase);
        buttonGroup.add(btn_select);
        buttonGroup.add(btn_asso);
        buttonGroup.add(btn_gene);
        buttonGroup.add(btn_comp);
        buttonGroup.add(btn_class);
        buttonGroup.add(btn_usecase);
    }

    private static Select btn_select;
    private static Association btn_asso;
    private static Generalization btn_gene;
    private static Composition btn_comp;
    private static Class_ btn_class;
    private static UseCase btn_usecase;
    private ButtonGroup buttonGroup = new ButtonGroup();
}