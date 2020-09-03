# urllib 모듈 호출
import urllib.request
# 정규싱을 사용
import re

# url 값 입력
url = "http://www.google.com/googlebooks/uspto-patents-grants-text.html"
# url 열기
html = urllib.request.urlopen(url)
# html 파일 읽고, 문자열로 변환
html_contents = str(html.read().decode("utf8"))

# 정규식으로 특정 데이터 찾기
url_list = re.findall(r"(http)(.+)(zip)", html_contents)

for url in url_list:
    print(url)
    # 출력된 튜플 형태 데이터 문자열로 join
    full_url = "".join(url)
    print(full_url)
    # file_name에 다운로드할 파일명 입력한 후, 파일 다운로드
    file_name = full_url.split("/")[-1]
    fname, header = urllib.request.urlretrieve(full_url, file_name)
    print("End Download")
