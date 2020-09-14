import urllib.request   # urllib 모듈 호출
# 다운로드 URL 주소
# https://www.google.com/googlebooks/uspto-patents-grants-text.html
#      http://storage.googleapis.com/patents/grant_full_text/2014/ipg140107.zip
url = "http://storage.googleapis.com/patents/grant_full_text/2014/ipg140107.zip"

print("Start Download")
# urlretrieve() 함수 호출(URL 주소, 다운로드할 파일명),
# 결과값으로 다운로드한 파일명과 Header 정보를 언패킹
fname, header = urllib.request.urlretrieve(url, 'ipg140107.zip')
print('fname', fname)
print('header', header)

print("End Download")
