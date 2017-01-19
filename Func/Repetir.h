#include <stdio.h>
#include <stdlib.h>



int repetirNumero(int A);
int repetirCondicion(int A,int B, char cad);

int repetirNumero(int A){
	if(A == 0)
		return 1;
	return 0;
}

int repetirCondicion(int A,int B, char cad){
	if(cad == '>'){
		if (A > B){
			return 1;
		}
		else{
			return 0;
		}
	}
	if(cad == '<'){
		if (A < B){
			return 1;
		}
		else{
			return 0;
		}
	}
}
