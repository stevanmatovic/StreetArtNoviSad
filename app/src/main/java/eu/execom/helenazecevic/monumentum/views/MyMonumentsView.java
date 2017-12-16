package eu.execom.helenazecevic.monumentum.views;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.widget.TextView;


import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import eu.execom.helenazecevic.monumentum.MonumentFullActivity;
import eu.execom.helenazecevic.monumentum.MonumentFullActivity_;
import eu.execom.helenazecevic.monumentum.R;
import eu.execom.helenazecevic.monumentum.models.Monument;

/**
 * Created by Helena Zecevic on 17.05.2016..
 */
@EViewGroup(R.layout.view_my_monuments)
public class MyMonumentsView extends CardView {

    Monument monument;

    @ViewById
    SimpleDraweeView monumentPicture;

    @Click(R.id.monumentPicture)
    void openFullView() {
        MonumentFullActivity_.intent(getContext()).monumentSend(monument.getId()).start();
    }

    public MyMonumentsView(Context context) {
        super(context);
    }

    public void bind(Monument monument) {
        monumentPicture.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_FILE_SCHEME).path(monument.getImageUrl()).build());
        this.monument = monument;
    }
}
