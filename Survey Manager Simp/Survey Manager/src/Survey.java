import java.util.*;
import java.util.stream.Collectors;

class Survey {
    private String title;
    private String topic;
    private String description;
    private List<Question> questions;
    private final Set<Candidate> candidates;

    public Survey(String title, String topic, String description) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.questions = new ArrayList<>();
        this.candidates = new HashSet<>();
    }

    // Shtimi i nje pyetje ne sondazh
    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
    }

    // Fshirja e nje pyetje nga sondazhi
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    // Vleresimi i sondazhit qe te kete mbi 10 pyetje dhe nen 40 pyetje
    public boolean isValid() {

        if (questions.size() < 10 || questions.size() > 40) {
            return false;
        }
        for (int i = 0; i < questions.size(); i++) {
            for (int j = i + 1; j < questions.size(); j++) {
                if (questions.get(i).getQuestionText().equals(questions.get(j).getQuestionText())) {
                    return false;
                }
            }
        }

        return true;
    }


    // Gjej pergjigjen te dhene me shpesh ne sondazh
    public Answer getMostGivenAnswer() {
        Map<Answer, Integer> answerCounts = new HashMap<>();

        for (Question question : questions) {
            for (Answer answer : question.getAnswers().values()) {
                if (answerCounts.containsKey(answer)) {
                    answerCounts.put(answer, answerCounts.get(answer) + 1);
                } else {
                    answerCounts.put(answer, 1);
                }
            }
        }

        Answer mostGivenAnswer = null;
        int maxCount = 0;

        for (Map.Entry<Answer, Integer> entry : answerCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostGivenAnswer = entry.getKey();
            }
        }
        return mostGivenAnswer;
    }



    // Printimi i rezultateve te sondazhit
    public void printResults() {
        System.out.println("Survey Results for: " + title);

        for (Question question : questions) {
            System.out.println("\nQuestion: " + question.getQuestionText());

            Map<Answer, Integer> answerCounts = new HashMap<>();

            for (Answer answer : question.getAnswers().values()) {
                if (answerCounts.containsKey(answer)) {
                    answerCounts.put(answer, answerCounts.get(answer) + 1);
                } else {
                    answerCounts.put(answer, 1);
                }
            }
            for (Answer answer : Answer.values()) {
                System.out.printf("%s: %d\n", answer, answerCounts.getOrDefault(answer, 0));
            }
        }
    }


    // Gjetja e pergjigjeve te dhene nga nje kandidat specifik
    public Map<String, Answer> getCandidateAnswers(Candidate candidate) {
        Map<String, Answer> candidateAnswers = new HashMap<>();

        for (Question question : questions) {
            Answer answer = question.getAnswers().get(candidate);

            if (answer == null) {
                candidateAnswers.put(question.getQuestionText(), Answer.NO_ANSWER);
            } else {
                candidateAnswers.put(question.getQuestionText(), answer);
            }
        }
        return candidateAnswers;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    //heqja e pyetjeve qe nuk i jane pergjigjur 50% e kandidateve
    public void removeUnderAnsweredQuestions() {
        int minimumAnswers = candidates.size() / 2;
        List<Question> questionsToRemove = new ArrayList<>();

        for (Question question : questions) {
            if (question.getAnswers().size() < minimumAnswers) {
                questionsToRemove.add(question);
            }
        }

        for (Question question : questionsToRemove) {
            questions.remove(question);
        }
    }


    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}