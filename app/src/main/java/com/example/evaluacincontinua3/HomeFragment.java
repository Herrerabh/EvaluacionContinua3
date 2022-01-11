package com.example.evaluacincontinua3;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacincontinua3.network.FoodEntry;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_fragment,container, false);

        setUpToolbar(view);

        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false));
        FoodCardRecyclerViewAdapter adapter=new FoodCardRecyclerViewAdapter(
                FoodEntry.initProductEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        int largePadding =getResources().getDimensionPixelSize(R.dimen.comida_grid_spacing);
        int smallPadding= getResources().getDimensionPixelSize(R.dimen.comida_grid_spacing_small);
        recyclerView.addItemDecoration(new FoodGridItemDecoration(largePadding, smallPadding));
        // set shape corner background for API 23+
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.comida_grid).setBackgroundResource(R.drawable.background_shape);
        }

        MaterialButton configuration_button = view.findViewById(R.id.configuraciones);

        configuration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new ConfigurationFragment(), false);
            }
        });
        return view;
    }

    private void setUpToolbar(View view){
        Toolbar toolbar=view.findViewById(R.id.app_bar);
        AppCompatActivity activity =(AppCompatActivity) getActivity();
        if(activity!=null){
            activity.setSupportActionBar(toolbar);
        }
        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                getContext(),
                view.findViewById(R.id.comida_grid),
                new AccelerateDecelerateInterpolator(),
                getContext().getResources().getDrawable(R.drawable.menu),
                getContext().getResources().getDrawable(R.drawable.cerrar)));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
