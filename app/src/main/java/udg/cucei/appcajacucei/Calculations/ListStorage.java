package udg.cucei.appcajacucei.Calculations;

import android.util.Log;
import java.util.ArrayList;


/**
 * Created by Edgar Ulises on 27/04/2016.
 */
public class ListStorage extends ArrayList<Storage>{
    int totalAmount=0;
    int style; //
    int amountDesired;

        // c = contenedor, E = elemento
    public int StorageKind(int E_x,int E_y,int E_z,
                           int c_x,int c_y, int c_z,
                           int amntDesire )
    {
        Storage storage;
        int r=0;
        amountDesired=amntDesire;

        int[] kind= new int[6];

            kind[0] = (c_x / E_x) * (c_y / E_y) * (c_z / E_z);
            kind[1] = (c_x / E_y) * (c_y / E_x) * (c_z / E_z);

            kind[2] = (c_x / E_x) * (c_y / E_z) * (c_z / E_y);
            kind[3] = (c_x / E_z) * (c_y / E_x) * (c_z / E_y);

            kind[4] = (c_x / E_y) * (c_y / E_z) * (c_z / E_x);
            kind[5] = (c_x / E_z) * (c_y / E_y) * (c_z / E_x);


        int kind_F=0;
        int aux=0;

        for(int x=0; x<kind.length; x++){
            if(aux< kind[x]){
                aux=kind[x];

            }
        }
        kind_F= aux;
        Log.i("kindF: ", String.valueOf(kind_F) );

        if(totalAmount>=amountDesired && amountDesired!=-1){
            Log.i("return","acomodo completado");
            return 1;//acomodo completado satisfactoriamente
        }

        if (kind_F < 1) {
            Log.i("return","espacio insuficiente");
            return -1;//espacio insuficiente en la carga
        }else{

            if(kind[0]==kind_F){
                storage = new Storage(kind[0],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += kind[0];
                style=1;
                r = this.StorageKind(E_x,E_y,E_z,
                        c_x-E_x*(c_x/E_x), c_y-E_y*(c_y/E_y), c_z-E_z*(c_z/E_z),
                        amountDesired);

            }else if(kind[1]==kind_F){//TODO: por modificar otro dia
                storage = new Storage(kind[1],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += kind[1];
                Flaglayout=0;
                r = this.StorageKind(E_x,E_y,E_z,
                        c_x - E_y*kind[1], c_y - E_x*kind[1], c_z - E_z*kind[1]
                        ,elements, Flaglayout);

                this.constZ = c_z;

            }else if(kind[2]==kind_F){
                storage = new Storage(kind[2],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += (int)kind[2];
                Flaglayout=1; // change later
                r = this.StorageKind(E_x,E_y,E_z
                        ,c_x-E_x*kind[2],c_y-E_y*kind[2],c_z-E_z*kind[2]
                        ,elements,Flaglayout); //change later

                this.constZ = c_y;

            }else if(kind[3]==kind_F){
                storage = new Storage(kind[3],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += (int)kind[3];
                Flaglayout=1; // change later
                r = this.StorageKind(E_x,E_y,E_z
                        ,c_x-E_x*kind[3], c_y-E_y*kind[3],c_z-E_z*kind[3]
                        ,elements,0); //change later

                this.constZ = c_x;
            }
        }

        return r;
    }

}//endClass
