#include <stdio.h>
#include <stdlib.h>
#include "extraño.h"


int main(int argc, char *argv[]){
	int A, B, C;
	printf("Introducir el valor para A:");
	scanf("%d", &A);
	printf("Introducir el valor para B:");
	scanf("%d", &B);
	C = extraño(A, B);
	printf("El resultado es: %d", C);
printf("\n");}