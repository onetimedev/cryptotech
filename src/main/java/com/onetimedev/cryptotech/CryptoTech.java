package com.onetimedev.cryptotech;


public class CryptoTech {

    /*
        Welcome,
        Thank you for trying out the CryptoTech CryptoSystem!

        CryptoTech uses a mathematical algorithm to provide a complex
        numerical value and assign it to a given letter, the value is
        built from keys set up by You!

        The component V can be any value between 10 - 25 where Z is between 10 - 51
        or V can be any value between 10 - 80 where Z is between 10 - 16.

        The component E may be any value between 1 and 4.

        The Algorithm -

               Phi
        [En] = --- n^e
                M

        Explanation:

        [En] is the encrypted value of the given letter and M is the given letters numerical value
        in this case the numerical value for [b] is 3.


        Implementation -

        Below is the java code that is used to utilise the library.

        import com.onetimedev.cryptotech.CryptoTech;

        ...

        CryptoTech cryptoTech = new CryptoTech();

        cryptoTech.SetVKey(15);
        cryptoTech.SetZKey(10);
        cryptoTech.SetE(2);
        cryptoTech.CreateKeys();

        int h = cryptoTech.Encrypt("h");

        ...

    */

    private int v = 0; //first encryption key variant
    private int z = 0; //second encryption key variant
    private int n = 0; //product of v*z
    private int e = 0; //third encryption key variant
    private int phi = 0; //product of (v-1)*(z-1)

    public CryptoTech(){} //initializer (unused)


    //provides a numerical value for any given letter of the English alphabet
    private int GetNumerical(String letter){
        int Numerical = 0;

        switch(letter){
            case "a":
                Numerical = 2;
                break;
            case "b":
                Numerical = 3;
                break;
            case "c":
                Numerical = 4;
                break;
            case "d":
                Numerical = 5;
                break;
            case "e":
                Numerical = 6;
                break;
            case "f":
                Numerical = 7;
                break;
            case "g":
                Numerical = 8;
                break;
            case "h":
                Numerical = 9;
                break;
            case "i":
                Numerical = 10;
                break;
            case "j":
                Numerical = 11;
                break;
            case "k":
                Numerical = 12;
                break;
            case "l":
                Numerical = 13;
                break;
            case "m":
                Numerical = 14;
                break;
            case "n":
                Numerical = 15;
                break;
            case "o":
                Numerical = 16;
                break;
            case "p":
                Numerical = 17;
                break;
            case "q":
                Numerical = 18;
                break;
            case "r":
                Numerical = 19;
                break;
            case "s":
                Numerical = 20;
                break;
            case "t":
                Numerical = 21;
                break;
            case "u":
                Numerical = 22;
                break;
            case "v":
                Numerical = 23;
                break;
            case "w":
                Numerical = 24;
                break;
            case "x":
                Numerical = 25;
                break;
            case "y":
                Numerical = 26;
                break;
            case "z":
                Numerical = 27;
                break;
        }

        return Numerical;

    }
    //provides an alphabetical value for any given numerical value
    private String GetAlpha(int letter){
        String Numerical = "";

        switch(letter){
            case 2:
                Numerical = "a";
                break;
            case 3:
                Numerical = "b";
                break;
            case 4:
                Numerical = "c";
                break;
            case 5:
                Numerical = "d";
                break;
            case 6:
                Numerical = "e";
                break;
            case 7:
                Numerical = "f";
                break;
            case 8:
                Numerical = "g";
                break;
            case 9:
                Numerical = "h";
                break;
            case 10:
                Numerical = "i";
                break;
            case 11:
                Numerical = "j";
                break;
            case 12:
                Numerical = "k";
                break;
            case 13:
                Numerical = "l";
                break;
            case 14:
                Numerical = "m";
                break;
            case 15:
                Numerical = "n";
                break;
            case 16:
                Numerical = "o";
                break;
            case 17:
                Numerical = "p";
                break;
            case 18:
                Numerical = "q";
                break;
            case 19:
                Numerical = "r";
                break;
            case 20:
                Numerical = "s";
                break;
            case 21:
                Numerical = "t";
                break;
            case 22:
                Numerical = "u";
                break;
            case 23:
                Numerical = "v";
                break;
            case 24:
                Numerical = "w";
                break;
            case 25:
                Numerical = "x";
                break;
            case 26:
                Numerical = "y";
                break;
            case 27:
                Numerical = "z";
                break;
        }

        return Numerical;

    }



    //Sets the values to their given variables
    public void SetVKey(int Val){
        v = Val;
    }
    public void SetZKey(int Val){
        z = Val;
    }
    public void SetEKey(int Val){
        e = Val;
    }
    public void SetN(int Val){
        n = Val;
    }
    public void SetPhi(int Val){
        phi = Val;
    }

    //Collecting Values
    public int GetV(){
        return v;
    }
    public int GetZ(){
        return z;
    }
    public int GetE(){
        return e;
    }
    public int GetN(){
        return n;
    }
    public int GetPhi(){
        return phi;
    }

    //Initializes the encryption keys
    public void CreateKeys(){
        SetN(GetV()*GetZ());
        SetPhi(((GetV()-1)*(GetZ()-1)));

    }

    //Uses the encryption algorithm
    public int Encrypt(String l){
        double nL = GetNumerical(l);
        double a = GetPhi()/nL;
        double b = (int) (Math.pow(GetN(),GetE()));
        double DecryptedDecimal = a*b;
        return (int) DecryptedDecimal;
    }
    //Uses the decryption algorithm
    public String Decrypt(double c) {
        double a = (Math.pow(GetN(), GetE()));
        double b = GetPhi() * a;
        double DecryptedDecimal = b / c;
        int DecryptedInteger = (int) DecryptedDecimal;
        if (DecryptedDecimal > Math.ceil(DecryptedDecimal) + 0.8) {
            DecryptedInteger = (int) Math.ceil(DecryptedDecimal);
        } else if (DecryptedDecimal < Math.ceil(DecryptedDecimal) + 0.8) {
            DecryptedInteger = (int) Math.floor(DecryptedDecimal);
        }

        return GetAlpha(DecryptedInteger);
    }



    //Encrypts a word using a '-' as a word constructor
    public String EncryptWord(String word){
        String[] chars = word.split("-");
        int[] EncWord = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            EncWord[i] = Encrypt(chars[i]);
        }

        String output = "";
        for(int j = 0; j < EncWord.length; j++){
            output = output + String.valueOf(EncWord[j]) + ":";
        }

        return output.substring(0,output.length()-1);
    }

    //Decrypts a word using a ':' as a data constructor
    public String DecryptWord(String word){
        String[] bits = word.split(":");
        String[] DencWord = new String[bits.length];
        for(int i = 0; i < bits.length; i++){
            DencWord[i] = Decrypt(Integer.parseInt(bits[i]));
        }

        String output = "";
        for(int j = 0; j < DencWord.length; j++){
            output = output + DencWord[j];
        }

        return output;
    }
}
