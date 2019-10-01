package com.arr.angel.pertpratice.ui.view;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.TopicResultListItemBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;



public class TopicResultsAdapter extends RecyclerView.Adapter<TopicResultsAdapter.QuestionHolder> {

    private static String TAG = TopicResultsAdapter.class.getSimpleName();

    //     Member variable to handle item clicks
    private final ItemClickListenerTopicResults itemClickListenerTopicResults;

    //    Class variables for the List that holds RecipeViewModel and the Context
    private final Context mContext;
    private final Topic mTopic;

    public TopicResultsAdapter(ItemClickListenerTopicResults itemClickListenerTopicResults,  Context mContext, Topic mTopic) {
        this.itemClickListenerTopicResults = itemClickListenerTopicResults;
        this.mContext = mContext;
        this.mTopic = mTopic;
    }

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        TopicResultListItemBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.topic_result_list_item, parent, false
        );

        return new QuestionHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder questionHolder, int i) {

        Question question = mTopic.getQuestions().get(i);
        questionHolder.bindQuestion(question, i);
    }

    @Override
    public int getItemCount() {
        return mTopic.getQuestions().size();
    }

    public interface ItemClickListenerTopicResults {
        void onItemClickListener(int itemId);
    }

    class QuestionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TopicResultListItemBinding mTopicResultListItemBinding;

        TextView questionNumber;
        ImageView questionResult;
        TextView  questionUnavailable;


        private QuestionHolder(TopicResultListItemBinding binding) {
            super(binding.getRoot());

            //assign instance of RecipeListItemBinding to parameter
            mTopicResultListItemBinding = binding;

            itemView.setOnClickListener(this);

            questionNumber = binding.textViewTopicResultQuestionTitle;
            questionResult = binding.imageViewTopicResultQuestion;
            questionUnavailable = binding.textViewTopicResultUnavailable;

        }

        private void bindQuestion(Question question, int item) {

            int questionNumberInt = item + 1;
            String questionTitle = mContext.getString(R.string.question, questionNumberInt);
            questionNumber.setText(questionTitle);

            if (question.isCorrect()) {
                Drawable correctImg = mContext.getDrawable(R.drawable.ic_correct);
                questionResult.setContentDescription(mContext.getString(R.string.correct_content_description));
                questionResult.setImageDrawable(correctImg);
            } else if (!question.isCorrect() && question.isAnswered()){
                Drawable incorrectImg = mContext.getDrawable(R.drawable.ic_incorrect);
                questionResult.setContentDescription(mContext.getString(R.string.incorrect_content_description));
                questionResult.setImageDrawable(incorrectImg);
            }else{
                questionResult.setVisibility(View.INVISIBLE);
                questionUnavailable.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onClick(View view) {
            int elementId = getAdapterPosition();
            itemClickListenerTopicResults.onItemClickListener(elementId);
        }

    }
}
