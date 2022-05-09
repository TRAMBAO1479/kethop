/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import weka.associations.Apriori;
import weka.core.Instances;

///
/**
 *
 * @author OS
 */
public class MyAprioriModel extends MyKnowlegeModel{
    Appriori apriori;
    Instances newData;

    public MyAprioriModel() {
    }

    public MyAprioriModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
        this.apriori = new Appriori();
    }
    
    public void mineAssociationRules() throws Exception{
        //loc du lieu
        //this.newData = removeData(this.newData);
        this.newData = converData(this.dataset);
        //thiet lap thong so cho model Apriori
        apriori.setOptions(this.model_options);
        //Khia pha luat ket hop bang thuat toan Apriori
        apriori.builAssociations(this.newData);
        
    }

    @Override
    public String toString() {
        return apriori.toString();//super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
