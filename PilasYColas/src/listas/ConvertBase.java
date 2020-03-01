/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author niwdeyen
 */
public class ConvertBase {

    public String toBinary(int n) {
        LinkedStack bin = new LinkedStack();
        String binary = "";

        while (n > 0) {
            bin.push(n % 2);
            n /= 2;

        }
        while (!bin.empty()) {
            try {
                binary += bin.pop();
            } catch (Exception e) {
                binary = "Error interno";
            }
        }
        return binary;
    }

    public String toOctal(int n) {
        LinkedStack oc = new LinkedStack();
        String octal = "";

        while (n > 0) {
            oc.push(n % 8);
            n /= 8;

        }
        while (!oc.empty()) {
            try {
                octal += oc.pop();
            } catch (Exception e) {
                octal = "Error interno";
            }
        }
        return octal;
    }
    
    public String toHexadecimal(int n){
        LinkedStack oc = new LinkedStack();
        String octal = "";

        while (n > 0) {
            oc.push(n % 8);
            n /= 8;

        }
        while (!oc.empty()) {
            try {
                octal += oc.pop();
            } catch (Exception e) {
                octal = "Error interno";
            }
        }
        return octal;
    }

    public String toBase(Byte base, int n) throws Exception {
        if (base != 2 || base != 8 || base != 10 || base != 16) {
            throw new Exception("\033[031mError: \033[030mIngrese una base válida por favor");
        } else if (base == 10) {
            String decimal = "";
            decimal += n;
            return decimal;
        } else if (base == 2) {
            toBinary(n);
        } else if (base == 8) {
            toOctal(n);
        } else {

        }
    }
}
