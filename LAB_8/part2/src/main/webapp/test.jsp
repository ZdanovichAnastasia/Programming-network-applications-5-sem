<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 27.11.2020
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <div>
            <h2>Тест по математике:</h2>
        </div>
        <div>
            <form method="post">
            <div>
                <label>1. Какое из этих чисел является простым? </label><br />
                <label><input type="radio" name="q1" value="34" checked>34</label>
                <label><input type="radio" name="q1" value="89">89</label>
                <label><input type="radio" name="q1" value="57">57</label>
                <label><input type="radio" name="q1" value="81">81</label>
            </div>
            <div>
            <label>2. Сколько киллограмм в одном пуде? </label></br>
            <label><input type="radio" name="q2" value="16" checked>16</label>
            <label><input type="radio" name="q2" value="8">8</label>
            <label><input type="radio" name="q2" value="14">14</label>
            <label><input type="radio" name="q2" value="12">12</label>
            </div>
            <div>
            <label>3. Сумма каких трех чисел равна их произведению? </label></br>
            <label><input type="radio" name="q3" value="1,2,4" checked>1,2,4</label>
            <label><input type="radio" name="q3" value="2,2,2">2,2,2</label>
            <label><input type="radio" name="q3" value="0,1,3">0,1,3</label>
            <label><input type="radio" name="q3" value="1,2,3">1,2,3</label>
            </div>
            <div>
            <label>4. Какое число надо прибавить к натуральному числу, чтобы получилось следующее за ним число? </label></br>
            <label><input type="radio" name="q4" value="13"checked>13</label>
            <label><input type="radio" name="q4" value="3">3</label>
            <label><input type="radio" name="q4" value="1">1</label>
            <label><input type="radio" name="q4" value="2">2</label>
            </div>
            <div>
            <div>
            <label>5. Сколько нужно сделать надрезов, чтобы разрезать огурец на 4 части? </label></br>
            <label><input type="radio" name="q5" value="1" checked>1</label>
            <label><input type="radio" name="q5" value="2">2</label>
            <label><input type="radio" name="q5" value="3">3</label>
            <label><input type="radio" name="q5" value="4">4</label>
            </div>
            <div>
            <label>6. Сколько разных высот можно провести в параллелограмме? </label></br>
            <label><input type="radio" name="q6" value="1" checked>1</label>
            <label><input type="radio" name="q6" value="2">2</label>
            <label><input type="radio" name="q6" value="3">3</label>
            <label><input type="radio" name="q6" value="4">4</label>
            </div>
            <div>
            <label>7. Выберите найбольшую римскую цифру? </label></br>
            <label><input type="radio" name="q7" value="IX" checked>IX</label>
            <label><input type="radio" name="q7" value="XC">XC</label>
            <label><input type="radio" name="q7" value="CM">CM</label>
            <label><input type="radio" name="q7" value="XI">XI</label>
            </div>
            <div>
            <label>8. Какой угол образуют минутная и часовая стрелки в 16:00? </label></br>
            <label><input type="radio" name="q8" value="210" checked>210</label>
            <label><input type="radio" name="q8" value="150">150</label>
            <label><input type="radio" name="q8" value="120">120</label>
            <label><input type="radio" name="q8" value="90">90</label>
            </div>
            <input type="submit" name="send" value="Отправить на проверку">

            </form>
        </div>
    </div>

</div>
</body>
</html>
