# OPEN PROJECT
written by JIN (jin.ryoo@gmail.com)

## 구현 스택
* Spring Framework
* Spring MVC module
* Mybatis

## 프로젝트 설정 파일
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

## 구현 기능

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
      * /src/main/java/com/aia/op/member/controller/MemberRegController.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/MemberRegController.java)
      * /src/main/java/com/aia/op/member/controller/IdCheckController.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/IdCheckController.java)
    * Service
      * /src/main/java/com/aia/op/member/service/MemberRegService.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/MemberRegService.java)
      * /src/main/java/com/aia/op/member/service/IdCheckService.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/IdCheckService.java)
    * dao
        * /src/main/java/com/aia/op/member/dao/MemberDao.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/dao/MemberDao.java)
    * view ( JSP )
      * /src/main/webapp/WEB-INF/views/member/loginForm.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/loginForm.jsp)
      * /src/main/webapp/WEB-INF/views/member/memberReg.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/memberReg.jsp)
      * /src/main/webapp/WEB-INF/views/member/idCheck.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/memberReg.jsp)
    * servlet-context.xml
      * /src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/idCheck.jsp)
      ```
      <!-- 파일업로드 처리를 위한 multipartResolver bean 등록 -->
      <beans:bean id="multipartResolver"
         class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
         <beans:property name="defaultEncoding">
            <beans:value>utf-8</beans:value>
         </beans:property>
      </beans:bean>
      
      <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
      <resources mapping="/resources/**" location="/resources/" />
      <resources mapping="/css/**" location="/css/" />
      <resources mapping="/js/**" location="/js/" />
      <resources mapping="/upload/**" location="/upload/" />
      ```
* 로그인
    * controller
      * /src/main/java/com/aia/op/member/controller/LoginController.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/LoginController.java)
    * Service
      * /src/main/java/com/aia/op/member/service/MemberLoginService.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/MemberLoginService.java)
    * dao
        * /src/main/java/com/aia/op/member/dao/MemberDao.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/dao/MemberDao.java)
    * view ( JSP )
      * /src/main/webapp/WEB-INF/views/member/loginForm.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/loginForm.jsp)
      * /src/main/webapp/WEB-INF/views/member/login.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/login.jsp)
* 로그아웃
    * controller
      * /src/main/java/com/aia/op/member/controller/LogoutController.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/LogoutController.java)
    * Service
      * /src/main/java/com/aia/op/member/service/LogoutService.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/LogoutService.java)
    * dao
        * /src/main/java/com/aia/op/member/dao/MemberDao.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/dao/MemberDao.java)
    * view ( JSP )
      * /src/main/webapp/WEB-INF/views/member/logout.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/logout.jsp)
* 회원 정보 수정
    * controller
      * /src/main/java/com/aia/op/member/controller/MemberEditController.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/MemberEditController.java)
    * Service
      * /src/main/java/com/aia/op/member/service/MemberEditService.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/MemberEditService.java)
    * dao
        * /src/main/java/com/aia/op/member/dao/MemberDao.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/dao/MemberDao.java)
    * view ( JSP )
      * /src/main/webapp/WEB-INF/views/member/memberEditForm.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/memberEditForm.jsp)
      * /src/main/webapp/WEB-INF/views/member/memberEdit.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/memberEdit.jsp)
* 회원 정보 삭제
    * controller
      * /src/main/java/com/aia/op/member/controller/MemberDeleteController.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/controller/MemberDeleteController.java)
    * Service
      * /src/main/java/com/aia/op/member/service/MemberDeleteService.java
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/service/MemberDeleteService.java)
    * dao
        * /src/main/java/com/aia/op/member/dao/MemberDao.java
        * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/java/com/aia/op/member/dao/MemberDao.java)
    * view ( JSP )
      * /src/main/webapp/WEB-INF/views/member/memberDelete.jsp
      * [view-source](https://github.com/aiajin/aiajr202003/blob/master/spring_project/Spring-OpenProject/src/main/webapp/WEB-INF/views/member/memberDelete.jsp)
