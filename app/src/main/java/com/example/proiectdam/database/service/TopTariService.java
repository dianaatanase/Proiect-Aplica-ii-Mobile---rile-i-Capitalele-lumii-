package com.example.proiectdam.database.service;

import android.content.Context;
import android.os.AsyncTask;

import com.example.proiectdam.database.DatabaseManager;
import com.example.proiectdam.database.dao.TopTariDao;
import com.example.proiectdam.database.model.TopTari;

public class TopTariService {

    private static TopTariDao topTariDao;
    public static class  Insert extends AsyncTask<TopTari,Void,TopTari>{

        public Insert(Context context){
            topTariDao= DatabaseManager.getInstance(context).topTariDao();
        }

        @Override
        protected TopTari doInBackground(TopTari... topTaris) {
          if(topTaris==null||topTaris.length!=1){
              return  null;

          }else{
              TopTari topTari=topTaris[0];
              long id=topTariDao.insert(topTari);
              if(id!=-1){
                  topTari.setId(id);
                  return topTari;
              }
          }
          return null;
        }
    }
}
