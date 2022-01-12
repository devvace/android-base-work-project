# BaseWorkProject
This project is the first default project to be brought in Android




적용 모듈
=======================================

### Dlog library
- Application release시 log가 찍히지 않게 함
- ref) [링크](https://gun0912.tistory.com/12)

### Proguard
- APK 파일 디컴파일 시 코드 노출 방어

### Network 연결 여부 감지
- NetworkCallback() 사용
- ConnectivityManager.CONNECTIVITY_ACTION deprecated 대응

### Kotlin extension (X)
- 더 이상 지원되지 않음으로 삭제
- FindViewById() 대체 라이브러리는 ViewBinding으로 대체
