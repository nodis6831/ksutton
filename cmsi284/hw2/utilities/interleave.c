#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* interleave(char* str1, char* str2){

    int l1 = strlen(str1); 
    int l2 = strlen(str2); 
    int finallength = l1 + l2 + 1;
    char* newstr = malloc(finallength);

    int i;
    for (i = 0; i < finallength; i++){
 
        if (i/2 < l1 && i/2 >= l2) //we've run out of str2!
             newstr[i] = str1[i-l2];

        else if (i/2 < l2 && i/2 >= l1) //we've run out of str1!
             newstr[i] = str2[i-l1];

        else if ((i+1) % 2 == 1) //we're working with str1
             newstr[i] = str1[i/2];

        else //((i+1) % 2 == 0) //we're working with str2
             newstr[i] = str2[i/2];
    }

    newstr[finallength-1] = '\0';

    return newstr;
}

int main(){
    printf("%s\n", interleave("dog", "rat"));
    printf("%s\n", interleave("capybara", "it"));
    printf("%s\n", interleave("java", "suckzzz"));
}

