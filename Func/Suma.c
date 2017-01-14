#include <stdio.h>
#include <stdlib.h>
#include "Suma.h"


int main(){
	
	int A, B, C;
	
	printf("Introduce un valor para la variable A:");
	scanf("%d", &A);
	
	printf("Introduce un valor para la variable B:");
	scanf("%d", &B);
	
	C = suma(A, B);
	printf("El resultado es: %d\n", C);
	
	return 0;
	}

