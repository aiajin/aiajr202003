line_counter = 0            # 파일의 총 줄 수를 세는 변수
data_header = []           # 데이터의 필드값을 저장하는 리스트
sample_list = []         # shop의 개별 리스트를 저장하는 리스트

# 07_24_05_P.csv 파일을 smaple_data 객체에 저장
with open("07_24_05_P.csv") as smaple_data:
    while True:
        # 07_24_05_P.csv에 데이터 변수에 한 줄씩 저장
        data = smaple_data.readline()
        if not data:
            break                   # 데이터가 없을 때, 반복문 종료
        if line_counter == 0:               # 첫 번째 데이터는 데이터의 필드
            # 데이터의 필드는 data_header 리스트에 저장, 데이터 저장 시 ","로 분리
            data_header = data.split(",")
        else:
            # 일반 데이터는 sample_list 객체에 저장, 데이터 저장 시 ","로 분리
            sample_list.append(data.split(","))
        line_counter += 1

# print("Header:", data_header)               # 데이터 필드값 출력
print("Header:", data_header[0:5])          # 필드를 5개만 출력
for i in range(0, 10):                      # 데이터 출력(샘플 10개만)
    # print("Data",i,":",sample_list[i][0:5])
    print("Data", i, ":", sample_list[i][0:5])  # 데이터를 5개만 출력

# 전체 데이터 크기 출력
print("전체 데이터 사이즈 :", len(sample_list))
