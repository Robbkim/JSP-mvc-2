<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>�л�����</title>
</head>
<body>
<div align="center">
<%-- <center>�±� --%>
  <hr color="green" width="300">
  <h2>�� �� �� �� �� �� ��</h2>
  <hr color="green" width="300">
  <form name="insert" method="post" action="student.do">
    <input type="hidden" name="command" value="insert"/>
    <table border="1">
      <tr>
        <td>
                    ���̵� : <input type="text" name="id"><br>
                    �л��� : <input type="text" name="name"><br>
                    �б޸� : <input type="text" name="cname"><br>
          <input type="submit" value="���">
          <input type="reset" value="���">
        </td>
      </tr>    
    </table>
  </form>
  <hr color="green" width="300">
  <h2>�� �� �� �� �� �� ��</h2>
  <hr color="green" width="300">
  <form name="delete" method="post" action="student.do">
    <input type="hidden" name="command" value="delete"/>
    <table border="1">
      <tr>
        <td>
                    ���̵� : <input type="text" name="id">
          <input type="submit" value="����">
        </td>
      </tr>    
    </table>                
  </form>
  <hr color="green" width="300">
  <h2>�� �� ã �� �� �� ��</h2>
  <hr color="green" width="300">
  <form name="find" method="post" action="student.do">
    <input type="hidden" name="command" value="find"/>
    <table border="1">
      <tr>
        <td>
                    �л��� : <input type="text" name="name">
          <input type="submit" value="ã��">
        </td>
      </tr>  
    </table>
  </form>
  <hr color="green" width="300">
  <h2>�� �� �� �� �� �� ��</h2>
  <hr color="green" width="300">
  <form name="list" method="post" action="student.do">
    <input type="hidden" name="command" value="list"/>
    <table border="1">
      <tr>
        <td>
          <input type="submit" value="��Ϻ���">
        </td>
      </tr>    
    </table>
  </form>
</div>
</body>
</html>                    