package org.example.services;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public class FileService {

    public boolean createFile() {
        try {
            LocalDate now = LocalDate.now();
            String fileName = now.getYear() + "_"+now.getMonthValue()+"_"+now.getDayOfMonth();
            File file = new File(fileName+".txt");
            file.createNewFile();
            return true;
        }catch (Exception ex) {
            System.err.println("File Error : " + ex);
        }
        return false;
    }

    public boolean fileControl() {
        LocalDate now = LocalDate.now();
        String fileName = now.getYear() + "_"+now.getMonthValue()+"_"+now.getDayOfMonth();
        File file = new File(fileName+".txt");
        return file.exists();
    }

}
