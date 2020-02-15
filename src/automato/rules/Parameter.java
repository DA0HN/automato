package automato.rules;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class Parameter {

    private final String requiredState;
    private final String requiredValue;
    private final String nextState;

    public Parameter(String requiredState, String requiredValue, String nextState) {
        this.requiredState = requiredState;
        this.requiredValue = requiredValue;
        this.nextState = nextState;
    }

    public String getRequiredState() {
        return requiredState;
    }

    public String getRequiredValue() {
        return requiredValue;
    }

    public String getNextState() {
        return nextState;
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
