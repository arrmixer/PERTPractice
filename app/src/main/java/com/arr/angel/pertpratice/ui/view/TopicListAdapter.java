package com.arr.angel.pertpratice.ui.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.TopicListItemBinding;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.TopicHolder> {

    //     Member variable to handle item clicks
    private final ItemClickListener mItemClickListener;

    //    Class variables for the List that holds RecipeViewModel and the Context
    private final Context mContext;
    private final TopicViewModel mTopicViewModel;

    public TopicListAdapter(ItemClickListener mItemClickListener, Context mContext, TopicViewModel mTopicViewModel) {
        this.mItemClickListener = mItemClickListener;
        this.mContext = mContext;
        this.mTopicViewModel = mTopicViewModel;
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

        Topic topic = mTopicViewModel.getLiveTopicListData().getValue().get(position);
        topicHolder.bindTopic(topic);

    }

    @Override
    public int getItemCount() {
        if(mTopicViewModel != null){
            return mTopicViewModel.getLiveTopicListData().getValue().size();
        }else {
            return 0;
        }

    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    class TopicHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TopicListItemBinding mTopicListItemBinding;

        private Topic mTopic;

        private TopicHolder(TopicListItemBinding binding) {
            super(binding.getRoot());

            //assign instance of RecipeListItemBinding to parameter
            mTopicListItemBinding = binding;

            //set click event to each itemView
            itemView.setOnClickListener(this);

        }

        private void bindTopic(Topic topic) {
            mTopic = topic;
            mTopicViewModel.setTopic(mTopic);
            String title = mTopicViewModel.getName();
            mTopicListItemBinding.textViewTopic.setText(title);

            Drawable img = mContext.getDrawable(R.drawable.ic_udacity);
            mTopicListItemBinding.imageTopic.setImageDrawable(img);

        }


        @Override
        public void onClick(View view) {
            int elementId = getAdapterPosition();
            mItemClickListener.onItemClickListener(elementId);
        }
    }
}
