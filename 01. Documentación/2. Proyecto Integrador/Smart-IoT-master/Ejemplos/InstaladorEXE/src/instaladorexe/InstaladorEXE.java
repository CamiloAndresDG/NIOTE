/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaladorexe;

import java.io.IOException;

/**
 *
 * @author 305
 */
public class InstaladorEXE {

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String OSArch = System.getProperty("os.arch").toLowerCase();
    private static String OSVersion = System.getProperty("os.version").toLowerCase();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        windowsArchitecture();
        Runtime aplicacion = Runtime.getRuntime();        
        if("amd64".equals(OSArch)){ 
            
            try{
                aplicacion.exec("C:/Users/305/Documents/Semillero/mosquitto-1.5.8-install-windows-x64.EXE"); 
            }
            catch(IOException e){
                System.out.println("fallo"+e.getMessage()); 
            }
        }else{
            try{
                aplicacion.exec("C:/Users/305/Documents/Semillero/mosquitto-1.5.8-install-windows-x86.EXE"); 
            }
            catch(IOException e){
                System.out.println("fallo"+e.getMessage()); 
            }
        }                    
        
    }  
    
    public static void windowsArchitecture (){
        System.out.print("Sistema operativo: ");
	System.out.println(OS);
 
        if (isWindows()) {
            System.out.println("Es un Windows");
        } else if (isMac()) {
            System.out.println("Es un Mac");
        } else if (isUnix()) {
            System.out.println("Es un Unix/Linux");
        } else if (isSolaris()) {
            System.out.println("Es Solaris");
        } else {
            System.out.println("Sistema operativo no reconocido!!");
        }
 
        System.out.println("Version: "+OSVersion);
        System.out.println("Aquitectura: "+OSArch);
    }
    
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
 
    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
 
    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
 
    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
}
