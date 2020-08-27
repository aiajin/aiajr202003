#!/usr/bin/env python
# coding: utf-8

# In[3]:


import keyword

print(keyword.kwlist)


# In[4]:


print("""안녕하세요
저는 유영진 입니다.
반갑습니다.""")


# In[6]:


print("안녕하세요.\n 저는 유영진 입니다.\n 반갑습니다.")


# In[7]:


print('안녕하세요!'*3)


# In[10]:


'안녕하세요' + 1


# In[11]:


hello = '안녕하세요'


# In[12]:


type(hello)


# In[15]:


print(hello[0])
print(hello[1])
print(hello[2])
print(hello[3])
print(hello[4])
# print(hello[5])


# In[19]:


print(hello[-1])
print(hello[-2])
print(hello[-3])
print(hello[-4])
print(hello[-5])
#print(hello[-6])


# In[28]:


print(hello)
print(hello[1:4])
print(hello[:4])
print(hello[1:])
print(hello[10:])


# In[33]:


10//3   # 정수 연산


# In[35]:


2**4   # 제곱 연산자


# In[37]:


num = input('숫자를 입력해주세요')


# In[39]:


type(num)


# In[43]:


#input_a = float(input('첫번째 숫자를 입력해주세요 >> '))
#input_b = float(input('두번째 숫자를 입력해주세요 >> '))

input_a = float(input('첫번째 숫자를 입력해주세요 >> '))
input_b = int(input('두번째 숫자를 입력해주세요 >> '))

print("+", input_a+input_b)
print("-", input_a-input_b)
print("*", input_a*input_b)
print("/", input_a/input_b)
print("//", input_a//input_b)
print("%", input_a%input_b)


# In[45]:


url_str = 'http//{}:{}/{}'.format('localhost', 8088, 'member')
print('Rest URL :', url_str)


# In[49]:


number = int(input('정수를 입력해주세요 >>'))

# 양의 정수 판별
if number>0 :
    print(number, '는 양의 정수입니다.')
    number += 100
    print(number)
    
# 음의 정수 판별
if number<0 :
    print(number, '는 음의 정수입니다.')
    
# 숫자 0 판별
if number==0 :
    print(number, '는 0입니다.')


# In[50]:


import datetime


# In[52]:


now = datetime.datetime.now()


# In[56]:


now_str = '{}년 {}월 {}일 {}:{}:{}'.format(now.year, now.month, now.day, now.hour, now.minute, now.second)
now_str2 = '{}.{}.{} {}:{}:{}'.format(now.year, now.month, now.day, now.hour, now.minute, now.second)


# In[57]:


print(now_str)
print(now_str2)


# In[58]:


if  3 <= now.month <= 5 :
    print('봄이 왔어요')
    
if 6 <= now.month <=9 :
    print('뜨거운 여름입니다.')


# In[61]:


# 숫자 입력
number = input('정수를 입력해주세요 >>> ')
last_number = number[-1] 

# 짝수 조건
if last_number in '02468':   # 10 ?
    print('짝수')
    
if last_number in '1357':
    print('홀수')
    
#if last_number == '0':
#    print(0)


# In[65]:


# 숫자 입력
number = int(input('정수입력 >>'))

if number%2 == 0 :
    print('짝수')
else :
    print('홀수')


# In[69]:


# 숫자 입력
number = int(input('정수입력 >>'))

if number == 0 :
    print('0 입니다.')
elif number%2 == 0 :   # else if()
    print('짝수 입니다.')
#elif number%2 != 0 :
else :
    print('홀수 입니다.')


# In[77]:


if 0 :
    print(True)
else : 
    print(False)
    
if '' :
    print(True)
else : 
    print(False)

# {} []
    
list_number = []
    
if list_number :
    print(True)
else : 
    print(False)


# In[80]:


number = 20

if number >= 19 : 
    pass    # 처리 구문이 없을때 에러를 발생시키지 않도록 합니다.
else :
    print('투표가 불가능합니다.')


# In[9]:


array = [10, 10.5, True, False, {}, '문자열', [1,10,100,1000]] # list 선언

array[0] = 1000 # list 요소 참조

print(array[-2]) # 인덱스 역순 참조
print(array[-2][1])

print(array[-1])
print(array[-1][2])

print(type(array), array)


# In[5]:


array[0:4]


# In[16]:


list_a = [1,2,3]

print(list_a)
print(list_a+list_a)  # list의 + 연산자
print(list_a*4)       # list의 * 연산자

# list에 요소 추가 : append - 요소를 맨 뒤에 추가
list_a.append(4)
list_a.append(5)

print(list_a)

# list에 요소 추가 : insert -특정 위치에 요소를 삽입
list_a.insert(2, 1000)

print(list_a)

# list 요소의 삭제 : del 사용
del list_a[0]

print(list_a)

# list 요소 삭제 : pop() 사용
list_a.pop(1)

print(list_a)



# In[20]:


list_b = [1,2,3,4,5,6,7,8,9,0,1,2]

# list의 범위안의 요소 삭제
del list_b[3:8]
print(list_b)

del list_b[:3]
print(list_b)

del list_b[1:]
print(list_b)


# In[22]:


list_c = [1,2,1,2]

list_c.remove(2)
print(list_c)

list_c.clear()
print(list_c)


# In[25]:


list_d = [10, 1000, 10000, 3000]

# list의 요소 확인 연산자 : in  -> 찬고자하는 요소값 in list
print(10 in list_d 
print(105 not in list_d)


# In[28]:


# 반복문 : for
for i in range(10):
    print(i)


# In[29]:


# for 문을 이용한 list의 일괄 참조
print('list_a :', list_a)
for n in list_a:
    print(n)


# In[43]:


#딕셔너리 : 키 : 값 형태로 데이터의 구조를 만드는 형식 { 키:값, 키:값,.....}

dic_movie = {
    'name' : '어벤져스',
    'cast' : ['아이언맨', '토르', '헐크']
}

print(type(dic_movie), dic_movie)


# In[45]:


# dict의 참조 : 키값으로 값을 참조
print('영화 제목 :', dic_movie['name'])
print('출연 : ', dic_movie['cast'])

dic_movie['runtime'] = 120

#print(dic_movie)

#for c in dic_movie['cast']:
for c in dic_movie.get('cast'):
    print('\t',c)


# In[46]:


# dict의 참조 : 키값으로 값을 참조
print('영화 제목 :', dic_movie['name'])
print('출연 : ', dic_movie['cast'])


# In[60]:


dic_movie['runtime'] = 120

#print(dic_movie)

#for c in dic_movie['cast']:
for c in dic_movie.get('cast'):
    print('\t',c)


# In[54]:


#print('상영시간 :', dic_movie['runtime'], '분')   
print('상영시간 :', dic_movie.get('runtime'), '분')   


# In[61]:


# dict의 요소 삭제
del dic_movie['runtime']

print(dic_movie)

run_time = dic_movie.get('runtime')
print(run_time)

if not run_time :
    print('상영 시간 정보가 없습니다.')

    


# In[ ]:





# In[ ]:




