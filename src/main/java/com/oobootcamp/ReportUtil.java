package com.oobootcamp;

public class ReportUtil {
    private static String indent(int level){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
             sb.append(" ");
        }
        return sb.toString();
    }

    private static String formatReportString(int level, ReportData reportData) {
        String newLine = "";
        if(level > 0){
            newLine = "\n";
        }
        return newLine + indent(level) + reportData.getParkableType() + " " + reportData.getTotalCars() + " " + reportData.getAvailableSpaces();
    }

    public static String printSimpleReport(ReportData report) {
        return printSimpleReport(0,report);
    }

    private static String printSimpleReport(int level, ReportData report) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatReportString(level, report));
        for (ReportData reportData : report.getSubReport()) {
            sb.append(printSimpleReport(level+1, reportData));
        }
        return sb.toString();
    }
}
