package com.oobootcamp;

import java.util.List;

public class ReportUtil {
    private static String indent(int level){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
             sb.append(" ");
        }
        return sb.toString();
    }

    private static String formatReportString(ReportData reportData) {
        String newLine = "";
        if(reportData.getLevel() > 0){
            newLine = "\n";
        }
        return newLine + indent(reportData.getLevel()) + reportData.getParkableType() + " " + reportData.getTotalCars() + " " + reportData.getAvailableSpaces();
    }

    public static String printSimpleReport(List<ReportData> report) {
        return report.stream().map(ReportUtil::formatReportString).reduce((x, y) -> x+y).get();
    }
}
