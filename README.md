서비스 시나리오

기능적 요구사항
- 고객이 메뉴를 선택하여 주문한다.
- 고객이 선택한 메뉴에 대해 결제한다.
- 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다.
- 상점주는 주문을 수락하거나 거절할 수 있다.
- 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다.
- 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다.
- 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다.
- 라이더가 해당 요리를 pick 한후, pick했다고 앱을 통해 통보한다.
- 고객이 주문상태를 중간중간 조회한다.
- 라이더의 배달이 끝나면 배송확인 버튼으로 모든 거래가 완료된다.

비기능적 요구사항
- 트랜잭션
- 결제가 되지 않은 주문건은 아예 거래가 성립되지 않아야 한다 Sync 호출
- 장애격리
- 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다 Async (event-driven), Eventual Consistency
- 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다 Circuit breaker, fallback
- 성능
- 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다 CQRS
- 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다 Event driven

L3 평가를 위한 체크포인트
Microservice Implementation
- Saga (Pub / Sub)
- CQRS
- Compensation / Correlation

Microservice Orchestration
- Deploy to EKS Cluster
- Gateway & Service Router 설치
- Autoscale (HPA)

# fd-0215 -order 만 정상 작동중입니다.
![image](https://user-images.githubusercontent.com/119825867/218976011-4f825bc6-16d7-4939-a837-076a4590c7de.png)

1. Saga (Pub / Sub) 아래는 PUB/SUB 구현된 코드
![image](https://user-images.githubusercontent.com/119825867/218937778-1d5ad929-7dd9-4c39-a806-6f8271cdee3e.png)

2. CQRS 아래는 CQRS 구현된 코드
![image](https://user-images.githubusercontent.com/119825867/218938345-bb981794-361b-4f4f-9681-68a38ff72be7.png)
![image](https://user-images.githubusercontent.com/119825867/218938358-918b7398-0a22-43ba-ba0b-5060476ed2c0.png)

3. Compensation / Correlation
주문이 취소될 때 Compensation이 발생한다. Order 클래스에서 @PreRemove 어노테이션이 적용된 onPrePersist 메소드에서 구현한다.
주문취소 이벤트 OrderCanceled를 publish하면서 다른 서비스인 store에서 updateStatus 정책을 통해 상태를 변경할 수 있다.
서로 다른 마이크로서비스 간 데이터 일관성 처리를 위해 사용하는 correlation key에 대해 주문의 아이디인 orderId를 사용한다.
order 서비스의 Order.java
 ![image](https://user-images.githubusercontent.com/119825867/218981168-01a4d6cd-a37b-470c-bcc3-a70a2d3aad53.png)

store 서비스의 PolicyHandler.java
![image](https://user-images.githubusercontent.com/119825867/218981224-f6ee5149-3420-4813-bedd-1c13c9035580.png)

4. Deploy to EKS Cluster
![image](https://user-images.githubusercontent.com/119825867/218954221-b9bb91a3-9ac3-4be8-a433-c3b344697302.png)
![image](https://user-images.githubusercontent.com/119825867/218954422-a2498b7a-38bf-454e-a0ca-ac3bc28ca9d1.png)
![image](https://user-images.githubusercontent.com/119825867/218954769-2e0ceaa5-829e-446e-8f61-3ef116d2fcf9.png)
![image](https://user-images.githubusercontent.com/119825867/218955098-27916b2c-ca66-4bea-b72f-1ef4deeb212a.png)
![image](https://user-images.githubusercontent.com/119825867/218956134-8a68c992-b37c-401a-bde3-ea3753dff044.png)


5. Gateway & Service Router 설치
![image](https://user-images.githubusercontent.com/119825867/219212509-9be5b4e1-3142-475e-9794-b3c1c05d914e.png)
![image](https://user-images.githubusercontent.com/119825867/219212683-75dc89d9-8116-4e43-b4d2-c397f0de0bc7.png)

6. Autoscale (HPA)

![image](https://user-images.githubusercontent.com/119825867/218957200-6c921ea5-1df7-4ab2-834e-9346ff6ebfe3.png)
