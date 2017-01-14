#include <stdio.h>
#include <stdlib.h>
#include "Multiplicar.h"
#include "Repetir.h"
#include "Suma.h"



int Restar(int A, int B);




int Restar(int A, int B){
	int auxfin = 0;
	B = B * (-1);
	auxfin=Suma(A,B);
	return auxfin;
}