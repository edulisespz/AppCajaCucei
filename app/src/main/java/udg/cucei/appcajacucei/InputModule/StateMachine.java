package udg.cucei.appcajacucei.InputModule;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Edgar Ulises on 03/06/2016.
 */
public class StateMachine implements Parcelable {

    public static final String KEY_DATA= "datos1";

    int minState;
    int presentState;

    boolean  Item_MetricSys;//false:international, True:imperial, US

    public int itemAlto;
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

    //TODO: add parceable code
    int PalleAlto;
    int PalleAncho;
    int PalleLargo;

    int ContainerAncho;
    int ContainerLargo;
    int ContainerAlto;
    int ContainerCap;
    int ContainerMaxpeso;




    public StateMachine(){
        Item_MetricSys=false;
        boxAmarred=false;

        itemTipe="square";
        itemOreintation=true;

        PalleAlto=-1;
        ContainerAncho=-1;

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
