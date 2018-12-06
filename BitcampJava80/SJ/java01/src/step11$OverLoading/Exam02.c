#include"stdio.h"

int plus(int a, int b){
  return a + b;
}
void plus2(int a,int b,int c){
  printf("%d + %d + %d = %d \n",a,b,c,a+b+c);
}

void plus3(int* p,int len) {
  int sum = 0, i;
  for (i = 0;i < len ;i++) {
    sum = sum + p[i];
    if(i > 0 ) {
      printf(" + ");
    }
    printf("%d",p[i]);
  }
  printf(" = %d \n",sum);
}

int main() {

  // int result = plus(10.5f,20.4f);
  printf("10+20 = %d \n",plus(10.5f,20.4f));
  plus2(10,20,30);
  int arr[5] = {10, 20, 30, 40, 50};
  plus3(arr,5);
  return 0;
}
