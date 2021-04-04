# J. S. Jeong - 다이어트 관리를 위한 프로그램 구현

이번 확장 프로젝트 미션은 <a href="https://github.com/hy6219/jHealthUp_mini">jHealthUp_mini</a>에서 나타났던 많은 부실함을 

보충하고자 진행하게 되었다.

## 2021-04-04 현재 업로드된 부분

MVC 패턴을 체득하기 위하여 최대한 구조화하고자 하였습니다.

<ol type ="I">
  <li>
  ver2.model.vo.User.java
  <ul>
    <li>사용자 정보는 private로 캡슐화</li>
    <li>멤버 변수 : 사용자 이름(name), 주민등록번호(no), 나이(age), 키(height), 체중(weight)</li>
    <li>생성자    : 기본 생성자, 멤버변수 모두를 매개변수로 갖는 생성자</li>
    <li>public setters & getters</li>
    <li>메서드 오버라이딩 : 동등객체 비교 및 그에 따른 규약에 따라서 equals 및 hashCode 오버라이딩 | 값을 파일로 출력하기 위하여 toString 오버라이딩</li>
  </ul>
  </li>
  <li>
  ver2.model.dao.ManageDB
  <ul>
    <li>멤버변수
      <ul>
      <li>-링크드리스트(String)</li>
      <li><u>+User curUser</u></li>
      <li>-Scanner</li>
      </ul>
    </li>
    <li>
        메서드
        <ul>
        <li>회원 정보 입력 : 나이 계산에는 sql에서 사용되는 R 연도 표시자 접근 방식을 적용</li>
        <li>회원이 존재하는 지 검색</li>
        <li>회원 존재여부 확인(string)</li>
        <li>회원 추가, 저장</li>
        <li>회원 탈퇴</li>
        <li>요일값 관리</li>
        <li>식단 작성</li>
        <li>식단 확인</li>
        <li>운동 루틴 작성</li>
        <li>운동 루틴 확인</li>
        <li>모드 안내</li>
        <li>트레이너가 접근할 수 있는 기능 수행(a)</li>
        <li>고객이 접근할 수 있는 기능 수행(b)</li>
        <li>관리자 여부에 따른 접근 기능 제한(관리자 여부에 따라 a,b에 맞게 실행할 수 있는 기능)</li>
        </ul>
    </li>
  </ul>
  </li>
  <li>
    ver2.controller.HealthController.java
    <ul>
      <li>멤버변수
        <ul>
        <li>#ManageDB mDb</li>
        <li><u>#User user</u></li>
        </ul>
      </li>
      <li>
      <ul>
      메서드
      <li>처음 방문 시, 꼭 실행되어야 할 정보입력 실행</li>
      <li>프로그램 사용 여부에 따른 작동</li>
      </ul>
      </li>
    </ul>
    </li>
    <li>
    ver2.run.Run.java
    <ul>
      <li>init메서드 실행</li>
      <li>execute 메서드 실행</li>
    </ul>
    </li>
</ol>


**2021-04-04 이후 추가 고려되어야 할 부분- 현재 권한에 따른 실행만 Run에서 적용하였는데, 여러가지 옵션을 주어 그 옵션에 따른 작동을 고려하여 v2.1로 수정해야 할 필요 존재 **
