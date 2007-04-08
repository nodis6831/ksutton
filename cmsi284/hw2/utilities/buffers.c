#include <stdio.h>

/* Example 1: DANGEROUS
int main() {
    char buffer[512];
    char* result;

    while ((result = gets(buffer)) != NULL){
        printf("%s\n", buffer);
    } 

}
*/

int main(){

    char buffer[10];

    while (1){

         int c = getchar(); //getchar() returns an int
         if (c == EOF) break;
         printf("The %c\n", c); 
    }



    return 0;
}
