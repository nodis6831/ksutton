/**
 * 
 *  A simple C program to take in user input (a note) and then print out the associated
 *  major and minor scale 
 * 
 *  Kelly Sutton
 *  CMSI 284
 *  2/15/07
 * 
 */


#include <stdio.h>

int main(){
	
	int tmp_ki = 3; //key of C
	
	char* keys[13] = { "A" , "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
	int major[8] = { 0, 2, 4, 5, 7, 9, 11, 12 }; //these arrays represent the number of tones away from key we're in
	int minor[8] = { 0, 2, 3, 5, 7, 9, 11, 12 }; 
	
	int i;
	printf("%s major: ", keys[tmp_ki]);
	for (i = 0; i < 8; i++){
	    printf( "%s ", keys[ (tmp_ki + major[i]) % 12]); 	
	}
	printf("\n");

	printf("%s minor: ", keys[tmp_ki]);
	for (i = 0; i < 8; i++){
	    printf( "%s ", keys[ (tmp_ki + minor[i]) % 12]); 	
	}
	printf("\n");

	
	return 0;	
}
