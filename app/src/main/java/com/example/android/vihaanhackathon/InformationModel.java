package com.example.android.vihaanhackathon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by anamika on 28/10/17.
 */

public class InformationModel implements Parcelable{
    String train_no;
    String time_of_accident;
    String reason;
    String district;
    String station_code;
    ArrayList<String> generalPassengerList;
    ArrayList <String> pnr;
    ArrayList <String> rName;
    int unknownIdentities;

    public InformationModel(String train_no, String time_of_accident, String reason, String district, String station_code, ArrayList<String> generalPassengerList, ArrayList<String> pnr, ArrayList<String> rName, int unknownIdentities) {
        this.train_no = train_no;
        this.time_of_accident = time_of_accident;
        this.reason = reason;
        this.district = district;
        this.station_code = station_code;
        this.generalPassengerList = generalPassengerList;
        this.pnr = pnr;
        this.rName = rName;
        this.unknownIdentities = unknownIdentities;
    }

    protected InformationModel(Parcel in) {
        train_no = in.readString();
        time_of_accident = in.readString();
        reason = in.readString();
        district = in.readString();
        station_code = in.readString();
        generalPassengerList = in.createStringArrayList();
        pnr = in.createStringArrayList();
        rName = in.createStringArrayList();
        unknownIdentities = in.readInt();
    }

    public static final Creator<InformationModel> CREATOR = new Creator<InformationModel>() {
        @Override
        public InformationModel createFromParcel(Parcel in) {
            return new InformationModel(in);
        }

        @Override
        public InformationModel[] newArray(int size) {
            return new InformationModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(train_no);
        dest.writeString(time_of_accident);
        dest.writeString(reason);
        dest.writeString(district);
        dest.writeString(station_code);
        dest.writeStringList(generalPassengerList);
        dest.writeStringList(pnr);
        dest.writeStringList(rName);
        dest.writeInt(unknownIdentities);
    }

    /*
    getters of class
     */

    public String getTrain_no() {
        return train_no;
    }

    public String getTime_of_accident() {
        return time_of_accident;
    }

    public String getReason() {
        return reason;
    }

    public String getDistrict() {
        return district;
    }

    public String getStation_code() {
        return station_code;
    }

    public ArrayList<String> getGeneralPassengerList() {
        return generalPassengerList;
    }

    public ArrayList<String> getPnr() {
        return pnr;
    }

    public ArrayList<String> getrName() {
        return rName;
    }

    public int getUnknownIdentities() {
        return unknownIdentities;
    }


}
