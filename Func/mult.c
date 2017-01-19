#include <stdio.h>
#include <stdlib.h>
#include "mult.h"


int main(int argc, char *argv[]){
	int A, B, C;
	printf("Introducir el valor para A:");
	scanf("%d", &A);
	printf("Introducir el valor para B:");
	scanf("%d", &B);
	C = mult(A, B);
	printf("El resultado es: %d", C);
printf("\n");}