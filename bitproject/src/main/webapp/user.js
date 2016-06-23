/* 윤호 연습용 static file 응답하기  */
var mysql = require('mysql');
var dateFormat = require('dateformat');
var express = require('express');
var bodyParser = require('body-parser');
var app = express();

//express 모듈에 보조 장치 장착한다.
app.use(bodyParser.json()); // JSON 형식으로 넘오온 데이터 처리 
app.use(bodyParser.urlencoded({extended:true}));
app.use(express.static('www'));

var pool  = mysql.createPool({
  connectionLimit : 10,
  host     : 'localhost',
  user     : 'java80',
  password : '1111',
  database : 'testdb'
});

pool.on('connection', function() {
	console.log('커넥션 객체가 생성되었음.');
});

app.get('/', function (request, response) {
	response.send('Express 적용 예제');
});

connection.query('select * from member', function(err, rows, fields) {
	if(!err)
		console.log('this is:', rows);
	else
		console.log('error');
});

connection.end();