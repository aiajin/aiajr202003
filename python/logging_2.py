import logging

# Logger 선언 : Logger 객체 획득
logger = logging.getLogger("main")
# Logger의 출력 방법 선언 : 파일, 화면, 다른 네트워크 등을 선택
stream_hander = logging.StreamHandler()
# Logger의 출력 등록 : 핸들러를 로거에 등록
logger.addHandler(stream_hander)

# 출력 레벨 설정
logger.setLevel(logging.DEBUG)

logger.debug("틀렸습니다!")
logger.info("확인해주세요!")
logger.warning("조심해야합니다!")
logger.error("에러 났네요!!!")
logger.critical("크...허...망...")
