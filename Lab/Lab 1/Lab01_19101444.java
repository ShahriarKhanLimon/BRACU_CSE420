import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab01_19101444 {

    public static void main(String[] args) {
        
        //making arrays of java keywords and other default expressions
        String[] mathOperators={"+", "-", "*", "/", "="};
        String[] logicalOperators={"<", ">", "<=", ">=", "=="};
        String[] others={",", ";", "(", ")", "{", "}", "[", "]"};
        String[]  keywords={"abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};
        

        String[][] arr1={keywords, mathOperators, logicalOperators, others};
        
        //making arrayList for storing
        
        ArrayList<String> foundMathOperators=new ArrayList<String>();
        ArrayList<String> foundLogicalOperators=new ArrayList<String>();
        ArrayList<String> foundOthers=new ArrayList<String>();
        ArrayList<String> foundIdentifiers=new ArrayList<String>();
        ArrayList<String> foundKeywords=new ArrayList<String>();
        ArrayList<String> foundNumbers=new ArrayList<String>();

        ArrayList[] arr2={foundKeywords, foundMathOperators, foundLogicalOperators, foundOthers};

        try {
            File is=new File("G://Semesters material//Spring 2022//CSE420//Labs//Lab 1//File.txt");
            Scanner in=new Scanner(is);
            String str="";
            while (in.hasNextLine()) {
                str+=in.nextLine()+" ";
            }

            //to store values in the first four arrayLists
            for (int i=0;i<arr1.length;i++) {
                for (int j=0;j<arr1[i].length; j++) {
                    if (str.contains(arr1[i][j])) {
                        arr2[i].add(arr1[i][j]);
                        str = str.replace(arr1[i][j], " ");
                    }
                }
            }

            //to pass the rest of the string to scanner for identifying each and every word
            Scanner lmn=new Scanner(str);
            while (lmn.hasNext()) {
                String s=lmn.next();
                if (s.startsWith("0") || s.startsWith("1") || s.startsWith("2") || s.startsWith("3") || s.startsWith("4") || s.startsWith("5") || s.startsWith("6") || s.startsWith("7") || s.startsWith("8") || s.startsWith("9")) {
                    foundNumbers.add(s);
                } else {
                    foundIdentifiers.add(s);
                }
            }

            //to make the arrayLists unique
            foundNumbers=(ArrayList) foundNumbers.stream().distinct().collect(Collectors.toList());
            foundIdentifiers=(ArrayList) foundIdentifiers.stream().distinct().collect(Collectors.toList());

            //to print the arrayLists
            int size;
            ArrayList list;
            for (int i=0;i<5;i++) {

                if (i==0) {
                    list=foundKeywords;
                    System.out.print("Keywords: ");
                } else if (i==1) {
                    list=foundIdentifiers;
                    System.out.print("Identifiers: ");
                } else if (i==2) {
                    list = foundMathOperators;
                    System.out.print("Math Operators: ");
                } else if (i==3) {
                    list = foundLogicalOperators;
                    System.out.print("Logical Operators: ");
                } else {
                    list=foundNumbers;
                    System.out.print("Numerical Values: ");
                }
                size = list.size();
                for (int j=0;j<size-1;j++) {
                    System.out.print(list.get(j) + ", ");
                }
                System.out.println(list.get(size - 1));
            }

            System.out.print("Others: ");
            list=foundOthers;
            size=list.size();
            for (int j=0;j<size-1;j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println(list.get(size-1));

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}