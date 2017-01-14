#include <stdio.h>
#include <stdlib.h>



int repetirNumero(int A);
int repetirCondicion(int A,int B, char cad);


int main(){
	
	int A = 5;
	int B = 3;
	char signo = '>';

	int C = repetir(A, B, signo);
	printf("%d\n", C);

	return 0;
}


int repetirNumero(int A){
	if(A == 0)
		return 1;
	if(B == 0)
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
