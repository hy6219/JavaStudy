# 간단한 소개

색상, 문의 갯수, 기어타입에 대한 속성을 갖는 Car 클래스를 적절히 변형

# hy6219 의 ver 1 구현 내용 짧게 소개

추상클래스, 인터페이스, 다형성, 컬렉션을 활용할 수 있는 프로젝트로 확장

<ol type="1">
  <li>공통적으로 갖는 기능을 VehicleControl 인터페이스로 저장</li>
  <li>
    인터페이스를 구현한 VehicleCommon 추상클래스를 생성
    <ul>
      <li>공통 속성인 색상, 문의 갯수, 기어타입을 protected로 제한함으로써 데이터를 보호함과 동시에 상속도 확보</li>
      <li>각도에 따른 회전을 처리하기 위한 변수 pos 및 controlLF, controlRF, controlLB, controlRB 메서드(4사분면에서 원점을 기준으로 회전할 수 있도록) 작성</li>
      <li>인터페이스에서 선언한 메서드를 적절하게 오버라이딩</li>
    </ul>
  </li>
  <li>
    추상클래스 VehicleCommon을 상속받는 Vehicle 클래스 생성
    <ul>
      <li>지상, 수중, 공중에서의 운송수단 구별을 위한 inUse 변수 추가</li>
      <li>기본 생성자 및 공통속성을 갖는 생성자 생성</li>
      <li>동등성 및 동일성 비교(추후 응용, 확장을 위함)를 위하여 equals 메서드 및 hashCode()메서드를 오버라이딩</li>
      <li>toString메서드를 오버라이딩함으로써 주소값이 아닌 문자열 값을 반환(복잡해지는 문자열 연산 처리를 위하여 StringBuffer를 이용)</li>
      <li>컬렉션에서 제공되는(리스트 자료구조에 대해서 제공되는) sort 메서드를 이용하기 위해서 Comparator 인터페이스를 구현하도록 하고, compare메서드를 적절하게 오버라이딩(색상을 기준으로)</li>
      </ul>
  </li>
  <li>
    지상, 수중, 공중에서의 운송수단을 의미하는 Ground, Marine, Air 클래스 생성자 생성(inUse에 대한 setter도 생성자가 생성될 때 적용될 수 있도록 하였음)
  </li>
  <li>각 inUse에 해당되는 Car, ATV, Airplane 클래스 생성(Ground, Marine, Air클래스에서 생성했던 생성자를 super()생성자를 이용하여 활용)</li>
</ol>

마지막으로, 위를 축약하여 보여드릴 수 있는 다이어그램입니다.

<img src="https://github.com/RH0001/JavaStudy/blob/jisoo/Java_okky_study/%ED%99%94%EC%9D%B4%ED%8C%85_Car_class_%ED%99%95%EC%9E%A5%20%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8.png?raw=true"/>
