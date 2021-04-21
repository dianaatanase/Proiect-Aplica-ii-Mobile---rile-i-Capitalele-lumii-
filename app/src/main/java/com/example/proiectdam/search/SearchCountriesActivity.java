package com.example.proiectdam.search;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proiectdam.R;
import com.example.proiectdam.network.HttpManager;
import com.example.proiectdam.network.HttpResponse;
import com.example.proiectdam.network.JsonParser;
import com.example.proiectdam.network.models.Continent;
import com.example.proiectdam.network.models.Tara;

import java.util.ArrayList;
import java.util.List;

public class SearchCountriesActivity extends AppCompatActivity {

    public static final String KEY_PARSE_TARA ="key_parse_tara" ;
    Toolbar searchToolbar;
    ListView searchListView;

    String[] countries = {"Albania","Andorra", "Argentina", "Austria", "Belgium", "Brazil",
            "China", "Croatia", "Denmark", "Egypt", "Finland", "France", "Germany", "Greece", "Hungary", "India", "Italy", "Japan",
            "Kuwait", "Luxembourg", "Malta", "Mexico", "Moldova", "Norway", "Philippines", "Portugal", "Romania", "Russia",
            "Saudi Arabia", "Singapore", "Spain", "Switzerland", "Turkey", "Trinidad and Tobago", "Tunisia", "Ukraine", "United Kingdom", "United States", "Vatican", "Venezuela", "Zimbabwe"};
    int[] countryImages = {R.drawable.albania,
            R.drawable.andorra,
            R.drawable.argentina,
            R.drawable.austria,
            R.drawable.belgium,
            R.drawable.brazil,
            R.drawable.china,
            R.drawable.croatia,
            R.drawable.denmark,
            R.drawable.egypt,
            R.drawable.finland,
            R.drawable.france,
            R.drawable.germany,
            R.drawable.greece,
            R.drawable.hungary,
            R.drawable.india,
            R.drawable.italy,
            R.drawable.japan,
            R.drawable.kuwait,
            R.drawable.luxembourg,
            R.drawable.malta,
            R.drawable.mexico,
            R.drawable.moldova,
            R.drawable.norway,
            R.drawable.philippines,
            R.drawable.portugal,
            R.drawable.romania,
            R.drawable.russia,
            R.drawable.saudi_arabia,
            R.drawable.singapore,
            R.drawable.spain,
            R.drawable.switzerland,
            R.drawable.turkey,
            R.drawable.trinidadandtobago,
            R.drawable.tunisia,
            R.drawable.ukraine,
            R.drawable.united_kingdom,
            R.drawable.united_states,
            R.drawable.vatican,
            R.drawable.venezuela,
            R.drawable.zimbabwe};

    String[] capitals = {"Irana","Andorra Lavella", "Buenos Aires", "Viena", "Bruxelles", "Brasilia",
            "Beijing", "Zagreb", "Cophenhagen", "Cairo", "Helsinki", "Paris", "Berlin", "Athena", "Budapesta", "New Delphi", "Roma", "Tokyo",
            "Kuwait City", "Luxembourg", "Valetta", "Mexico City", "Chisinau", "Oslo", "Manilla", "Lisabon", "Bucharest", "Moscow",
            "Riyadh", "Singapore", "Madrid", "Berna", "Ankara", "Port of spain", "Tunis", "Kiev", "London", "Washington", "Vatican City", "Caracas", "Harare"};

    private static final String URL="https://jsonkeeper.com/b/34G2";
    private HttpResponse httpResponse;
    private List<Continent> listaContinente=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_countries);

        searchToolbar = findViewById(R.id.search_countries_activity_toolbar);
        searchToolbar.setTitle(getResources().getString(R.string.select_a_country));
        searchListView = findViewById(R.id.search_countries_activity_list_view);

        SearchCountriesAdapter searchCountriesAdapter = new SearchCountriesAdapter(SearchCountriesActivity.this,countries, countryImages, capitals);
        searchListView.setAdapter(searchCountriesAdapter);

        //click listener
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchCountriesActivity.this, SearchCountriesDetailActivity.class);
                intent.putExtra(getString(R.string.seach_coutries_activity_country_Name), countries[position]);
                intent.putExtra(getString(R.string.searh_countries_activity_country_flag), countryImages[position]);
                for (Continent c:listaContinente) {

                    for (Tara t: c.getTari()) {
                        if(t.getNume().equals(countries[position])){
                            intent.putExtra(KEY_PARSE_TARA,t);
                        }
                    }

                }
                startActivity(intent);
            }
        });
        getDataFromJson();
    }
    @SuppressLint("StaticFieldLeak")
    private void getDataFromJson(){
        new HttpManager(){
            @Override
            protected void onPostExecute(String s) {
                httpResponse= JsonParser.parseJson(s);
                if(httpResponse!=null){
                    listaContinente=httpResponse.getListaContinete();
                    String string=null;
                    for (Continent c: listaContinente
                    ) {
                        string+=c.toString();
                    }
                    //Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected void onPreExecute() {
                Toast.makeText(getApplicationContext(), R.string.waiting_data,Toast.LENGTH_LONG).show();
            }
        }.execute(URL);
    }

}
