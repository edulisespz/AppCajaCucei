package udg.cucei.appcajacucei.InputModule;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import udg.cucei.appcajacucei.Calculations.Shape;

/**
 * Created by Edgar Ulises on 03/06/2016.
 */
public class StateMachine implements Parcelable {

    public static final String KEY_DATA= "datos1";

    int minState;
    int presentState;

    boolean  Item_MetricSys;//false:international, True:imperial, US
    public int itemQuantity;

    //----
    int numitemsPerPacage;
    float VolUsedPerPacage;
    int TotalOfContainersUsed;
    //----

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
    boolean boxAmarred;
    boolean boxCartonisDouble;

    int mckeeCalibre;
    int mckeeLargo;
    int mckeeAncho;
    int mckeeEtc;


    int PalleAlto;
    int PalleAncho;
    int PalleLargo;

    int ContainerAncho;
    int ContainerLargo;
    int ContainerAlto;
    int ContainerCap;
    int ContainerMaxpeso;


    public StateMachine( StateMachine objtforcopy){
        this.Item_MetricSys = objtforcopy.Item_MetricSys;
        this.itemQuantity = objtforcopy.itemQuantity;

        this.numitemsPerPacage = objtforcopy.numitemsPerPacage;
        this.VolUsedPerPacage = objtforcopy.VolUsedPerPacage;
        this.TotalOfContainersUsed = objtforcopy.TotalOfContainersUsed;

        this.itemAlto = objtforcopy.itemAlto;
        this.itemAncho = objtforcopy.itemAncho;
        this.itemGrosor = objtforcopy.itemGrosor;
        this.itempeso = objtforcopy.itempeso;
        this.itemOreintation = objtforcopy.itemOreintation;
        this.itemTipe = objtforcopy.itemTipe;

        this.boxAlto = objtforcopy.boxAlto;
        this.boxAncho = objtforcopy.boxAncho;
        this.boxGrosor = objtforcopy.itemGrosor;
        this.boxPeso = objtforcopy.boxPeso;
        this.boxAmarred = objtforcopy.boxAmarred;
        this.boxCartonisDouble = objtforcopy.boxCartonisDouble;

        this.mckeeCalibre  = objtforcopy.mckeeCalibre;
        this.mckeeLargo = objtforcopy.mckeeLargo;
        this.mckeeAncho = objtforcopy.mckeeAncho;
        this.mckeeEtc = objtforcopy.mckeeEtc;

        this.PalleAlto = objtforcopy.PalleAlto;
        this.PalleAncho = objtforcopy.PalleAncho;
        this.PalleLargo = objtforcopy.PalleLargo;

        this.ContainerAncho = objtforcopy.ContainerAncho;
        this.ContainerLargo = objtforcopy.ContainerLargo;
        this.ContainerAlto = objtforcopy.ContainerAlto;
        this.ContainerCap = objtforcopy.ContainerCap;
        this.ContainerMaxpeso = objtforcopy.ContainerMaxpeso;


    }


    public StateMachine(){
        Item_MetricSys=false;
        boxAmarred=false;

        itemQuantity=-1;

        itemTipe="square";
        itemOreintation=true;

        PalleAlto=-1;
        ContainerAncho=-1;

    }

    public Shape getItemShape(){
        return new Shape(itemAncho,itemGrosor,itemAlto);
    }

    public Shape getBoxShape(){
        return new Shape(boxAncho,boxGrosor,boxAlto);
    }

    public Shape getPalletShape(){
        return new Shape(PalleAncho,PalleLargo,PalleAlto);
    }

    public Shape getContainerShape(){
        return new Shape(ContainerAncho,ContainerLargo,ContainerAlto);
    }

    public float getVolPorcentage(Shape item,Shape Container){
        float aVol= item.getX() * item.getY() * item.getZ();
        float bVol= Container.getX() * Container.getY() * Container.getZ();

        int numberofitemsperbox = (int)Math.floor(bVol/aVol);

        int preVol = (int)(aVol*numberofitemsperbox);

        return (preVol/bVol)*100;

    }

