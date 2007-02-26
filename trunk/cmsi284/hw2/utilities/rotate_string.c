#include <stdio.h>
#include <string.h>


/*
 * Rotate will rotate around the nth letter in the string
 * str. Thus, the call rotate("doghouse", 3) returns the 
 * string "housedog"
 */
char* rotate(char* str, int n){

    int length = strlen(str); //only need to compute once
    char* newstr = malloc(length * sizeof(char *));
    int i;
    int j = 0;

    for (i = n; i < (length + n); i++){
        newstr[j] = str[i % length];//assigning a character
        j++;
    }

    return newstr;
}

int main(){
    printf("%s\n", rotate("doghouse", 3));
}

