student_number = 12
# 학생의 번호를 출력합니다.
print('학생번호 :', student_number)

st_number_str = str(student_number) # 문자열로 변경해주는 형변환 함수 str()

print(type(student_number)) # 변수의 타입 확인
print(type(st_number_str))  # 변수의 타입 확인

number_list1 = range(10)        # 0~9 까지의 숫자 리스트 반환
number_list2 = range(5,10)      # 5~9 까지의 숫자 리스트 반환
number_list3 = range(0,10,2)    # 0~9 까지의 짝수 숫자 리스트 반환

print("number_list1 :", type(number_list1))
print("number_list2 :", number_list2)
print("number_list3 :", number_list3)





del student_number # 변수 삭제
#print('학생번호 :', student_number)



