from urllib import request
from bs4 import BeautifulSoup
import re

urls = "https://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo"
# url 열기 -> 응답
html = request.urlopen(urls)

soup = BeautifulSoup(html, "html.parser")

# 페이지의 타이틀 태그를 축출
print(soup.title)
print(soup.title.name)
print(soup.title.string)

# 페이지의 특정 테그 축출
print(soup.img)
print(soup.img['alt'])
print(soup.img['height'])
print(soup.img['width'])
print('________________________________________________________________________')

# 페이지 안의 모든 텍스트 노드를 축출
# print(soup.get_text())

# 하나의 태그를 축출
print(soup.find('a', class_='logo'))
print(soup.find('a', 'logo'))



print(soup.find(id='team_LG'))
print('________________________________________________________________________')

for tag in soup.find_all(text="순위"):
    print('>>>>> ', tag)
print('________________________________________________________________________')

for tag in soup.find_all(text=re.compile('순위')):
    print('>>>>> ', tag)
print('________________________________________________________________________')

# 열러개 태그를 축출
for tag in soup.find_all('a'):
    print(tag)
print('________________________________________________________________________')

for tag in soup.find_all('a', attrs={'class', 'logo'}):
    print(tag)
print('________________________________________________________________________')

for tag in soup.find_all(['a','img']):
    print(tag)
print('________________________________________________________________________')





# select() 메서들르 이용해서 span 태그를 찾습니다.
for index, team in enumerate(soup.select('td>div>span[id]'), start=1):
    print(index, '위 ', team.string)

