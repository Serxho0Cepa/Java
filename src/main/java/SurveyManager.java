import java.util.*;

class SurveyManager {
    private List<Survey> surveys;    //perdoret liste sepse ruajme renditjen
    private Set<Candidate> allCandidates;

    public SurveyManager() {
        this.surveys = new ArrayList<>();
        this.allCandidates = new HashSet<>();
    }

    public void addSurvey(Survey survey) {
        if (survey.isValid()) {
            surveys.add(survey);
        } else {
            throw new IllegalArgumentException("Invalid survey");
        }
    }

    public List<Survey> getAllSurveys() {
        return new ArrayList<>(surveys);
    }

    public Survey getSurveyByTitle(String title) {
        for (Survey survey : surveys) {
            if (survey.getTitle().equalsIgnoreCase(title)) {
                return survey;
            }
        }
        return null;
    }

    public Candidate getMostActiveCandidates() {
        Candidate mostActive = null;
        int maxSurveys = -1;

        for (Candidate candidate : allCandidates) {
            if (candidate.getSurveyCount() > maxSurveys) {
                maxSurveys = candidate.getSurveyCount();
                mostActive = candidate;
            }
        }
        return mostActive;
    }

        public void registerSurveyAnswers(Survey survey, Candidate candidate, Map<Question, Answer> answers) {

            for (int i = 0; i < answers.size(); i++) {
                Question question = (Question) answers.keySet().toArray()[i];
                Answer answer = answers.get(question);
                question.addAnswer(candidate, answer);
            }
            candidate.addSurvey(survey);
            allCandidates.add(candidate);
        }


}