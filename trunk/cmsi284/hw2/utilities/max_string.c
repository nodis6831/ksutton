#include <stdio.h>
#include <string.h>

int main(){

   char* str1;
   char* str2;
   int length = 0;
  
   if ( strlen(str1) > strlen(str2))
      length = strlen(str1);
   else //( strlen(str2) > strlen(str1)
      length = strlen(str2);

   char* finalstr = malloc(length + 1);

   //tmp values
   str1 = "cat";
   str2 = "dog";

   int i;
   for (i = 0; i < strlen(str1) && i < strlen(str2); i++){
     
      if (i < strlen(str1) && i >= strlen(str2)) //we've run out of str2!
         finalstr[i] = str1[i]; 

      else if (i < strlen(str2) && i >= strlen(str1)) //we've run out of str1!
         finalstr[i] = str2[i]; 
 
      else if (str1[i] >= str2[i])//we need to do us some comparing
         finalstr[i] = str1[i];

      else // (str1[i] < str2[i]) 
         finalstr[i] = str2[i];
   }

   finalstr[length] = '\0';

   printf("The final string is: %s", finalstr);

   return 0;
}
