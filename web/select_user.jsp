<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="cn.hotal.utils.JDBCUtils" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: songHat
  Date: 2020/1/2
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">
<title>住宿信息管理</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css"  href="css/styles.css">
    <link >
    <style>
        body{
            background-color:rgb(202,240,211) ;
        }
        a {
            -webkit-appearance: button;
            -moz-appearance: button;
            border-radius: 50px;

            text-decoration: none;
            color: initial;
            width: 75%;
            margin-bottom: 6%;
        }
        h3{
            /*color: #999999;*/
        }
        ul{
            padding:0px;
        }
        li{
            list-style: none;
            margin-bottom: 20px;
            font-family: 微软雅黑;
        }
        #but1{
            height: 40px;
            width: 100px;
            color: white;
            border: none;
            font-family: 方正综艺简体;
            border-radius: 5px;
            padding-left: 10px;
            padding-right: 10px;
            text-align: center;
            background-color: red;
            animation: A 1.5s;
            animation-fill-mode: forwards;
            transition-timing-function: inherit;
        }
        @keyframes A {
            0%{
                opacity: 0%;
                transform: translate3d(0,0,0);
            }
            100%{
                opacity: 100%;
                transform: translate3d(0,60px,0);
            }

        }
        .but{
            height: 40px;
            width: 100px;
            color: white;
            border: none;
            background-color: rgb(181, 218, 190);
            font-family: 方正综艺简体;
            border-radius: 5px;
        }
        #but{
            background-color: rgba(255, 0, 0, 0.53);
        }
        .box{
            width: 40%;
            height: 35px;
            border: #999999 solid 1px;
            border-radius: 5px;

        }
        .folat{
            float: left;
        }
        .folat1{
            float: left;
            margin-left: 50%;
            clear: right;
        }
        .out{
            margin-top: 20px;
            margin-left: 10%;
            margin-bottom: 20px;
            width: 80%;
            border: rgba(153, 153, 153, 0.63) solid 2px;
            height: 400px;
        }
        #whith{
            width: 50%;
        }
        .form-control{
            /*width: 50%;*/
        }
        .login{
        }
        #gai{
            margin-top: 50px;
        }
        .top{
            margin-top: 40px;
        }


    </style>
</head>
<body>
<%
    String account = request.getParameter("account");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSouce());

    String sql = "select * from Huser where account = ?";
    Map<String, Object> map = jdbcTemplate.queryForMap(sql,account);
%>


<div id="login-bg" class="container-fluid">

    <div class="bg-img"></div>
    <div class="bg-color"></div>
</div>

<div class="container" id="login">
    <div class="row justify-content-center">
        <div class="col-lg-8">
            <div class="login">
                <div class="out">
                    <ul>
                        <li class="top">账号:<%=map.get("account")%></li>
                        <li>密码:<%=map.get("password")%></li>
                        <li>姓名:<%=map.get("name")%></li>
                        <li>性别:<%=map.get("sex")%></li>
                        <li>手机号码:<%=map.get("phoneNum")%></li>
                        <li>身份证号码:<%=map.get("IDNum")%></li>
                        <li><button id="but1">返回</button></li>
                    </ul>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>