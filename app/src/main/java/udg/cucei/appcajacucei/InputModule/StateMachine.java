package udg.cucei.appcajacucei.InputModule;

/**
 * Created by Edgar Ulises on 03/06/2016.
 */
public class StateMachine {

    int minState;
    int presentState;

    boolean  Item_MetricSys;//false:international, True:imperial US

    int itemAlto;
    int itemAncho;
    int itemGrosor;
    int itempeso;
    boolean itemOreintation;
    String itemTipe;

    int boxAlto;
    int boxAncho;
    int boxGrosor;
    int boxPeso;




    public StateMachine(){
        Item_MetricSys=false;

        itemTipe="square";
        itemOreintation=true;

    }



    //TODO: put the rest of sizes
}
