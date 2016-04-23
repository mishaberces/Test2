package home.misha.testnew;

import android.os.Parcel;
import android.os.Parcelable;


public class Pytannja implements  Parcelable {
    private String name;
    private String[] vidpovidi=new String[11];
    private int[] vaga_vidpovidi=new int[11];

    private String detali;
    private int id;
    private int vybir;

    public void setVaga_vidpovidi(int[] _vaga_vidpovidi){
        this.vaga_vidpovidi=_vaga_vidpovidi;
    }

   public int[] getVaga_vidpovidi() {
       return this.vaga_vidpovidi;
   }

    public int getVaga_vidpovidiId(int id_pyt){
        return this.vaga_vidpovidi[id_pyt];
    }

    public void setVybir(int _vybir){
        this.vybir=_vybir;
    }

    public int getVybir (){
        return this.vybir;
    }

    public void setName(String _name){
        this.name=_name;
    }

    public String getName(){
        return this.name;
    }

    public void setVidpovidi(String[] _vidpovidi){
        this.vidpovidi=_vidpovidi;
    }

    public String[] getVidpovidi(){
        return this.vidpovidi;
    }

    public void setDetali(String _detali){
        this.detali=_detali;
    }

    public String getDetali(){
        return this.detali;
    }

    public void setId(int _id){
        this.id=_id;
    }

    public int getId(){
        return this.id;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
     dest.writeString(name);
     dest.writeString(detali);
     dest.writeInt(id);
    }

    public static final Parcelable.Creator<Pytannja> CREATOR = new Parcelable.Creator<Pytannja>() {

        public Pytannja createFromParcel(Parcel in) {

            return new Pytannja(in);
        }

        public Pytannja[] newArray(int size) {
            return new Pytannja[size];
        }
    };

    private Pytannja(Parcel dest){
        this.name=dest.readString();
        this.detali=dest.readString();
        this.id=dest.readInt();

    }


    public Pytannja(String name, String[] vidpovidi, int[] vaga_vidpovidi, String detali, int id ){
        this.name=name;
        this.detali=detali;
        this.vidpovidi=vidpovidi;
        this.vaga_vidpovidi=vaga_vidpovidi;
        this.id=id;
    }




}
