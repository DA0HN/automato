package automato.rules;

import automato.Config;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public interface Rules {

    String nextState(String currentState, String currentValue);
    Config getConfig();
}
