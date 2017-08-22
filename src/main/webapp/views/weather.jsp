<%--
  Created by IntelliJ IDEA.
  User: Grand Circus Student
  Date: 8/17/2017
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather Forecast</title>
    <link rel="stylesheet" href="/resources/styles.css">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Lato|Noto+Sans');
        table {
            font-family: 'Lato', sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>

<body>
Response status: ${status}<br/>
Production center: ${prodCenter}<br/>

<table align="center">
    <tr>
    <th>Day</th>
    <th>Temperature</th>
    <th>Weather</th>
        <%--<th>Icon</th>--%>
    </tr>

    <tr>
    <td>${day1} </td>
     <td>${temp1}</td>
     <td>${weats1}</td>
        <%--  <td>${icon1}</td> --%>
        </tr>
    <tr>

        <td>${day2}</td>
        <td>${temp2}</td>
        <td>${weats2}</td>
        <%-- <td>${icon2}</td> --%>
    </tr>

       <tr>
    <td>${day3} </td>
    <td>${temp3}</td>
    <td>${weats3}</td>
           <%-- <td>${icon3}</td> --%>
     </tr>

    <tr>
    <td>${day4} </td>
     <td>${temp4}</td>
     <td>${weats4}</td>
        <%-- <td>${icon4}</td> --%>
    </tr>

    <tr>
        <td>${day5} </td>
        <td>${temp5}</td>
        <td>${weats5}</td>
        <%--<td>${icon5}</td> --%>
    </tr>

    <tr>
        <td>${day6}</td>
     <td>${temp6}</td>
        <td>${weats6}</td>
        <%-- <td>${icon6}</td>--%>
    </tr>

    <tr>
    <td>${day7} </td>
    <td>${temp7}</td>
    <td>${weats7}</td>
        <%--     <td>${icon7}</td>--%>
    </tr>

    <tr>
    <td>${day8} </td>
    <td>${temp8}</td>
    <td>${weats8}</td>
        <%-- <td>${icon8}</td>--%>
    </tr>

    <tr>
        <td>${day9}</td>
        <td>${temp9}</td>
        <td>${weats9}</td>
        <%-- <td>${icon9}</td> --%>
    </tr>

    <tr>
    <td>${day10} </td>
    <td>${weats10}</td>
        <td>${temp10}</td>
        <%-- <td>${icon10}</td> --%>
    </tr>

</table>

</body>
</html>
