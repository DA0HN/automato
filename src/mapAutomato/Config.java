package mapAutomato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class Config {

    private List<String> finiteState = new ArrayList<>();
    private List<String> alphabet = new ArrayList<>();
    private String initialState;
    private List<String> finalState = new ArrayList<>();


    public Config(String finiteState, String alphabet, String initialState, String finalState) {
        setFiniteState(finiteState);
        setAlphabet(alphabet);
        setInitialState(initialState);
        setFinalState(finalState);
    }

    public List<String> getFiniteState() {
        return finiteState;
    }

    private void setFiniteState(String finiteState) {
        this.finiteState.addAll(Arrays.asList(trimAndRemoveSpace(finiteState)));
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    private void setAlphabet(String alphabet) {
        this.alphabet.addAll(Arrays.asList(trimAndRemoveSpace(alphabet)));
    }

    public String getInitialState() {
        return initialState;
    }

    private void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public List<String> getFinalState() {
        return finalState;
    }

    private void setFinalState(String finalState) {

        this.finalState.addAll(Arrays.asList(trimAndRemoveSpace(finalState)));
    }

    private String[] trimAndRemoveSpace(String str){
        String[] arr = str.split(",");
        arr = Arrays.stream(arr)
                .map(String::trim)
                .toArray(String[]::new);
        return arr;
    }

    @Override
    public String toString() {
        return "{" +
                "finiteState=" + finiteState +
                ", alphabet=" + alphabet +
                ", initialState='" + initialState + '\'' +
                ", finalState=" + finalState +
                '}';
    }
}
