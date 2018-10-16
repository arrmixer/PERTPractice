package com.arr.angel.pertpratice.ui.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.OverallResultListItemBinding;
import com.arr.angel.pertpratice.model.Topic;

import java.util.List;

public class OverallResultsAdapter extends RecyclerView.Adapter<OverallResultsAdapter.TopicHolder> {


    //    Class variables for the List that holds RecipeViewModel and the Context
    private final Context mContext;
    private final List<Topic> topics;


    public OverallResultsAdapter(Context mContext, List<Topic> topics) {

        this.mContext = mContext;
        this.topics = topics;
    }

    @NonNull
    @Override
    public TopicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //get inflater from container Activity
        LayoutInflater inflater = LayoutInflater.from(mContext);

        OverallResultListItemBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.overall_result_list_item, parent, false);


        return new TopicHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicHolder topicHolder, int position) {

        Topic topic = topics.get(position);
        topicHolder.bindTopic(topic);

    }

    @Override
    public int getItemCount() {

        if (!topics.isEmpty()) {
            return topics.size();
        } else {
            return 0;
        }

    }


    class TopicHolder extends RecyclerView.ViewHolder {

        private final OverallResultListItemBinding overallResultListItemBinding;


        private TopicHolder(OverallResultListItemBinding binding) {
            super(binding.getRoot());

            //assign instance of RecipeListItemBinding to parameter
            overallResultListItemBinding = binding;


        }

        private void bindTopic(Topic topic) {
            String title = topic.getName();
            int resultPercentage = topic.getResultPercentage();

            //format String percentage
            String resultPercentageString = mContext.getString(R.string.percentage, resultPercentage);

            overallResultListItemBinding.textViewTopicTile.setText(title);

            overallResultListItemBinding.textViewTopicResult.setText(resultPercentageString);


        }


    }
}

