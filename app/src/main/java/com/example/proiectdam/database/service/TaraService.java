package com.example.proiectdam.database.service;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import com.example.proiectdam.database.DatabaseManager;
import com.example.proiectdam.database.dao.TaraDao;
import com.example.proiectdam.database.model.TaraDB;

import java.util.List;

public class TaraService {

    public static TaraDao taraDao;
    public static class Insert extends AsyncTask<TaraDB,Void,TaraDB>{

        public Insert(Context context){
            taraDao= DatabaseManager.getInstance(context).taraDao();
        }

        @Override
        protected TaraDB doInBackground(TaraDB... taraDBS) {
            if(taraDBS==null||taraDBS.length!=1){
                return null;
            }else {
                TaraDB taraDB=taraDBS[0];
                long id=taraDao.insert(taraDB);
                if(id!=-1){
                    taraDB.setId_tara(id);
                    return  taraDB;
                }
            }
            return null;
        }
    }
    public  static class GetAll extends AsyncTask<Void,Void, List<TaraDB>>{

        public GetAll(Context context){
            taraDao=DatabaseManager.getInstance(context).taraDao();
        }

        @Override
        protected List<TaraDB> doInBackground(Void... voids) {
            return taraDao.gatAll();
        }
    }
    public static class StergeTara extends  AsyncTask<TaraDB,Void,Integer>{
        public StergeTara(Context context){
            taraDao=DatabaseManager.getInstance(context).taraDao();
        }
        @Override
        protected Integer doInBackground(TaraDB... taraDBS) {
           TaraDB taraDB=taraDBS[0];
           return taraDao.stergeTara(taraDB);
        }
    }

}
