# ※ 중요
master에 push하지 마시고 각자 branch를 만드신 후에 branch로 push 해주세요.
master는 공지사항 및 공통사항만 올려놓으려고 합니다.!!


## 원격 저장소를 지역 저장소로 설정하기
1. git clone [URL] [USED_DIRECTORY]
ex ) $ git clone [https://github.com/RH0001/javaStudy](https://github.com/RH0001/javaStudy) hardTest
2. cd [USED_DIRECTORY]
ex ) $ cd hardTest
3. git remote -v
ex ) $ git remote -v
origin  [https://github.com/RH0001/javaStudy](https://github.com/RH0001/javaStudy) (fetch)
origin  [https://github.com/RH0001/javaStudy](https://github.com/RH0001/javaStudy) (push)

## Branch 생성 및 Branch파일 업로드
1. git pull
ex ) $ git pull
2. git checkout -b [brenchName]
ex ) $ git checkout -b hard
3. git add [FILE]
git commit -m "[commit message]"
ex ) $ git add test.txt
       $ git commit -m "처음 올리는 파일"
4. git push origin [brenchName]
ex ) $ git push origin hard
