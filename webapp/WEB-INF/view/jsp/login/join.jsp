<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3>회원가입</h3>
<form:form name="joinForm" action="/login/join" method="POST">
    <p>
        <label for="accountId">아이디</label>
        <input type="text" id="accountId" name="accountId" maxlength="30" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" />
    </p>
    <button type="submit" class="btn btn-primary">회원가입</button>
</form:form>