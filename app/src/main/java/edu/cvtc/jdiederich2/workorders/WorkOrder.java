package edu.cvtc.jdiederich2.workorders;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "userID",
        childColumns = "userID",
        onDelete = CASCADE))

public class WorkOrder implements WorkOrdersDao {

    @PrimaryKey(autoGenerate = true)
    private int orderID;

    @ColumnInfo(name = "userID")
    private int userID;

    @NonNull
    @ColumnInfo(name = "csFirstName")
    private String csFirstName;

    @NonNull
    @ColumnInfo(name = "csLastName")
    private String csLastName;

    @NonNull
    @ColumnInfo(name = "csPhoneNum")
    private String csPhoneNumber;

    @NonNull
    @ColumnInfo(name = "csAddress")
    private String csAddress;

    @NonNull
    @ColumnInfo(name = "csCity")
    private String csCity;

    @NonNull
    @ColumnInfo(name = "csAcctNum")
    private int csAccountNum;

    @NonNull
    @ColumnInfo(name = "csInstallDate")
    private String csInstallDate;

    public WorkOrder() {
    }

    public WorkOrder(int orderID, int userID, @NonNull String csFirstName, @NonNull String csLastName, @NonNull String csPhoneNumber, @NonNull String csAddress, @NonNull String csCity, @NonNull int csAccountNum, @NonNull String csInstallDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.csFirstName = csFirstName;
        this.csLastName = csLastName;
        this.csPhoneNumber = csPhoneNumber;
        this.csAddress = csAddress;
        this.csCity = csCity;
        this.csAccountNum = csAccountNum;
        this.csInstallDate = csInstallDate;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCsFirstName() {
        return this.csFirstName;
    }

    public void setCsFirstName(@NonNull String csFirstName) {
        this.csFirstName = csFirstName;
    }

    public String getCsLastName() {
        return this.csLastName;
    }

    public void setCsLastName(@NonNull String csLastName) {
        this.csLastName = csLastName;
    }

    @NonNull
    public String getCsPhoneNumber() {
        return csPhoneNumber;
    }

    public void setCsPhoneNumber(@NonNull String csPhoneNumber) {
        this.csPhoneNumber = csPhoneNumber;
    }

    public String getCsAddress() {
        return this.csAddress;
    }

    public void setCsAddress(@NonNull String csAddress) {
        this.csAddress = csAddress;
    }

    public String getCsCity() {
        return this.csCity;
    }

    public void setCsCity(@NonNull String csCity) {
        this.csCity = csCity;
    }

    public int getCsAccountNum() {
        return this.csAccountNum;
    }

    public void setCsAccountNum(@NonNull int csAccountNum) {
        this.csAccountNum = csAccountNum;
    }

    public String getCsInstallDate() {
        return this.csInstallDate;
    }

    public void setCsInstallDate(@NonNull String csInstallDate) {
        this.csInstallDate = csInstallDate;
    }

    @Override
    public void insertWorkOrder(WorkOrder workOrder) {

    }

    @Override
    public List<WorkOrder> getAllWorkOrders() {
        return null;
    }
}
