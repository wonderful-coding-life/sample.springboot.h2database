# sample.springboot.h2database
* H2 데이터베이스는 어플리케이션 실행시 매번 초기화되는 메모리 내장형 데이터베이스(in-memory database)로서 개발 단계에서 많이 사용합니다.  
* 서버 어플리케이션은 데이터베이스와 연동하는 경우가 많은데, 개발시 사용할 데이터베이스를 별도로 구축할 필요도 없고 매번 데이터베이스를 초기화 할 필요가 없기 때문에 특히 개발단계 또는 디버깅 단계에서 아주 유용하게 사용할 수 있습니다.  
* 특히 schema.sql, data.sql을 통해 초기화도 SQL로 설정할 수 있어 별도의 스키마 생성, 초기 데이터 설정을 간단하게 수행할 수 있습니다.  
* 또한 간단하게 데이터베이스를 살펴볼 수 있도록 웹기반의 콘솔을 지원하기 때문에 별도의 데이터베이스 클라이언트 앱이 필요 없습니다.  
* 사용자 정보를 추가, 삭제, 수정, 조회할 수 있는 Restful API에 H2 데이터베이스를 연동하는 샘플 예제입니다.  
* H2 데이터베이스 공식 홈페이지: https://www.h2database.com  
