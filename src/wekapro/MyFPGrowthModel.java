/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import weka.associations.FPGrowth;
import weka.core.Instances;

/**
 *
 * @author OS
 */
public class MyFPGrowthModel extends MyKnowlegeModel{
    Instances newData;
    FPGrowthr fp;
    //privite String[]"model_options";

    public MyFPGrowthModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
        this.fp = new FPGrowthr();    
    }
    public void mineAssociationRules(){
        
        //loc du lieu
        //this.newData = removeData(this.dataset);
        this.newData = convert2Binary(this.dataset);
        
        //thiet lap thong bao
        fp.setOptions(this.model_options);
        //khao pha
        fp.buildAssociations(this.newData);
    }   

    @Override
    public String toString() {
        return fp.toString();//super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
