package mapAutomato;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class Parameter {

    private String requiredState;
    private String requiredValue;

    public Parameter(String requiredState, String requiredValue) {
        this.requiredState = requiredState;
        this.requiredValue = requiredValue;
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
}
