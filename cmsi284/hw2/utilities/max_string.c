#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* maxstring(char* str1, char* str2){

   int length = 0;
   int l1 = strlen(str1);
   int l2 = strlen(str2);

   if (l1 > l2)
      length = l1;
   else //(l2 >= l1)
      length = l2;

   char* finalstr = malloc((length + 1));

   int i; //C90 compatibility
   for (i = 0; i < l1 || i < l2; i++){
     
      if (i < l1 && i >= l2) //we've run out of str2!
         finalstr[i] = str1[i]; 

      else if (i < l2 && i >= l1) //we've run out of str1!
         finalstr[i] = str2[i]; 
 
      else if (str1[i] >= str2[i]) //we need to do us some comparing
         finalstr[i] = str1[i];

      else // (str1[i] < str2[i]) 
         finalstr[i] = str2[i];
   }

   finalstr[length] = '\0';

   return finalstr;
}


int main(){

   //tmp value
   char* str1 = "garbage!";
   char* str2 = "dog";

   printf("The final string is: %s\n", maxstring(str1, str2));

   return 0;
}
