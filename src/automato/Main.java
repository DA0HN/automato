package automato;

import automato.extract.ExtractListImpl;
import automato.extract.ExtractMapImpl;
import automato.extract.ExtractService;
import automato.rules.Rules;
import automato.rules.RulesListImpl;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String str  = "2, 2, 1, 1";
        String str1 = "2, 2, 2";
        String str2 = "1, 1, 1, 1, 1, 1";
        String str3 = "2, 1, 1, 1, 1";

        ExtractService service = new ExtractMapImpl();

        Rules rules = new ResourceReader(service)
                .readAutomatoRules("src/resources/input.txt", false);

        var automato = new Automato(rules, true);

        boolean isAccepted = automato.evaluateExpression(str);
        boolean isAccepted1 = automato.evaluateExpression(str);
        boolean isAccepted2 = automato.evaluateExpression(str);
        boolean isAccepted3 = automato.evaluateExpression(str);

        print(isAccepted, str);
        print(isAccepted1, str1);
        print(isAccepted2, str2);
        print(isAccepted3, str3);

    }

    private static void print(boolean isAccepted, String str) {
        if(isAccepted) {
            System.out.println("Accept: " + str);
        } else {
            System.out.println("Not accept: " + str);
        }
    }
}
