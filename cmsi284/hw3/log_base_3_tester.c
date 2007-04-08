/*
 * We're gonna call crap.asm
 */

#include <stdio.h>

extern double log_base_3(double x);

int main() {
    double x = log_base_3(2.1);
    printf("log_base_3(2.1) = %f\n", x);

    x = log_base_3(3.0);
    printf("log_base_3(3.0) = %f\n", x);

    x = log_base_3(27.0);
    printf("log_base_3(27.0) = %f\n", x);

    x = log_base_3(99.0);
    printf("log_base_3(99.0) = %f\n", x);

    return 0;
}
