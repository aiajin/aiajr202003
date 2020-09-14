import urllib.request
import re

#URL 설정
url = "https://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo"

# url 열기
html = urllib.request.urlopen(url)
# html 파일 읽고, 문자열로 변환
html_contents = str(html.read().decode("utf-8"))

# 정규식으로 특정 데이터 찾기
#tag_list = re.findall(r"(<span id=\"team_)(.+)(</span>)", html_contents)
tag_list = re.findall(r'(<span id=\"team_.+\">)(.+)(<\/span>)', html_contents)

# 순위 는 index로 표현하기 위해 enumerate 사용
for index, result in enumerate(tag_list, start=1):
    #print(result);
    #print(index, '위 ', result[1].split('>')[1])
    print(index, '위 ', result[1])