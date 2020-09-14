line_counter = 0            # 파일의 총 줄 수를 세는 변수
data_header = []           # 데이터의 필드값을 저장하는 리스트
new_shop_list = []  # 새로운 shop의 개별 리스트를 저장하는 리스트
shop = None

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
            print(len(data_header))
        else:
            # 일반 데이터는 sample_list 객체에 저장, 데이터 저장 시 ","로 분리
            shop = data.split(",")
            #print(shop[18])
            if len(shop) == 28 and shop[17] == '커피숍':
                # 업태 필드가 "커피숍" 것만 new_shop_list에 저장
                new_shop_list.append(shop)
        line_counter += 1

# for i in range(len(new_shop_list)):
#     print("Data",i,":",new_shop_list[i][0:19])

with open("new_shop_coffe.csv", "w", encoding='utf-8') as new_shop_coffe:
    new_shop_coffe.write(",".join(data_header).strip('\n')+"\n")
    for shop in new_shop_list:
        # new_shop_list 객체에 있는 데이터를 customers_USA_only.csv 파일에 쓰기
        new_shop_coffe.write(",".join(shop).strip('\n')+"\n")

    print('파일 작성 완료')
print('커피숍의 개수 :', len(new_shop_list))