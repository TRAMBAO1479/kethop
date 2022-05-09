/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wekapro;

/**
 *
 * @author OS
 */
public class WekaPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        MyKnowlegeModel model = new MyKnowlegeModel(
//                "E:\\WEKA\\Weka-3-9-6\\data\\iria.arff");
//        System.out.println(model);
//        
//        model.saveData("E:\\BT_NETBEAN\\Data\\iris.arff");
//        model.saveData2CSV("E:\\BT_NETBEAN\\Data\\iris_CSV.csv");
//        MyAprioriModel model = new MyAprioriModel(
//                "E:\\WEKA\\Weka-3-9-6\\data\\weather.numberic.arff",
//                "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                "-R 2-3");
//        model.mineAssociationRules();
        MyFPGrowthModel model = new MyFPGrowthModel("E:\\WEKA\\Weka-3-9-6\\data\\weather.nominal.arff", 
                "-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2",
                "-N -R first-last");
         model.mineAssociationRules();
System.out.println(model);
        
    }

}
