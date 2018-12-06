# LinkedList 만들기
- 저장소의 크기를 고정할 필요가 없다.
- 데이터를 등록하거나 삭제할 때 저장소의 크기가 자동으로 조정된다.
- 삽입, 삭제가 쉽다.

##01
- Bucket 클래스 준비
- LinkedList 클래스 준비

##02
Bucket 클래스에 다음 필드 및 생성자를 준비한다.
- ref:Object  --> 값 인스턴스의 주소를 담을 변수
- next:Bucket --> 다음 버킷의 주소를 담을 변수
- 기본 생성자 외에 ref, next를 받을 생성자 추가

LinkedList 클래스 다음 필드 및 생성자를 준비한다.
- start:Bucket  --> 시작 버킷을 가리킬 변수
- end:Bucket    --> 끝 버킷을 가리킬 변수
- 기본 생성자 준비
  => 최소 한 개의 버킷을 생성하여 작업 준비를 한다.

#03
- LinkedList에 값을 추가하는 add() 메서드를 추가한다.
  => void add(Object value)
  => 동작
    1) end가 가리키는 버킷에 값을 담는다.
    2) 새 버킷을 만든다.
    3) end 버킷이 새 버킷을 가리키게 한다.
    4) end는 새 버킷을 가리킨다.

#04
- LinkedList에서 값을 알아내는 get() 메서드를 추가한다.
  => Object get(int)
  => 동작
    1) start가 가리키는 버킷부터 index까지 탐색을 시작한다.
    2) index에 위치하는 버킷의 value를 리턴한다.

#05
- LinkedList의 크기를 알아낼 수 있도록 size()를 추가한다.
  pubic int size()
- 해결책?
  => 목록에 값을 추가하거나 삭제할 때 마다 카운트해야 한다.

#06
- 목록 중간에 값을 삽입하는 insert()를 추가하라.
  public void add(int index, Object value)
  => index < 0 또는 index > size() 인 경우, 무시한다.

#07
- 목록에서 인덱스로 지정한 항목을 삭제하라.
  public Object remove(int index)
  => 리턴 값은 삭제된 값이다.
  => index < 0 또는 index >= size() 인 경우, null을 리턴한다.

#08
- 목록에서 인덱스로 지정한 항목을 다른 값으로 교체한다.
  public Object set(int index, Object value)
  => 리턴 값은 변경 전 값이다.
  => index < 0 또는 index >= size() 인 경우, null을 리턴한다.




-
