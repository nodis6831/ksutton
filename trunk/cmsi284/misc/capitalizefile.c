/*
 * capitalizefile.c
 *
 * This is an inefficient program that takes two command line
 * arguments -- the first is the name of a file that should exist,
 * and the second the name of a file that should not exist ---
 * and creates the second file with the "capitalized" content of
 * the first.  If the second file already exists, it will be
 * overwritten.
 *
 * This program is slow because it uses fgetc and fputc.  Also,
 * it assumes the files are text files, so the file size of
 * the output file might differ from that of the input file.
 */

#include <stdio.h>
#include <ctype.h>

int main(int argc, char** argv) {
    if (argc != 3) {
        puts("Exactly two commandline arguments needed");
        return 1;
    } else {
        FILE* in = fopen(argv[1], "r");
        if (!in) {
            printf("File %s does not exist\n", argv[1]);
            return 2;
        }
        FILE* out = fopen(argv[2], "w");
        while (1) {
            int c = fgetc(in);
            if (c == EOF) break;
            fputc(toupper(c), out);
        }
        fclose(in);
        fclose(out);
        return 0;
    }
}
