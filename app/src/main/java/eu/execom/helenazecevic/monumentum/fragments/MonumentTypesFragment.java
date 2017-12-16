package eu.execom.helenazecevic.monumentum.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import eu.execom.helenazecevic.monumentum.R;
import eu.execom.helenazecevic.monumentum.adapters.MonumentTypesAdapter;
import eu.execom.helenazecevic.monumentum.repository.MonumentTypeDAORepository;

/**
 * Created by Helena Zecevic on 15.05.2016..
 */
@EFragment(R.layout.fragment_monument_types)
public class MonumentTypesFragment extends Fragment {

    @ViewById
    SwipeRefreshLayout swipeRefresh;

    @ViewById
    ListView listView;

    @Bean
    MonumentTypesAdapter monumentTypesAdapter;

    @Bean
    MonumentTypeDAORepository monumentTypeDAORepository;

    @AfterViews
    @UiThread(delay = 100)
    void setAdapter() {
        listView.setAdapter(monumentTypesAdapter);
        monumentTypesAdapter.setTypes(monumentTypeDAORepository.findAll());

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                monumentTypesAdapter.setTypes(monumentTypeDAORepository.findAll());
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        monumentTypesAdapter.setTypes(monumentTypeDAORepository.findAll());
    }
}
