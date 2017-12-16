package eu.execom.helenazecevic.monumentum.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import eu.execom.helenazecevic.monumentum.models.Monument;
import eu.execom.helenazecevic.monumentum.views.MyMonumentsView;
import eu.execom.helenazecevic.monumentum.views.MyMonumentsView_;

/**
 * Created by Helena Zecevic on 17.05.2016..
 */
@EBean
public class MyMonumentsAdapter extends BaseAdapter {

    private List<Monument> monuments;

    @RootContext
    Context context;

    @AfterInject
    void afterInject() { monuments = new ArrayList<>(); }

    public List<Monument> getMonuments() {
        return monuments;
    }

    public void setMonuments(List<Monument> monuments) {
        this.monuments = monuments;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return monuments.size();
    }

    @Override
    public Object getItem(int i) {
        return monuments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyMonumentsView myMonumentsView;

        if (view == null) {
            myMonumentsView = MyMonumentsView_.build(context);
        } else {
            myMonumentsView = (MyMonumentsView) view;
        }

        myMonumentsView.bind((Monument) getItem(i));

        return myMonumentsView;
    }
}
