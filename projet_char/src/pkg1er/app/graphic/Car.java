/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.app.graphic;


import java.sql.Blob;
import java.util.ArrayList;

/**
 *
 * @author Benoit
 */
public class Car {
    
    private int serialnb;
    private String modelName;
    private String makeName;
    private String countryName;
    private String typeName;
    private String engineName;
    private String engineType;
    private String speed;
    private String price;
    private ArrayList<String> color;
    private ArrayList<String> options;
    private Blob pic;

    public Car(int serialnb, String modelName, String makeName, String countryName, String typeName,String engineName, String engineType, String speed, String price, Blob pic) {
        this.serialnb = serialnb;
        this.modelName = modelName;
        this.makeName = makeName;
        this.countryName = countryName;
        this.typeName = typeName;
        this.engineName = engineName;
        this.engineType = engineType;
        this.speed = speed;
        this.price = price;
        this.pic = pic;
        
        color=new ArrayList();
        options=new ArrayList();
        
    }

    public Blob getPic() {
        return pic;
    }
    

    public void setPic(Blob pic) {
        this.pic = pic;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineName() {
        return engineName;
    }

    public int getSerialnb() {
        return serialnb;
    }

    public String getModelName() {
        return modelName;
    }

    public String getMakeName() {
        return makeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getSpeed() {
        return speed;
    }

    public String getPrice() {
        return price;
    }

    public ArrayList getColor() {
        return color;
    }

    public ArrayList getOptions() {
        return options;
    }

    public void setSerialnb(int serialnb) {
        this.serialnb = serialnb;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setColor(ArrayList color) {
        this.color = color;
    }
    
    public void addColor(String col){
        color.add(col);
    }

    public void setOptions(ArrayList options) {
        this.options = options;
    }
    
    public void addOption(String op){
        options.add(op);
    }
    
    
}
