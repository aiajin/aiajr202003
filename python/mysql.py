import pymysql

project_db = pymysql.connect(
    user='bit',
    passwd='bit',
    host='aia.cek50lbziasl.ap-northeast-2.rds.amazonaws.com',
    db='project',
    charset='utf8'
)

# 일반 튜플 형태로 값이 반환
cursor1 = project_db.cursor()
# 딕셔너리 형태로 값이 반환
cursor2 = project_db.cursor(pymysql.cursors.DictCursor)

sql = "SELECT * FROM `project`.`member`;"
cursor1.execute(sql)
result1 = cursor1.fetchall()

cursor2.execute(sql)
result2 = cursor2.fetchall()

print('튜플 형태로 출력')
for item in result1:
    print(item)

print('-------------------------------------------------------------')

print('딕셔너리 형태로 출력')
for item in result2:
    print(item)

# sql = "insert or update or delete"
# cursor.execute(sql)
# project_db.commit()


# data = ('ramen', 1)
# # SELECT
# sql = "SELECT * FROM `food` WHERE name = %s AND id = %s;"
# cursor.execute(sql, data)

# # DELETE
# sql = "DELETE FROM `food` WHERE `name` = %s AND `id` = %s;"
# cursor.execute(sql, data)
# db.commit()


# data = [['ramen', 1], ['fried rice', 2], ['chicken', 3]]
# SELECT
# sql = "SELECT * FROM `food` WHERE name = %s AND id = %s;"
# cursor.execute(sql, data)

# DELETE
# sql = "DELETE FROM `food` WHERE `name` = %s AND `id` = %s;"
# cursor.execute(sql, data)
# db.commit()
