package eu.execom.helenazecevic.monumentum.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import eu.execom.helenazecevic.monumentum.NewMonumentActivity_;
import eu.execom.helenazecevic.monumentum.R;
import eu.execom.helenazecevic.monumentum.adapters.MonumentsAdapter;
import eu.execom.helenazecevic.monumentum.adapters.MyMonumentsAdapter;
import eu.execom.helenazecevic.monumentum.models.User;
import eu.execom.helenazecevic.monumentum.repository.MonumentDAORepository;
import eu.execom.helenazecevic.monumentum.repository.UserDAORepository;
import eu.execom.helenazecevic.monumentum.utils.FileUtils;

/**
 * Created by Helena Zecevic on 15.05.2016..
 */
@EFragment(R.layout.fragment_my_monuments)
public class MyMonumentsFragment extends Fragment {

    private static final int IMAGE_PICKER_SELECT = 0;

    boolean doubleBackPressed = false;

    static final int REQUEST_IMAGE_CAPTURE = 2;

    private static final String PHOTO_PATH = "PHOTO_PATH";

    private static final String TAG = MyMonumentsFragment.class.getSimpleName();

    String currentPhotoPath;

    @ViewById
    SimpleDraweeView profileImage;

    @ViewById
    TextView username;

    @ViewById
    Button changePic;

    @ViewById
    GridView gridView;

    @Bean
    MyMonumentsAdapter myMonumentsAdapter;

    @Bean
    UserDAORepository userDAORepository;

    @Bean
    MonumentDAORepository monumentDAORepository;

    @Bean
    FileUtils fileUtils;

    @AfterViews
    @UiThread(delay = 100)
    void setAdapter() {
        final User user = userDAORepository.getLoggedInUser();

        if (user.getImageUrl() != null) {
            profileImage.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_FILE_SCHEME).path(user.getImageUrl()).build());
        }

        username.setText(user.getName());
        gridView.setAdapter(myMonumentsAdapter);
        myMonumentsAdapter.setMonuments(monumentDAORepository.findMonumentsByUser());

    }

    @Override
    public void onResume() {
        super.onResume();

        if (myMonumentsAdapter != null) {
            myMonumentsAdapter.setMonuments(monumentDAORepository.findMonumentsByUser());
        }
    }

    @Click
    void changePic() {

        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                final File photoFile = fileUtils.createImage();
                currentPhotoPath = photoFile.getAbsolutePath();

                takePicture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }

    }

    @OnActivityResult(REQUEST_IMAGE_CAPTURE)
    void onResult(int resultCode, Intent data) {
        userDAORepository.getLoggedInUser().setImageUrl(currentPhotoPath);
        userDAORepository.updatePicture(currentPhotoPath);
        profileImage.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_FILE_SCHEME).path(currentPhotoPath).build());
    }


}

