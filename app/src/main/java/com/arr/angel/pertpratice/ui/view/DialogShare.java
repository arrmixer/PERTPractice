package com.arr.angel.pertpratice.ui.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ShareBottomSheetBinding;

import static java.net.Proxy.Type.HTTP;

public class DialogShare extends BottomSheetDialogFragment {


    public static final String ARGS_TOPIC_RESULT = "com.arr.angel.pertpratice.ui.view";

    //dataBinding placeholder
    private ShareBottomSheetBinding shareBottomSheetBinding;

    //views
    ImageView twitterIcon;
    ImageView messageIcon;



    private String message;


    private int topicResults;

    public static DialogShare newInstance(int result) {

        DialogShare dialogShare = new DialogShare();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_TOPIC_RESULT, result);
        dialogShare.setArguments(bundle);

        return dialogShare;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //make sure bundle has int value
        if (getArguments() != null) {
            topicResults = getArguments().getInt(ARGS_TOPIC_RESULT);
        }

        shareBottomSheetBinding = DataBindingUtil.inflate(
                inflater, R.layout.share_bottom_sheet, container, false
        );

        twitterIcon = shareBottomSheetBinding.imgTwitter;
        messageIcon = shareBottomSheetBinding.imgMessage;



        return shareBottomSheetBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        message = getString(R.string.share, topicResults);

        twitterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                I would use a link to my app on the play store once it's publish
//                String url = "http://www.twitter.com/intent/tweet?url=YOURURL&text=YOURTEXT";
                String baseURL = "http://www.twitter.com/intent/tweet?text=";
                String addAppStoreUrl = "url=YOURURL";

                StringBuilder url = new StringBuilder();
                url.append(baseURL);
                url.append(message);

                Intent share = new Intent(Intent.ACTION_VIEW);
                share.setData(Uri.parse(url.toString()));
                startActivity(share);

            }
        });

        messageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });




    }
}
