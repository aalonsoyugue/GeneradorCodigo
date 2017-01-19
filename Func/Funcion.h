#include <stdio.h>
#include <stdlib.h>
#include "mult.h"



int Funcion(int A, int B);




int Funcion(int A, int B){
	int auxfin = 0;
	auxfin=mult(A,Suma(B, B));
	return auxfin;
}