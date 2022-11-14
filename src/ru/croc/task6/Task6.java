package ru.croc.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    public static void main(String[] args) {
        //пример строки кода
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
                           // to be continued...""";
        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }

    public static String removeJavaComments(String source) {
        source = removeDoubleSlash(source);
        return removeMultiline(source);
    }

    private static String removeDoubleSlash(String source){
        StringBuilder stb = new StringBuilder();
        Pattern doubleSlash = Pattern.compile("/{2}.+");
        Matcher matcher = doubleSlash.matcher(source);

        while(matcher.find()){
            matcher.appendReplacement(stb, "");
        }

        return stb.toString();
    }


    private static String removeMultiline(String source){
        StringBuilder strb = new StringBuilder();
        Pattern multiline = Pattern.compile("(/\\*).+?(\\*/)", Pattern.DOTALL);
        Matcher matcher = multiline.matcher(source);

        while(matcher.find()){
            matcher.appendReplacement(strb, "");
        }

        return strb.toString();
    }
}
