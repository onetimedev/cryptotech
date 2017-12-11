# CryptoTech
Android/Java library which acts as a crypto system using an original algorithm - Inspired by RSA Encryption Algorithm

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

