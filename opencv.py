import cv2
import numpy as np
import os

webcam = cv2.VideoCapture(2)

# opencv가 감지할 수 있는 mouse event 확인하기

click = False     # Mouse 클릭된 상태 (false = 클릭 x / true = 클릭 o) : 마우스 눌렀을때 true로, 뗏을때 false로
x1,y1 = -1,-1

events = [i for i in dir(cv2) if 'EVENT' in i]

def mouse_callback(event, x, y, flags, param): 
    
    if 100<x<460 and 110<y<450:
        print("마우스 이벤트 발생, x:", x ," y:", y) # 이벤트 발생한 마우스 위치 출력
        # mario.play()        
    # elif 500 <x <860 and 110< y<900:
    #     # mario1.play()
    # elif 900 <x <1260 and 110< y<900:
    #     # mario2.play()
    # elif 1300 <x <1660 and 110< y<900:
        # mario3.play()
        
    global x1,y1, click                                     # 전역변수 사용

    if event == cv2.EVENT_LBUTTONDOWN:                      # 마우스를 누른 상태
        click = True
        x1, y1 = x,y
        print("사각형의 왼쪽위 설정 : (" + str(x1) + ", " + str(y1) + ")")
		
    elif event == cv2.EVENT_MOUSEMOVE:                      # 마우스 이동
        if click == True:                                   # 마우스를 누른 상태 일경우
            cv2.rectangle(d,(x1,y1),(x,y),(0,255,0),3)
            # cv2.circle(img,(x,y),5,(0,255,0),-1)
            print("(" + str(x1) + ", " + str(y1) + "), (" + str(x) + ", " + str(y) + ")")

    elif event == cv2.EVENT_LBUTTONUP:
        click = False;                                      # 마우스를 때면 상태 변경
        cv2.rectangle(d, (x1,y1), (x,y), (0,255,0), 3)
        cv2.rectangle(d, (1300, 600), (1660, 950), (0,255,0), 3)
        print("사각형 오른쪽 아래 (" + str(x1) + ", " + str(y1) + "), (" + str(x) + ", " + str(y) + ")")
        cv2.imshow("d", d)

cv2.destroyAllWindows()

    
if not webcam.isOpened():
    
    print("Could not open webcam")
    exit()    

while True:
    
    _, d = webcam.read()

    cv2.rectangle(d, (100, 110), (460, 450), (0,255,0), 3)
    cv2.rectangle(d, (500, 110), (860, 450), (0,255,0), 3)
    cv2.rectangle(d, (900, 110), (1260, 450), (0,255,0), 3)
    cv2.rectangle(d, (1300, 110), (1660, 450), (0,255,0), 3)
    
    cv2.rectangle(d, (100, 600), (460, 950), (0,255,0), 3)
    cv2.rectangle(d, (500, 600), (860, 950), (0,255,0), 3)
    cv2.rectangle(d, (900, 600), (1260, 950), (0,255,0), 3)
    cv2.rectangle(d, (1300, 600), (1660, 950), (0,255,0), 3)
    
    
    
    cv2.namedWindow("d")
    cv2.setMouseCallback("d", mouse_callback)
        
    # cv2.rectangle(d, (x1,y1), (x,y), (0,0,255), 3)

    if not webcam:
        break
        
    # # 박스 사진 검출
    cv2.imshow("d", d)
        
        
    if cv2.waitKey(1) & 0xFF == 27:
        break

d.release()
cv2.destroyAllWindows()
    
    