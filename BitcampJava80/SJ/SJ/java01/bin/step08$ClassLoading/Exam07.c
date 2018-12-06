#include"stdio.h"
#include"stdlib.h"

int main() {

  int* p = (int*)malloc(sizeof(int) * 3);
  int c;
  p[0] = 10;
  *(p + 1) = 20;
  p[2] = 30 ;

  printf("%d %d %d \n",p[0],p[1],*(p+2));
  printf("%d \n",(int)sizeof(p));

  free(p);
  p[2]=100;
  printf("%d \n ",p[2]);
  return 0;
}
