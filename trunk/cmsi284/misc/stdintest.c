#include <stdio.h>
#include <stdlib.h>

int main(){

    char c = 'a';

    fputc(c, stdin);
    printf("You entered the character: %c\n", getchar());
    return 0;
}
