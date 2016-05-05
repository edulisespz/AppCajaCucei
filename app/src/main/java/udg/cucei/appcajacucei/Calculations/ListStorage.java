package udg.cucei.appcajacucei.Calculations;

import android.util.Log;
import java.util.ArrayList;


/**
 * Created by Edgar Ulises on 27/04/2016.
 */
public class ListStorage extends ArrayList<Storage>{
    int totalAmount;
    double constZ;
    //Int amountDesired

    public int StorageKind(double E_x,double E_y,double E_z,
                    double c_x,double c_y, double c_z, int elements){ // c = contenedor, e = elemento
        int r=0;

        double[] kind= new double[4];
        kind[0]= (c_x/E_x) * (c_y/E_y) * (c_z/E_z);
        kind[1]= (c_x/E_y) * (c_y/E_x) * (c_z/E_z);
        kind[2]= (c_x/E_x) * (c_y/E_z) * (c_z/E_y);
        kind[3]= (c_x/E_y) * (c_y/E_z) * (c_z/E_x);

        double kind_F=0;
        double aux=0;
        for(int x=0; x<kind.length; x++){
            if(aux< kind[x]){
                aux=kind[x];
            }
        }
        kind_F= aux;
        Log.d("kindF: ", String.valueOf(kind_F) );

        if(elements<=kind_F){
            Log.i("return","acomodo completado");
            return 1;//acomodo completado satisfactoriamente
        }

        if (kind_F < 1) {
            Log.i("return","espacio insuficiente");
            return -1;//espacio insuficiente en la carga
        }else{
            Storage storage;
            if(kind[0]==kind_F){
                storage = new Storage(kind[0],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += (int)kind[0];
                r = this.StorageKind(E_x,E_y,E_z,c_x-E_x*kind[0],
                        c_y-E_y*kind[0],c_z-E_z*kind[0],elements);

                this.constZ = c_z;

            }else if(kind[1]==kind_F){
                storage = new Storage(kind[1],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += (int)kind[1];
                r = this.StorageKind(E_x,E_y,E_z,c_x-E_x*kind[1],
                        c_y-E_y*kind[1],c_z-E_z*kind[1],elements);

                this.constZ = c_z;
            }else if(kind[2]==kind_F){
                storage = new Storage(kind[2],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += (int)kind[2];
                r = this.StorageKind(E_x,E_y,E_z,c_x-E_x*kind[2],
                        c_y-E_y*kind[2],c_z-E_z*kind[2],elements);

                this.constZ = c_y;
            }else if(kind[3]==kind_F){
                storage = new Storage(kind[3],E_x,E_y,E_z);
                this.add(storage);
                this.totalAmount += (int)kind[3];
                r = this.StorageKind(E_x,E_y,E_z,c_x-E_x*kind[3],
                        c_y-E_y*kind[3],c_z-E_z*kind[3],elements);

                this.constZ = c_x;
            }
        }

        return r;
    }

}//endClass
