package com.oobootcamp;

public class StringUtil {
    public static String indent(int level){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
             sb.append(" ");
        }
        return sb.toString();
    }

    public static String formatReportString(int level, String parkableType, int totalParkableCar, int totalParkableAvailSpace) {
        String newLine = "";
        if(level > 0){
            newLine = "\n";
        }
        return newLine + indent(level) + parkableType + " " + totalParkableCar + " " + totalParkableAvailSpace;
    }
}
