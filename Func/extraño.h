#include <stdio.h>
#include <stdlib.h>
#include "Suma.h"
#include "mult.h"



int extraño(int A, int B);




int extraño(int A, int B){
	int auxfin = 0;
	auxfin=mult(A,B);
	auxfin+=mult(A,B);
	return auxfin;
}