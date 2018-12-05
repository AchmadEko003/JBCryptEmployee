/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Nitani
 */
public class test {

    public String getPath(String fileto) {
        String path = "";
        
//        File fn = new File("src/Reports/report1.jrxml");
//        File ftf = new File("src/Reports/report1.jasper");
//        String fileName = fn.getAbsolutePath();
//        String fileToFile = ftf.getAbsolutePath();
        
        Path fileTo = Paths.get("src" + File.separator + "Reports" + File.separator + fileto);
        Path filetofill = fileTo.toAbsolutePath();
        String fileToFill = filetofill + "";
        path = fileToFill;
        return path;
    }
}
