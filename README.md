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

L3 평가를 위한 체크포인트
Microservice Implementation
- Saga (Pub / Sub)
- CQRS
- Compensation / Correlation
Microservice Orchestration
- Deploy to EKS Cluster
- Gateway & Service Router 설치
- Autoscale (HPA)

# fd-0215
1. Saga (Pub / Sub) 아래는 PUB/SUB 구현된 코드
![image](https://user-images.githubusercontent.com/119825867/218937778-1d5ad929-7dd9-4c39-a806-6f8271cdee3e.png)

2. CQRS 아래는 CQRS 구현된 코드
![image](https://user-images.githubusercontent.com/119825867/218938345-bb981794-361b-4f4f-9681-68a38ff72be7.png)
![image](https://user-images.githubusercontent.com/119825867/218938358-918b7398-0a22-43ba-ba0b-5060476ed2c0.png)
