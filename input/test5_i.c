int f(int a){
	int k;
	k = 5;
	while(k>4){
		a++;
		k--;
	}
    return 3*a - 7;
    a=9;
}

int g(int a, int b){
	
    int x,i;
    x=f(a)+a+b;
    
    for(i=0;i<1;i++){
    	if(i%3 == 0){
    		x = x+5;
    	}
    	else{
    		x = x-1;
    	}
    }
    
    return x;
}

int main(){
    int a,b,i;
    a=1;
    b=2;

    for(i=0;i<1;i++){
        a=3;
        while(a>0){
            b++;
            a--;
        }
    }
    println(a);
    println(b);
    println( i);
    return 0;
}
