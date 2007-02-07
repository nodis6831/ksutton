#include <stdio.h>
#include <math.h>

int main(){
	
	double a[88];
	char* keys[13] = { "A" , "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
        double z = 1.0594630943593; 
	
	a[0] = 27.5000; 
	
	int i;
	for (i = 1; i < 88; i++){
		a[i] = a[i-1] * z; //pow(2.0, 1.0 / 12.0);
	}
	
	for (i = 0; i < 88; i++){
    	printf("%2s %12lf\n", keys[(i)%12],  a[i]);
	}
	
	return 0;
}
