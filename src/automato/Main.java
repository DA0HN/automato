package automato;

import automato.extract.ExtractListImpl;
import automato.extract.ExtractMapImpl;
import automato.extract.ExtractService;
import automato.rules.Rules;

public class Main {

    public static void main(String[] args) {

        String str = "2, 1, 2, 1";
        String str1 = "2, 2, 2";
        String str2 = "1, 1, 1, 1, 1, 1";
        String str3 = "2, 1, 1, 1, 1";

        Rules rules = new ResourceReader(new ExtractListImpl()).readAutomataRules("src/resources/input.txt", false);

        Automato auto = new Automato(rules, true);
        boolean isAccepted = auto.evaluateExpression(str);
        boolean isAccepted1 = auto.evaluateExpression(str);
        boolean isAccepted2 = auto.evaluateExpression(str);
        boolean isAccepted3 = auto.evaluateExpression(str);

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
