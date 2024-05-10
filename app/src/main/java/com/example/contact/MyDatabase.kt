package com.example.contact

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class MyDatabase(var context: Context) : SQLiteOpenHelper(context, "mydata1.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {

        var tableuser =
            "create table tbluser(fname text,lname text,email text,uname text,password text)"
        db.execSQL(tableuser)

        var tablecontact = "create table new(name text,number text)"
        db.execSQL(tablecontact)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    fun insertuserdata(
        firstname: String,
        lastname: String,
        email: String,
        username: String,
        password: String
    ) {
        var insertuserdata =
            "insert into tbluser values('$firstname','$lastname','$email','$username','$password')"
        try {
            writableDatabase.execSQL(insertuserdata)
        } catch (exc: Exception) {

            Log.e("--", "$exc")
        }
    }

    fun selectuser(username: String, password: String): Cursor {

        var selectuser = "select * from tbluser where uname='$username' and password='$password' "
        var cursor = readableDatabase.rawQuery(selectuser, null)

        return cursor
    }

    fun insertnewcontact(fullname: String, number: String) {
//        Log.e("f-----------=","$fullname")
        var insertnewcontact = "insert into new (name,number) values ('$fullname','$number')"
        try {
            writableDatabase.execSQL(insertnewcontact)
        } catch (ex: Exception) {
            Log.e("-----", "$ex")
        }
    }

    fun selectname(): Cursor {
        var selectnamenumber="select * from new"
        var cursor=readableDatabase.rawQuery(selectnamenumber,null)
        return cursor
    }


}
