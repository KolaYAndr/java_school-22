package src.ru.croc.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    public static void main(String[] args) {
        String source = """
                         /*
                         * My first ever program in Java!
                         */
                         class Hello { // class body starts here

                            /* main method */
                            public static void main(String[] args/* we put command line arguments here*/) {
                                // this line prints my first greeting to the screen
                                System.out.println("Hi!"); // :)
                            }
                         } // the end
                           // to be continued...
                """;
        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }

    public static String removeJavaComments(String source) {
        Pattern doubleSlash = Pattern.compile("^//.$");
        Matcher matcher = doubleSlash.matcher(source);
        StringBuilder str = new StringBuilder();
        while(matcher.find()){
            str.append(source, matcher.start(), matcher.end());
        }

        return str.toString();
    }

}
