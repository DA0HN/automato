package automato;

import automato.rules.Parameter;
import automato.rules.Rules;

import java.util.Arrays;
import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class Automato {

    private final Rules rules;
    private final boolean verbose;

    public Automato(Rules rules, boolean verbose) {
        this.rules = rules;
        this.verbose = verbose;
    }

    public boolean evaluateExpression(String expression) {
        final String[] analyzedArray = parseExpression(expression);
        final List<String> finalState = rules.getConfig().getFinalState();
        String currentState = rules.getConfig().getInitialState();

        int counter = 0;

        while(!finalState.contains(currentState) && counter < analyzedArray.length) {

            if(!isCharAnalyzable(analyzedArray[counter])){
                throw new IllegalArgumentException("Não é possivel analisar: " + analyzedArray[counter]);
            }
            currentState = rules.nextState(currentState, analyzedArray[counter]);
            counter++;
        }
        return finalState.contains(currentState);
    }
    private boolean isCharAnalyzable(String str) {
        return rules.getConfig().getAlphabet().contains(str);
    }

    private String[] parseExpression(String expression) {
        String[] temp = expression.split(",");
        return Arrays.stream(temp)
                .map(String::trim)
                .toArray(String[]::new);
    }

}
