package com.arr.angel.pertpratice.util;


import com.arr.angel.pertpratice.model.Question;


import java.util.ArrayList;
import java.util.List;

public class QuestionData {

    private List<Question> questionListPraticeTest = new ArrayList<>();
    private List<String> possibleAnswers = new ArrayList<>();


    //adding mock question01 data
    private List<Question> makePracticeTestQuestions(){
        makePossibleAnswers();
        Question question1PT = new Question("PT01");
        Question question2PT = new Question("PT02");
        Question question3PT = new Question("PT03");
        Question question4PT = new Question("PT04");
        Question question5PT = new Question("PT05");
        Question question6PT = new Question("PT06");

        question1PT.setContent("Lorem ipsum dolor sit amet, doming molestie te quo, vim eu lobortis argumentum quaerendum. Ipsum nusquam indoctum eam ad, vidit feugiat platonem eam ex. Reque illum explicari ex ius, no erant vivendum sensibus vis. Eum cu clita libris ancillae. Id pri graeco suavitate. Nulla detraxit sea ei.");
        question1PT.setPossibleAnswers(getPossibleAnswers());
        question1PT.setAnswer(getPossibleAnswers().get(0));


        question2PT.setContent("Probo consetetur mei in. Et elit posse torquatos usu. Sit an denique vituperata. Ne saepe inermis ius, pro dicta detraxit te, ne soleat complectitur mei. Vix ei diceret ancillae signiferumque. Doctus fabulas vim ea.\n" +
                "\n");
        question2PT.setPossibleAnswers(getPossibleAnswers());
        question2PT.setAnswer(getPossibleAnswers().get(1));

        question3PT.setContent("Nam id iusto choro quando. Quo te omittam appareat adipisci, viris ornatus pertinacia vim eu, dolor persius fierent eam ea. Ei eam velit commune deserunt, an mel labore scripta. Harum dissentiunt quo et, sed no utinam evertitur. Duo id quas quidam.");
        question3PT.setPossibleAnswers(getPossibleAnswers());
        question3PT.setAnswer(getPossibleAnswers().get(2));

        question4PT.setContent("Qui et integre intellegam, vidit partiendo cum id, qui duis lorem probatus eu. Qui liber dicunt ut, mea nonumes invenire liberavisse an, vis albucius consetetur dissentiet no. Sit erant efficiendi no, eum cu labores lobortis, cu mel utamur fabellas lobortis. Per ei magna decore doming, vis soluta partiendo imperdiet ut, ea falli cotidieque has.");
        question4PT.setPossibleAnswers(getPossibleAnswers());
        question4PT.setAnswer(getPossibleAnswers().get(3));

        question5PT.setContent("Postea liberavisse ei mei, perfecto consequuntur necessitatibus no vim. Ut melius splendide vis, wisi volumus consulatu sea no, sed ea autem aperiam. Ut equidem inermis mediocrem has. Nam nisl torquatos temporibus ea, id viris blandit intellegam nam, pro id magna eleifend. Ad eius quaestio interpretaris vis.");
        question5PT.setPossibleAnswers(getPossibleAnswers());
        question5PT.setAnswer(getPossibleAnswers().get(0));

        question6PT.setContent("Vim ex nullam accumsan, feugiat omnesque volutpat ei sea, ut essent nostro evertitur vis. Accusam commune no vim, has id eripuit mandamus. Perfecto pericula repudiandae at vel, in munere eloquentiam est. Te usu modus inciderint, ad ullum temporibus eos, mel mundi suscipiantur id.");
        question6PT.setPossibleAnswers(getPossibleAnswers());
        question6PT.setAnswer(getPossibleAnswers().get(1));


        questionListPraticeTest.add(question1PT);
        questionListPraticeTest.add(question2PT);
        questionListPraticeTest.add(question3PT);
        questionListPraticeTest.add(question4PT);
        questionListPraticeTest.add(question5PT);
        questionListPraticeTest.add(question6PT);

        return questionListPraticeTest;
    }

    public List<Question> getQuestionListPracticeTest() {
        return makePracticeTestQuestions();
    }

    public List<String> makePossibleAnswers(){
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";

        possibleAnswers.add(a);
        possibleAnswers.add(b);
        possibleAnswers.add(c);
        possibleAnswers.add(d);

        return possibleAnswers;

    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }
}
