#include <stdio.h>
#include <stdlib.h>
#include "Repetir.h"
#include "Suma.h"



int Multiplicar(int A, int B);




int Multiplicar(int A, int B){
	int aux = A;
	int auxfin = 0;
	while(repetirNumero(aux)==0){
		aux-=1;
		auxfin=Suma(B,auxfin);
	}
	return auxfin;
}
