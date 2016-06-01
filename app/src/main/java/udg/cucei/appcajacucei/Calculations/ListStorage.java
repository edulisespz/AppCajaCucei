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

    public int StorageKind(int E_x,int E_y,int E_z,
                           int c_x,int c_y, int c_z, int elements){ // c = contenedor, e = elemento
        int r=0;




        /*
        TODO: modify algoritm

		        if(-1 || 0)

        (c.x/e.x)(c.y/e.y)(c.z/e.z) //0
        (c.x/e.y)(c.y/e.x)(c.z/e.z) //0

                if(-1 || 1)
        (c.x/e.x)(c.y/e.z)(c.z/e.y)//1
        (c.x/e.z)(c.y/e.x)(c.z/e.y)//1

                if(-1 || 2)
        (c.x/e.y)(c.y/e.z)(c.z/e.x)// 2
        (c.x/e.z)(c.y/e.y)(c.z/e.x)// 2

        ---

         */

        int[] kind= new int[4];
        kind[0]= (c_x/E_x) * (c_y/E_y) * (c_z/E_z);
        kind[1]= (c_x/E_y) * (c_y/E_x) * (c_z/E_z);
        kind[2]= (c_x/E_x) * (c_y/E_z) * (c_z/E_y);

        kind[2]= (c_x/E_z) * (c_y/E_x) * (c_z/E_y);

        kind[3]= (c_x/E_y) * (c_y/E_z) * (c_z/E_x);

        int kind_F=0;
        int aux=0;

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
