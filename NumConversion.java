/*Grace-lilie Acheampong
* Feb 26 2025
* CSE 007, Homework 2 Part 2
* Descr: This program's main aim is to convert numbers in binary, octal or hexadecimal to decimal value.
* IDE: VSCode; compiler: JDK 11
*/

import java.util.Scanner;
public class NumConversion{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        boolean validInput = true;
        String userInput="";
        String numInput ="";
        do{    //accepts a numbering system that is either binary, octal, hexadecimal
            validInput= true;
            System.out.print("Enter a number system: binary, octal, or hexadecimal: ");
            userInput = scan.next();

           //validating if number system is specified cases
            if (userInput.equalsIgnoreCase("binary") || userInput.equalsIgnoreCase("octal") || userInput.equalsIgnoreCase("hexadecimal")){
                System.out.print("Enter a number based on you chosen number system: ");
                numInput = scan.next();

                 //Validating binary(8 digits , 0's and 1's)
                if(userInput.equalsIgnoreCase("binary")){
                    if (numInput.length() == 8){

                        for (int i = 0; i < numInput.length(); i++) {
                            if (numInput.charAt(i) != '0' && numInput.charAt(i) != '1') {
                                validInput = false;
                                System.out.println("Error: Binary must contain only 0s and 1s.");
                                break;
                            }
                        }
                    }
                
                    else{
                        System.out.print("Binary must be 8 digit long"); 
                        validInput = false;

                    }
                }
            
            //Validating octal(6 digits, only 0-7)
                else if (userInput.equalsIgnoreCase("octal")){
                    if(numInput.length() == 6){

                        for (int i = 0; i < numInput.length(); i++) {
                            if (numInput.charAt(i) < '0' || numInput.charAt(i) > '7') {
                                validInput = false;
                                System.out.println("Error: Octal must contain only digits 0-7.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Error: Octal must be exactly 6 digits long.");
                        validInput = false;

                    }
                }
   
               // Validate Hexadecimal (4 digits, only 0-9 and A-F)
                else if (userInput.equalsIgnoreCase("hexadecimal")) {
                    if (numInput.length() == 4) {

                        for (int i = 0; i < numInput.length(); i++) {
                            char ch = numInput.charAt(i);
                            if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F'))) {
                                validInput = false;
                                System.out.println("Error: Hexadecimal must contain only digits 0-9 and letters A-F.");
                                break;
                            }
                        }
                    } else {
                        
                        System.out.println("Error: Hexadecimal must be exactly 4 digits long.");
                        validInput = false;

                    }

                    
                }
            }

            else{
                String junk = scan.next();
                System.out.println("Error: Number system must be either a binary, octal or hexadecimal");
                validInput = false;


            }
        }while(!validInput);


        int index = 0; // initialize the exponential value to zero
        int userValue; 
        int decimal = 0; 
        switch(userInput.toLowerCase()){

            //Converting from binary to decimal
            case "binary":
                 for(int i = numInput.length()-1; i>=0 ; i--,index++ ){
                    userValue = numInput.charAt(i) - '0';
                    decimal += userValue * (int)(Math.pow(2,index));
                    
                 }
                 break;
            //Converting from octal to decimal
            case "octal":
                for(int i = numInput.length()-1; i>=0 ; i--,index++ ){        
                    userValue = numInput.charAt(i) - '0';
                    decimal += userValue * (int)(Math.pow(8,index));
                 }
                 break;
                
            //Converting from hexadecimal to decimal    
            case "hexadecimal": 
                for(int i = numInput.length()-1; i>=0 ; i--,index++ ){  

                    char numChar = numInput.charAt(i);
                    if (numChar >= 'A' && numChar <= 'F'){ // A-F
                       userValue = numChar -'A' +10;       
                    }  
                    else{
                        userValue = numChar -'0'; //0-9
                    }   
                    decimal += userValue *(int)Math.pow(16 , index);
                 }
                 break;
        }
        System.out.printf("%s value = %s has Decimal value = %d", userInput,numInput,decimal);

    scan.close();
    }
    
}