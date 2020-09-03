import logging

# Logger 생성
logger = logging.getLogger('myapp')
# FileHandler 생성
myapp_handler = logging.FileHandler('myapp.log')

# Logging Formatter 생성:
# 시간(asctime), 로깅 레벨(levelname), 프로세스(process ID), 메시지(message)
formatter = logging.Formatter('%(asctime)s %(levelname)s %(process)d%(message)s')

# FileHandler에 formatter 등록
myapp_handler.setFormatter(formatter)
# Logger에 'FileHandler' 등록
logger.addHandler(myapp_handler)
# 로깅 레벨 설정
logger.setLevel(logging.INFO)

# 로깅 정보 출력
logger.error('ERROR occurred')
logger.info('HERE WE ARE')
logger.info('TEST finished')
