package automato.rules;

import automato.Config;

import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public interface Rules {

    public String nextState(String currentState, String currentValue);
    public Config getConfig();
}
