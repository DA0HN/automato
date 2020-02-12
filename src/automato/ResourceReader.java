package automato;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class ResourceReader {

    public AutomatoRules readAutomataRules(String path, boolean verbose) {
        Config config = null;
        List<Parameter> function = null;

        try ( BufferedReader buffer = Files.newBufferedReader(Path.of(path)) ) {
            int pointer = 0;

            List<String> configData = new ArrayList<>();
            List<String[]> functionData = new ArrayList<>();

            while(buffer.ready()) {
                String line = buffer.readLine();
                if( pointer < 4)
                    configData.add(line);
                else{
                    String[] temp = line.split(",");
                    functionData.add(Arrays.stream(temp)
                                     .map(String::trim)
                                     .toArray(String[]::new)
                    );
                }

                pointer++;
            }

            config = instantiateConfig(configData.get(0),       // estados
                                           configData.get(1),   // alfabeto
                                           configData.get(2),   // estado inicial
                                           configData.get(3));  // estado final

            function = instantiateTransitionFunction(functionData);

            if( verbose ){
                System.out.println(config);
                System.out.println("---------------");
                function.forEach(System.out::println);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return new AutomatoRules(function, config);
    }

    private List<Parameter> instantiateTransitionFunction(List<String[]> function) {
        List<Parameter> transitionRules = new ArrayList<>();

        for(String[] command : function) {
            transitionRules.add(new Parameter(command[0],   // estado atual
                                              command[1],   // string de entrada
                                              command[2])   // proximo estado
            );

        }
        return transitionRules;
    }

    private Config instantiateConfig(String states, String alphabet, String initialState, String finalState) {
        return new Config(states,
                           alphabet,
                           initialState,
                           finalState);
    }


}
