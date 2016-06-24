// 윤호 연습 select 실행 
var mysql = require('mysql'); // mysql 연동 라이브러리 객체 준비

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'java80',
  password : '1111',
  database : 'testdb'
});

connection.connect();


connection.query(
		'select mno, email, pwd from member',
		function(err, rows, fields) {
	  if (err) throw err;
	  
	  for (var i = 0; i < rows.length; i++) {
		  console.log(rows[i].mno, rows[i].email, rows[i].pwd);
	  }
});

connection.end();