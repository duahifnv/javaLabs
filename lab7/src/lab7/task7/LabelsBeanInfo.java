package lab7.task7;

import lab7.task5.Labels;

import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class LabelsBeanInfo extends SimpleBeanInfo {
    private Image icon;
    private static PropertyDescriptor[] propDescr;
    static {
        try {
            propDescr = new PropertyDescriptor[]{
                    new PropertyDescriptor("value", Labels.class)
            };
        }
        catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }
    public LabelsBeanInfo() {
        if(icon == null) loadImage("D:\\DSTU\\ява\\lab7\\img\\icons\\label.svg");
        /* путь относительно .сlass файла */
    }
    public Image getImage(int type) {
        if(type == ICON_COLOR_16x16) return icon;
        return null;
    }
    public PropertyDescriptor[] getPropertyDescriptors() {
        return propDescr;
    }

}
