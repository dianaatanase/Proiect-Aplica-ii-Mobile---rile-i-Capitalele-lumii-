package com.example.proiectdam.search;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectdam.R;
import com.example.proiectdam.database.model.TaraDB;
import com.example.proiectdam.database.service.TaraService;
import com.example.proiectdam.network.models.Tara;

import java.util.ArrayList;
import java.util.List;

public class SearchCountriesDetailActivity extends AppCompatActivity {

    ImageView detailImageView;
    Tara taraFromCoutriesActivity;

    private TextView tvOfficialLanguage;
    private TextView tvOfficialLanguageEmpty;

    private TextView tvCurrency;
    private TextView tvCurrencyEmpty;

    private TextView tvNumberOfTouristsPerYear;
    private TextView tvNumberOfTouristsPerYearEmpty;

    private TextView tvCapitalName;
    private TextView tvCapitalNameEmpty;

    private TextView tvCapitalDensity;
    private TextView tvCapitalDensityEmpty;

    private TextView tvTouristsAttraction;
    private TextView tvTouristsAttractionEmpty;

    private TextView tvTouristsAttraction1;
    private TextView tvTouristsAttractionEmpty1;

    private TextView tvTouristsAttraction2;
    private TextView tvTouristsAttractionEmpty2;

    private List<TaraDB> listaTaridb=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_countries_detail);

        initComponents();

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {

            detailImageView.setImageResource(mBundle.getInt("countryFlag"));
        }
        taraFromCoutriesActivity = (Tara) getIntent().getSerializableExtra(SearchCountriesActivity.KEY_PARSE_TARA);
        //Toast.makeText(getApplicationContext(), taraFromCoutriesActivity.toString(), Toast.LENGTH_LONG).show();

        getAll();

        setareDateTara(taraFromCoutriesActivity);

    }

    private void initComponents() {

        detailImageView = findViewById(R.id.search_countries_detail_activity_image);
        tvOfficialLanguage =  findViewById(R.id.search_countries_detail_activity_tv_limba);
        tvOfficialLanguageEmpty =  findViewById(R.id.search_countries_detail_activity_tv_limba_empty);

        tvCurrency =  findViewById(R.id.search_countries_detail_activity_tv_moneda);
        tvCurrencyEmpty =  findViewById(R.id.search_countries_detail_activity_tv_moneda_empty);

        tvNumberOfTouristsPerYear =  findViewById(R.id.search_countries_detail_activity_tv_turisti);
        tvNumberOfTouristsPerYearEmpty =  findViewById(R.id.search_countries_detail_activity_tv_turisti_empty);

        tvCapitalName =  findViewById(R.id.search_countries_detail_activity_tv_nume_capitala);
        tvCapitalNameEmpty =  findViewById(R.id.search_countries_detail_activity_tv_nume_capitala_empty);

        tvCapitalDensity =  findViewById(R.id.search_countries_detail_activity_tv_densitate_cap);
        tvCapitalDensityEmpty =  findViewById(R.id.search_countries_detail_activity_tv_densitate_cap_empty);

        tvTouristsAttraction =  findViewById(R.id.search_countries_detail_activity_tv_obiective_turistice);
        tvTouristsAttractionEmpty =  findViewById(R.id.search_countries_detail_activity_tv_obiective_turistice_empty);

        tvTouristsAttraction1 =  findViewById(R.id.search_countries_detail_activity_tv_obiective_turistice1);
        tvTouristsAttractionEmpty1 =  findViewById(R.id.search_countries_detail_activity_tv_obiective_turistice_empty1);

        tvTouristsAttraction2 =  findViewById(R.id.search_countries_detail_activity_tv_obiective_turistice2);
        tvTouristsAttractionEmpty2 =  findViewById(R.id.search_countries_detail_activity_tv_obiective_turistice_empty2);
    }

    private void setareDateTara(Tara tara){
        tvOfficialLanguageEmpty.setText(tara.getLimbaOficiala());
        tvCurrencyEmpty.setText(tara.getMoneda());
        tvNumberOfTouristsPerYearEmpty.setText(tara.getNrTuristiAn());
        tvCapitalNameEmpty.setText(tara.getCapitala().getNume());
        tvCapitalDensityEmpty.setText(tara.getCapitala().getDensitate());
        tvTouristsAttractionEmpty.setText(tara.getCapitala().getObiectiveTuristice().get(0));
        tvTouristsAttractionEmpty1.setText(tara.getCapitala().getObiectiveTuristice().get(1));
        tvTouristsAttractionEmpty2.setText(tara.getCapitala().getObiectiveTuristice().get(2));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_favorite:
                if(!existaInDB(listaTaridb)){
                    insertIntoDB();
                    getAll();
                }else{
                    Toast.makeText(getApplicationContext(), R.string.already_favorite,Toast.LENGTH_LONG).show();
                }


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private boolean existaInDB(List<TaraDB> tari){
        for (TaraDB tara:
             tari) {
            if(tara.getNume().equals(taraFromCoutriesActivity.getNume())){
                return true;
            }
        }
        return false;

    }
    private TaraDB getCountryForSaveInDb() {
        return new TaraDB(taraFromCoutriesActivity.getNume(),
                taraFromCoutriesActivity.getLimbaOficiala(),
                taraFromCoutriesActivity.getMoneda(),
                taraFromCoutriesActivity.getNrTuristiAn(),
                taraFromCoutriesActivity.getCapitala().getNume(),
                taraFromCoutriesActivity.getCapitala().getDensitate(),
                taraFromCoutriesActivity.getCapitala().getObiectiveTuristice().get(0),
                taraFromCoutriesActivity.getCapitala().getObiectiveTuristice().get(1),
                taraFromCoutriesActivity.getCapitala().getObiectiveTuristice().get(2));

    }

    @SuppressLint("StaticFieldLeak")
    private void insertIntoDB() {
        new TaraService.Insert(getApplicationContext()) {

            @Override
            protected void onPostExecute(TaraDB taraDB) {
                Toast.makeText(getApplicationContext(), R.string.sucess_insert, Toast.LENGTH_LONG).show();
            }
        }.execute(getCountryForSaveInDb());
    }

    @SuppressLint("StaticFieldLeak")
    private void getAll() {
        new TaraService.GetAll(getApplicationContext()) {
            @Override
            protected void onPostExecute(List<TaraDB> taraDBS) {
               listaTaridb.addAll(taraDBS);
            }
        }.execute();
    }








}