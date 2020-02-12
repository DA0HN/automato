package automato;

import java.util.Arrays;
import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class Automato {

    private final AutomatoRules rules;
    private final boolean verbose;

    public Automato(AutomatoRules rules, boolean verbose) {
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
            currentState = transitionFunction(currentState, analyzedArray[counter]);
            counter++;
        }
        return finalState.contains(currentState);
    }

    private boolean isCharAnalyzable(String str) {
        return rules.getConfig().getAlphabet().contains(str);
    }

    private String transitionFunction(String currentState, String currentData) {
        for(Parameter param : rules.getParameter()) {
            if(param.getRequiredState().equals(currentState) && currentData.equals(param.getRequiredValue())) {
                if( verbose ) {
                    System.out.printf("%3.1s | %3.1s -> %3.1s%n", currentData, currentState, param.getNextState());
                }
                return param.getNextState();
            }
        }
        throw new IllegalStateException("O estado ou o dado atual não estão sendo reconhecidos");
    }

    private String[] parseExpression(String expression) {
        String[] temp = expression.split(",");
        return Arrays.stream(temp)
                .map(String::trim)
                .toArray(String[]::new);

    }

}
