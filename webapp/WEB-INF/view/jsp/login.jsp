<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3>아이디와 비밀번호를 입력해주세요.</h3>
<form:form name="loginForm" action="/login" method="POST">
    <p>
        <label for="accountId">아이디</label>
        <input type="text" id="accountId" name="accountId" maxlength="30" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" />
    </p>
    <button type="submit" class="btn btn-primary">로그인</button>
    <a href="<c:url value="/login/join" />">회원가입</a>
</form:form>