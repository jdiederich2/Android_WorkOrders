package edu.cvtc.jdiederich2.workorders.Controllers;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.cvtc.jdiederich2.workorders.Models.User;

@Dao
public interface LoginDao {

    @Query( "SELECT * FROM User WHERE userName = :loginUserName" )
    public abstract User getUserNameAndPassword(String loginUserName);
}
