package udg.cucei.appcajacucei.Calculations;

import android.util.Log;

import java.util.ArrayList;


/**
 * Created by Edgar Ulises on 27/04/2016.
 */
public class ListStorage extends ArrayList<Storage> {
    int totalAmount = 0;
    int style = 0;
    int amountDesired = 0;

    //constructor
    public ListStorage(int amntDesired) {
        amountDesired = amntDesired;
    }

    // c = contenedor, E = elemento
    public int StorageKind(int E_x, int E_y, int E_z,
                           int c_x, int c_y, int c_z) {
        Storage storage;
        int r = 0;

        Log.d("amntDesire: ", String.valueOf(amountDesired));

        if (style == 0) {
            int[] kind = new int[6];

            kind[0] = (c_x / E_x) * (c_y / E_y) * (c_z / E_z);
            kind[1] = (c_x / E_y) * (c_y / E_x) * (c_z / E_z);

            kind[2] = (c_x / E_x) * (c_y / E_z) * (c_z / E_y);
            kind[3] = (c_x / E_z) * (c_y / E_x) * (c_z / E_y);

            kind[4] = (c_x / E_y) * (c_y / E_z) * (c_z / E_x);
            kind[5] = (c_x / E_z) * (c_y / E_y) * (c_z / E_x);


            int kind_F = 0;
            int aux = 0;

            for (int x = 0; x < kind.length; x++) {
                if (aux < kind[x]) {
                    aux = kind[x];

                }
            }
            kind_F = aux;
            Log.i("kindF: ", String.valueOf(kind_F));

            if (totalAmount >= amountDesired && amountDesired != -1) {
                Log.i("return", "acomodo completado");
                return 1;//acomodo completado satisfactoriamente

            } else if (kind_F < 1) {
                Log.i("return", "espacio insuficiente");
                return -1;//espacio insuficiente en la carga

            } else {

                if (kind[0] == kind_F) {
                    storage = new Storage(kind[0], E_x, E_y, E_z);
                    this.add(storage);
                    this.totalAmount += kind[0];
                    style = 1;
                    r = this.StorageKind(E_x, E_y, E_z,
                            c_x - E_x * (c_x / E_x), c_y - E_y * (c_y / E_y), c_z - E_z * (c_z / E_z)
                    );

                } else if (kind[1] == kind_F) {
                    storage = new Storage(kind[1], E_y, E_x, E_z);
                    this.add(storage);
                    this.totalAmount += kind[1];
                    style = 1;
                    r = this.StorageKind(E_x, E_y, E_z,
                            c_x - E_y * (c_x / E_y), c_y - E_x * (c_y / E_x), c_z - E_z * (c_z / E_z)
                    );

                } else if (kind[2] == kind_F) {
                    storage = new Storage(kind[2], E_x, E_z, E_y);
                    this.add(storage);
                    this.totalAmount += kind[2];
                    style = 2;
                    r = this.StorageKind(E_x, E_y, E_z,
                            c_x - E_x * (c_x / E_x), c_y - E_z * (c_y / E_z), c_z - E_y * (c_z / E_y)
                    );

                } else if (kind[3] == kind_F) {
                    storage = new Storage(kind[3], E_z, E_x, E_y);
                    this.add(storage);
                    this.totalAmount += kind[3];
                    style = 2;
                    r = this.StorageKind(E_x, E_y, E_z
                            , c_x - E_z * (c_x / E_z), c_y - E_x * (c_y / E_x), c_z - E_y * (c_z / E_y)
                    );

                } else if (kind[4] == kind_F) {
                    storage = new Storage(kind[4], E_y, E_z, E_x);
                    this.add(storage);
                    totalAmount += kind[4];
                    style = 3;
                    r = this.StorageKind(E_x, E_y, E_z
                            , c_x - E_y * (c_x / E_y), c_y - E_z * (c_y / E_z), c_z - E_x * (c_z / E_x)
                    );

                } else if (kind[5] == kind_F) {
                    storage = new Storage(kind[5], E_z, E_y, E_x);
                    this.add(storage);
                    totalAmount += kind[5];
                    style = 3;
                    r = this.StorageKind(E_x, E_y, E_z
                            , c_x - E_z * (c_x / E_z), c_y - E_y * (c_y / E_y), c_z - E_x * (c_z / E_x)
                    );
                }
            }

        } else if (style == 1) {
            int[] kind = new int[2];

            kind[0] = (c_x / E_x) * (c_y / E_y) * (c_z / E_z); //kind_0
            kind[1] = (c_x / E_y) * (c_y / E_x) * (c_z / E_z);// kind_1

            int kind_F = 0;
            int aux = 0;

            for (int x = 0; x < kind.length; x++) {
                if (aux < kind[x]) {
                    aux = kind[x];

                }
            }
            kind_F = aux;
            Log.i("kindF: ", String.valueOf(kind_F));

            if (totalAmount >= amountDesired && amountDesired != -1) {
                Log.i("return", "acomodo completado");
                return 1;//acomodo completado satisfactoriamente
            }

            if (kind_F < 1) {
                Log.i("return", "espacio insuficiente");
                return -1;//espacio insuficiente en la carga
            } else {

                if (kind[0] == kind_F) {
                    storage = new Storage(kind[0], E_x, E_y, E_z);
                    this.add(storage);
                    this.totalAmount += kind[0];
                    style = 1;
                    r = this.StorageKind(E_x, E_y, E_z,
                            c_x - E_x * (c_x / E_x), c_y - E_y * (c_y / E_y), c_z - E_z * (c_z / E_z)
                    );

                } else if (kind[1] == kind_F) {
                    storage = new Storage(kind[1], E_y, E_x, E_z);
                    this.add(storage);
                    this.totalAmount += kind[1];
                    style = 1;
                    r = this.StorageKind(E_x, E_y, E_z,
                            c_x - E_y * (c_x / E_y), c_y - E_x * (c_y / E_x), c_z - E_z * (c_z / E_z)
                    );

                }

            }

        } else if (style == 2) {
            int[] kind = new int[2];

            kind[0] = (c_x / E_x) * (c_y / E_z) * (c_z / E_y); //kind_2
            kind[1] = (c_x / E_z) * (c_y / E_x) * (c_z / E_y);// kind_3


            int kind_F = 0;
            int aux = 0;

            for (int x = 0; x < kind.length; x++) {
                if (aux < kind[x]) {
                    aux = kind[x];

                }
            }
            kind_F = aux;
            Log.i("kindF: ", String.valueOf(kind_F));

            if (totalAmount >= amountDesired && amountDesired != -1) {
                Log.i("return", "acomodo completado");
                return 1;//acomodo completado satisfactoriamente
            }

            if (kind_F < 1) {
                Log.i("return", "espacio insuficiente");
                return -1;//espacio insuficiente en la carga
            } else {


            }
            if (kind[0] == kind_F) {
                storage = new Storage(kind[0], E_x, E_z, E_y);
                this.add(storage);
                this.totalAmount += kind[0];
                style = 2;
                r = this.StorageKind(E_x, E_y, E_z,
                        c_x - E_x * (c_x / E_x), c_y - E_z * (c_y / E_z), c_z - E_y * (c_z / E_y)
                );

            } else if (kind[1] == kind_F) {
                storage = new Storage(kind[1], E_z, E_x, E_y);
                this.add(storage);
                this.totalAmount += kind[1];
                style = 2;
                r = this.StorageKind(E_x, E_y, E_z
                        , c_x - E_z * (c_x / E_z), c_y - E_x * (c_y / E_x), c_z - E_y * (c_z / E_y)
                );

            }


        } else if (style == 3) {
            int[] kind = new int[2];


            kind[0] = (c_x / E_y) * (c_y / E_z) * (c_z / E_x); //kind_4
            kind[1] = (c_x / E_z) * (c_y / E_y) * (c_z / E_x); //kind_5


            int kind_F = 0;
            int aux = 0;

            for (int x = 0; x < kind.length; x++) {
                if (aux < kind[x]) {
                    aux = kind[x];

                }
            }
            kind_F = aux;
            Log.i("kindF: ", String.valueOf(kind_F));

            if (totalAmount >= amountDesired && amountDesired != -1) {
                Log.i("return", "acomodo completado");
                return 1;//acomodo completado satisfactoriamente
            }

            if (kind_F < 1) {
                Log.i("return", "espacio insuficiente");
                return -1;//espacio insuficiente en la carga
            } else {

                if (kind[0] == kind_F) {
                    storage = new Storage(kind[0], E_y, E_z, E_x);
                    this.add(storage);
                    totalAmount += kind[0];
                    style = 3;
                    r = this.StorageKind(E_x, E_y, E_z
                            , c_x - E_y * (c_x / E_y), c_y - E_z * (c_y / E_z), c_z - E_x * (c_z / E_x)
                    );

                } else if (kind[1] == kind_F) {
                    storage = new Storage(kind[1], E_z, E_y, E_x);
                    this.add(storage);
                    totalAmount += kind[1];
                    style = 3;
                    r = this.StorageKind(E_x, E_y, E_z
                            , c_x - E_z * (c_x / E_z), c_y - E_y * (c_y / E_y), c_z - E_x * (c_z / E_x)
                    );
                }
            }

        }

        return r;
    }

}//endClass
