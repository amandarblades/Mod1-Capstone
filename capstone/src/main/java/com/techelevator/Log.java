package com.techelevator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.*;

public class Log {

    private String getFormattedDate() {
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(formatter);
        return formattedDate;
    }
      private String getFormattedTime() {
          DateTimeFormatter timeFormatter;
          timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
          LocalTime time = LocalTime.now();
          String formattedTime = time.format(timeFormatter);
          return formattedTime;
      }

        private void printToLog(String operation, double operationAmt, double newBalance) throws IOException {

        File inPutFile = new File("log");
        String message = getFormattedDate() + " " + getFormattedTime() + " " + operation + " " + "$" + operationAmt + " " + "$" + newBalance;


    PrintWriter writer = null;
        if(inPutFile.exists()){
           writer = new PrintWriter(new FileOutputStream(inPutFile.getAbsoluteFile(),true));

        }else {
            writer = new PrintWriter(inPutFile.getAbsoluteFile());
        }
        writer.append(message);
        writer.flush();
        writer.close();

        }







}/** End of Class  **/
