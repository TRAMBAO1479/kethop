/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;


/**
 *
 * @author OS
 */
public class MyKnowlegeModel {
    DataSource source;
    Instances dataset;
    String[] model_options;
    String[] data_options;

    public MyKnowlegeModel() {
    }
    
    public MyKnowlegeModel(String filename,
                        String m_opts,
                        String d_opts) throws Exception {
        this.source = new DataSource(filename);
        this.dataset= source.getDataSet();
        this.model_options = weka.core.Utils.splitOptions(m_opts);
        this.data_options = weka.core.Utils.splitOptions(d_opts);
    }

    public Instances removeData(Instances originalData) throws Exception{
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
    }
    
    public Instances converData(Instances originalData){
        NumbericToNominal n2n = new NumbericToNominal();
        n2n.setOptions(data_options);
        n2n.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2n);
//        NumbericToNominal n2n = new NumbericToNominal();
//        n2n.setOptions(data_options);
//        n2n.setInputFormat(originalData);
//        return Filter.useFilter(originalData, n2n);
//       NumbericToNominal n2n = new NumbericToNominal();
//       //NumbericToNominal n2n = new NumbericToNominal();
//       n2n.setOptions(data_options);
//       n2n.setInputFormat(originalData);
       
    }
    
    public Instances convert2Binary(Instances originalData) throws Exception{
        NominalToBinary n2b = new NominalToBinary();
        n2b.setOptions(data_options);
        n2b.setBinaryAttributesNominal(true);
        n2b.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2b);
    }
    
    public void saveData(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Saving finighed");
        
    }
    
    public void saveData2CSV(String filename) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Converted");
    }
    
    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
    
    
    
    
}
