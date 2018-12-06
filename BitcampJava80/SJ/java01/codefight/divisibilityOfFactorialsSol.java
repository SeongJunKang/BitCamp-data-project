int S, c, n = 1;
int divisibilityOfFactorials(int N) {
    for(; ++n <= N; S = (S + c) % 1000000000)
       c = p(n) > 0 ? n : s(n);
    return S;
}

int p(int n){
    int r = n % 2 < 1 ? 0 : 1, i = 3;
    for(; i * i <= n; i += 2)
       if(n % i < 1)
           r = 0;
    return r;
}

int s(int n){
    int m = 0, C, c, k, t, i = 2;
    for(; n > 1;i++){
        for(C = 0; n % i < 1; n /= i)
            C++;
        for(c = k = 0; ++k <= C;){
            for(c++,t = k; t % i < 1; t /= i)
                c++;
            if(c >= C)
                break;
        }
        m = m < k * i ? k * i : m;
    }
    return m;
}
