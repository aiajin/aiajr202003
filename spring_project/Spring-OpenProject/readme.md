# OPEN PROJECT
written by JIN (jin.ryoo@gmail.com)

## 구현 스택
* Spring Framework
* Spring MVC module
* Mybatis

### 프로젝트 설정 파일
* pom.xml ( Maven 빌드 도구 설정 ) 
    * /pom.xml 
    * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/pom.xml)
* web.xml ( Project 설정 )
    * /src/main/webapp/WEB-INF/web.xml      
    * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/web.xml)
* root-context.xml ( Spring container 설정 ) 
    * /src/main/webapp/WEB-INF/spring/root-context.xml
    * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/spring/root-context.xml)
* servlet-context.xml ( Spring MVC Container 설정 ) 
    * /src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
    * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml)

#### 구현 기능

* 회원 리스트
    * controller  
        * /src/main/java/com/aia/op/member/controller/MemberListController.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/MemberListController.java)
    * Service
        * /src/main/java/com/aia/op/member/service/MemberListService.java 
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/MemberListService.java)
    * dao
        * /src/main/java/com/aia/op/member/dao/MemberDao.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/dao/MemberDao.java)
    * view ( JSP )
        * /src/main/webapp/WEB-INF/views/member/memberList.jsp
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/memberList.jsp)
* 회원가입
    * controller
    * Service
    * dao
    * view ( JSP )
* 로그인
    * controller
    * Service
    * dao
    * view ( JSP )
* 로그아웃
    * controller
    * Service
    * dao
    * view ( JSP )
* 회원 정보 수정
    * controller
    * Service
    * dao
    * view ( JSP )
* 회원 정보 삭제
    * controller
    * Service
    * dao
    * view ( JSP )
