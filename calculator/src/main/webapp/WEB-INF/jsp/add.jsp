<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <h1>Addition</h1>
    <form:form method="post" modelAttribute="calculator">
        <form:label path="num1s">First number</form:label>
        <form:input path="numf1" type="text" value=""/><br>

        <form:label path="num2">Second number</form:label>
        <form:input path="num2" type="text" value="" /> <br>

        <button type="submit">Submit</button>
    </form:form>
</div>