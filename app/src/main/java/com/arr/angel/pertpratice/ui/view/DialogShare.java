package com.arr.angel.pertpratice.ui.view;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ShareBottomSheetBinding;

public class DialogShare extends BottomSheetDialogFragment {
    public static final String ARGS_TOPIC_RESULT = "com.arr.angel.pertpratice.ui.view";
    private ShareBottomSheetBinding shareBottomSheetBinding;

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

        twitterIcon.setOnClickListener(view -> {
            //TODO use app url: String url = "http://www.twitter.com/intent/tweet?url=YOURURL&text=YOURTEXT";
            String baseURL = "http://www.twitter.com/intent/tweet?text=";
            String addAppStoreUrl = "url=YOURURL";

            StringBuilder url = new StringBuilder();
            url.append(baseURL);
            url.append(message);

            Intent share = new Intent(Intent.ACTION_VIEW);
            share.setData(Uri.parse(url.toString()));
            startActivity(share);
        });

        messageIcon.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });

    }
}