    public int getnumberOfContainers(Shape item,Shape Container, int elementsToStore){
        float aVol= item.getX() * item.getY() * item.getZ();
        float bVol= Container.getX() * Container.getY() * Container.getZ();

        return (int) Math.ceil((elementsToStore/ (bVol/aVol) ));

    }

    public int getnumberOfitemsinBoxes(Shape item,Shape Container){
        float aVol= item.getX() * item.getY() * item.getZ();
        float bVol= Container.getX() * Container.getY() * Container.getZ();

        return (int) Math.floor(bVol/aVol);

    }

    public boolean itemItsBigger(Shape item,Shape Container){
        float aVol= item.getX() * item.getY() * item.getZ();
        float bVol= Container.getX() * Container.getY() * Container.getZ();

        if (aVol>bVol){
            return true;
        }else{
            return false;
        }

    }




    public String TestdataItemAlto(){

        return String.valueOf(itemAlto);
    }

    public String TestdataItemOrint(){

        return String.valueOf(itemOreintation);
    }



    //TODO: put the rest of sizes




    //-------------------// Parcelable stuff
    //using http://www.parcelabler.com/

    protected StateMachine(Parcel in) {
        minState = in.readInt();
        presentState = in.readInt();
        Item_MetricSys = in.readByte() != 0x00;
        itemQuantity=in.readInt();
        numitemsPerPacage = in.readInt();
        VolUsedPerPacage = in.readFloat();
        TotalOfContainersUsed = in.readInt();
        itemAlto = in.readInt();
        itemAncho = in.readInt();
        itemGrosor = in.readInt();
        itempeso = in.readInt();
        itemOreintation = in.readByte() != 0x00;
        itemTipe = in.readString();
        boxAlto = in.readInt();
        boxAncho = in.readInt();
        boxGrosor = in.readInt();
        boxPeso = in.readInt();
        boxAmarred = in.readByte() != 0x00;
        boxCartonisDouble = in.readByte() != 0x00;
        mckeeCalibre = in.readInt();
        mckeeLargo = in.readInt();
        mckeeAncho = in.readInt();
        mckeeEtc = in.readInt();
        PalleAlto = in.readInt();
        PalleAncho = in.readInt();
        PalleLargo = in.readInt();
        ContainerAncho = in.readInt();
        ContainerLargo = in.readInt();
        ContainerAlto = in.readInt();
        ContainerCap = in.readInt();
        ContainerMaxpeso = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(minState);
        dest.writeInt(presentState);
        dest.writeByte((byte) (Item_MetricSys ? 0x01 : 0x00));
        dest.writeInt(itemQuantity);
        dest.writeInt(numitemsPerPacage);
        dest.writeFloat(VolUsedPerPacage);
        dest.writeInt(TotalOfContainersUsed);
        dest.writeInt(itemAlto);
        dest.writeInt(itemAncho);
        dest.writeInt(itemGrosor);
        dest.writeInt(itempeso);
        dest.writeByte((byte) (itemOreintation ? 0x01 : 0x00));
        dest.writeString(itemTipe);
        dest.writeInt(boxAlto);
        dest.writeInt(boxAncho);
        dest.writeInt(boxGrosor);
        dest.writeInt(boxPeso);
        dest.writeByte((byte) (boxAmarred ? 0x01 : 0x00));
        dest.writeByte((byte) (boxCartonisDouble ? 0x01 : 0x00));
        dest.writeInt(mckeeCalibre);
        dest.writeInt(mckeeLargo);
        dest.writeInt(mckeeAncho);
        dest.writeInt(mckeeEtc);
        dest.writeInt(PalleAlto);
        dest.writeInt(PalleAncho);
        dest.writeInt(PalleLargo);
        dest.writeInt(ContainerAncho);
        dest.writeInt(ContainerLargo);
        dest.writeInt(ContainerAlto);
        dest.writeInt(ContainerCap);
        dest.writeInt(ContainerMaxpeso);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<StateMachine> CREATOR = new Parcelable.Creator<StateMachine>() {
        @Override
        public StateMachine createFromParcel(Parcel in) {
            return new StateMachine(in);
        }

        @Override
        public StateMachine[] newArray(int size) {
            return new StateMachine[size];
        }
    };


}
