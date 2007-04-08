/*
 *
 *
 *
 */

#include <stdio.h>
#include <ctype.h>

int main(){

    char firstByte;
    char secondByte; //UTF-16 has two bytes
    char thirdByte;
    char fourthByte;
    while (1){

        int c = getchar();
        if (c == EOF) break;
        firstByte = (char) c;

        c = getChar();
        if (c == EOF) break;
        secondByte = (char) c;

        if (firstByte >= 0xD8 && firstByte <= 0xDB){
                 int c = getchar();
                 if (c == EOF) break;
                 thirdByte = (char)c;

                 int c = getchar();
                 if (c == EOF) break;
                 fourthByte = (char)c;

            /* 10110111 & 10100000 = 1 */
            /* TODO: This is a 4-byte thingy */
            /*
             * F-Clef
             * UTF-32: 0001D122
             * UTF-16: 
             *          1D122
             *         -10000
             *         ------
             *          0D122
             *
             *          D834DD22
             */
        }

        else{
            /* Char is in range 000..FFFF,
             * UTF-32 is easy
             */
            putchar(0);
            putchar(0);
            putchar(firstByte);
            putchar(secondByte);
        }



}
