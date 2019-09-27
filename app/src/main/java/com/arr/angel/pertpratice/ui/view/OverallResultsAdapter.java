package com.arr.angel.pertpratice.ui.view;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.OverallResultListItemBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;

import java.util.List;

public class OverallResultsAdapter extends RecyclerView.Adapter<OverallResultsAdapter.TopicHolder> {

    //     Member variable to handle item clicks
    private final ItemClickListenerOverallResults itemClickListenerOverallResults;

    //    Class variables for the List that holds RecipeViewModel and the Context
    private final Context mContext;
    private final List<Topic> topics;


    public OverallResultsAdapter(ItemClickListenerOverallResults itemClickListenerOverallResults, Context mContext, List<Topic> topics) {
        this.itemClickListenerOverallResults = itemClickListenerOverallResults;
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

    public interface ItemClickListenerOverallResults {
        void onItemClickListener(int itemId);
    }


    class TopicHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

        private final OverallResultListItemBinding overallResultListItemBinding;


        private TopicHolder(OverallResultListItemBinding binding) {
            super(binding.getRoot());

            //assign instance of RecipeListItemBinding to parameter
            overallResultListItemBinding = binding;

            itemView.setOnClickListener(this);


        }

        private void bindTopic(Topic topic) {
            String title = topic.getName();
            int resultPercentage = topic.getResultPercentage();
            List<Question> questions = topic.getQuestions();

            //format String percentage
            String resultPercentageString = mContext.getString(R.string.percentage, resultPercentage);

            overallResultListItemBinding.textViewTopicTitle.setText(title);

            //check how many questions answered
            int questionCount = 0;
            for(Question q : questions){
                if(q.isAnswered()){
                    questionCount++;
                }
            }

            //logic to determine if topic was finish or not before showing percentage
            if(questionCount == questions.size()){
                overallResultListItemBinding.textViewTopicResult.setText(resultPercentageString);
            }else if(questionCount > 0 && questionCount < questions.size()){
                overallResultListItemBinding.textViewTopicResult.setText(R.string.incomplete);
            }else{
                overallResultListItemBinding.textViewTopicResult.setText(R.string.start);
            }



        }


        @Override
        public void onClick(View v) {
            int elementId = getAdapterPosition();
            itemClickListenerOverallResults.onItemClickListener(elementId);
        }
    }
}

