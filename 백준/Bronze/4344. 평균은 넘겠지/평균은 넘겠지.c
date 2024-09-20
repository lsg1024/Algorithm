#include <stdio.h>

int main() {
    int loop;
    scanf("%d", &loop);
    for(int k = 0; k < loop; k++) {
        int len;
        scanf("%d", &len);
        int num[1000];
        int sum = 0;
        for(int i = 0; i < len; i++) {
            scanf("%d", &num[i]);
            sum += num[i];
        }

        float avg = (float)sum / len;  // 정수 나눗셈 대신 float로 캐스팅
        int good = 0;
        for(int i = 0; i < len; i++) {
            if(num[i] > avg)
                good++;
        }
        printf("%.3f%%\n", (float)good / len * 100);  // 결과를 소수점 3자리까지 출력
    }
    return 0;
}