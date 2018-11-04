package com.arr.angel.pertpratice.ui.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.TopicListItemBinding;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.TopicHolder> {

    //     Member variable to handle item clicks
    private final ItemClickListener mItemClickListener;

    //    Class variables for the List that holds RecipeViewModel and the Context
    private final Context mContext;
    private final List<Topic> topics;


    public TopicListAdapter(ItemClickListener mItemClickListener, Context mContext, List<Topic> topics) {
        this.mItemClickListener = mItemClickListener;
        this.mContext = mContext;
        this.topics = topics;
    }

    @NonNull
    @Override
    public TopicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //get inflater from container Activity
        LayoutInflater inflater = LayoutInflater.from(mContext);

        TopicListItemBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.topic_list_item, parent, false);


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

    public interface ItemClickListener {
        void onItemClickListener(int itemId, String tag);
    }

    class TopicHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TopicListItemBinding mTopicListItemBinding;

        private Button practice;
        private Button results;

        private TopicHolder(TopicListItemBinding binding) {
            super(binding.getRoot());

            //assign instance of RecipeListItemBinding to parameter
            mTopicListItemBinding = binding;

            practice = binding.buttonPractice;
            results = binding.buttonResults;


            //set click event to each itemView
//            itemView.setOnClickListener(this);
            results.setOnClickListener(this);
            results.setTag(mContext.getResources().getString(R.string.topic_results));
            practice.setOnClickListener(this);
            practice.setTag(mContext.getResources().getString(R.string.topic_practice));

        }

        private void bindTopic(Topic topic) {
            String title = topic.getName();
            mTopicListItemBinding.textViewTopic.setText(title);

            Drawable img = mContext.getDrawable(R.drawable.ic_pert_icon);
            mTopicListItemBinding.imageTopic.setImageDrawable(img);
            mTopicListItemBinding.imageTopic.setContentDescription(mContext.getString(R.string.app_name));

        }

        @Override
        public void onClick(View view) {
            int elementId = getAdapterPosition();
            mItemClickListener.onItemClickListener(elementId, view.getTag().toString());
        }

    }
}
