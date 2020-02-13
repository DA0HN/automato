package automato.rules;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class Parameter {

    private String requiredState;
    private String requiredValue;
    private String nextState;

    public Parameter(String requiredState, String requiredValue, String nextState) {
        this.requiredState = requiredState;
        this.requiredValue = requiredValue;
        this.nextState = nextState;
    }

    public String getRequiredState() {
        return requiredState;
    }

    public void setRequiredState(String requiredState) {
        this.requiredState = requiredState;
    }

    public String getRequiredValue() {
        return requiredValue;
    }

    public void setRequiredValue(String requiredValue) {
        this.requiredValue = requiredValue;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "{" +
                "requiredState='" + requiredState + '\'' +
                ", requiredValue='" + requiredValue + '\'' +
                ", nextState='" + nextState + '\'' +
                '}';
    }
}
