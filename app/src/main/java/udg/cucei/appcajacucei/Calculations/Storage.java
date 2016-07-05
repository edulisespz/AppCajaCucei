package udg.cucei.appcajacucei.Calculations;

/**
 * Created by Edgar Ulises on 27/04/2016.
 */
public class Storage{
        int amount; //cantidad de los acomodados
        double x;	//eje x
        double y;	//eje y
        double z; //eje z
        double weight;  //peso de los acomodados

        public Storage(int NumberOfElem, double X, double Y, double Z) {
            this.amount= NumberOfElem;
            this.x=X;
            this.y=Y;
            this.z=Z;
            this.weight=0;//TODO: see later how this  thing is going to work


        }
}
