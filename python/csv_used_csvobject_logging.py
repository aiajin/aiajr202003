import logging              # logging
import logging.config       # logging.config
import csv                  # csv 객체 호출


# 모듈 호출 : logging
# Logger 생성
logging.config.fileConfig('logging.conf')
logger = logging.getLogger()

seoul_location_data = []                   # 기본 변수명 선언
header = []
rownum = 0

# 변수 선언 등 생략
logger.info('Open file {0}'.format("TEST",))

try:
    # 불러들일 데이터를 선언함, 한글 처리를 위한 encoding = "utf-8"
    with open("new_shop_coffe.csv", "r", encoding="utf-8") as p_file:
        # csv 객체를 이용해 csv_data 읽기, 특별히 데이터를 나누는 기준을 정하지지 않음
        csv_data = csv.reader(p_file)
        for row in csv_data:                # 읽어 온 데이터를 한 줄씩 처리
            if rownum == 0:
                header = row                # 첫 번째 줄은 데이터 필드로 따로 저장
            location = row[12]
            # '소재지 주소' 필드 데이터 추출, 한글 처리로 유니코드 데이터를 UTF-8로 변환
            if location.find(u"서울특별시") != -1:
                logger.info('ID {0} added'.format(row[0],))
                # "행정구역" 데이터에 서울특별시가 들어가 있으면 seoul_location_data List에 추가
                seoul_location_data.append(row)
            rownum += 1
except FileNotFoundError as ex:
    logger.error('File NOT found {0}'.format(e,))

logger.info('Write new_shop_coffe_seoul only data at {0}'.format(
    "new_shop_coffe_seoul_floating_data.csv",))
with open("new_shop_coffe_seoul_floating_data.csv", "w", encoding="utf8") as s_p_file:
    writer = csv.writer(s_p_file, delimiter='\t',
                        quotechar="'", quoting=csv.QUOTE_ALL)
    # csv.writer를 사용해 csv 파일 만들기
    # delimiter 필드 구분자,
    # quotechar는 필드 각 데이터를 묶는 문자,
    # quoting은 묶는 범위
    writer.writerow(header)             # 제목 필드 파일에 쓰기
    for row in seoul_location_data:
        writer.writerow(row)            # seoul_location_data에 있는 정보를 리스트에 쓰기
    print('쓰기완료')
    logger.info('Write finished')

logger.info('Program finished')
