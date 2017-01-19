#include <stdio.h>
#include <stdlib.h>
#include "Suma.h"



int mult(int A, int B);




int mult(int A, int B){
	int aux = A-1;
		int auxfin = B;
	while(repetirNumero(aux)==0){
		aux-=1;
		auxfin=Suma(B,auxfin);
	}
	return auxfin;
}
