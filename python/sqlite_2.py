# DML : insert, update, delete
import sqlite3

# DB 연결
con = sqlite3.connect('sample')
cur = con.cursor()

# sql 실행
sql_insert = 'insert into usertable values (\'LEE\', \'lee\', \'lee@naver.com\', 2000)'
cur.execute(sql_insert)

con.commit()

print('insert ok!!')

con.close()
