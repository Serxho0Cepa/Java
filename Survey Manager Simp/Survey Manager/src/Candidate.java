import java.util.*;

class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<Survey> takenSurveys;   //pa dublikim

    public Candidate(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.takenSurveys = new HashSet<>(); //implementim i Set , i cili nuk lejon dublikim
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addSurvey(Survey survey) {
        takenSurveys.add(survey);
    }

    public int getSurveyCount() {
        return takenSurveys.size();
    }
}
