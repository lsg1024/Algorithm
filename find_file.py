import os
        
    
# 비교할 두 폴더 경로 설정
folder1 = ""
folder2 = ""


files1 = [os.path.splitext(f)[0] for f in os.listdir(folder1)]
files2 = [os.path.splitext(f)[0] for f in os.listdir(folder2)]

unique_files1 = set(files1) - set(files2)
unique_files2 = set(files2) - set(files1)

print("폴더1에만 존재하는 파일 이름: ", unique_files1)
print("폴더2에만 존재하는 파일 이름: ", unique_files2)
