#!/usr/bin/env python
#encoding: utf-8
#用于获取java应用监控项键名
#./jvm_key_discovery url

# sys库
import sys
# url库
import urllib2
# json解析库
import json

# sys.argv[0]：脚本名
# sys.argv[1]：第一个参数
# sys.argv[n]: 第n个参数

# 获取json数据的URL
if len(sys.argv) >= 2:
    # 传入脚本的第一个参数作为url
    url = sys.argv[1]
else:
    # 如果没有传入url参数，设置默认url地址
    url="http://192.168.0.217:8085/cas/monitor/metrics"

# 获取url中json数据并转化为字典
try:
    # 获取json格式的字符串
    page=urllib2.urlopen(url)
    # 取出json文件里的内容，返回的格式是字符串
    html=page.read()
    # 转换成python中的字典格式，用json.loads()方法
    # 把json形式的字符串转换成python形式的Unicode字典
    status_dict=json.loads(html)
except:
    # 如果获取url中json数据失败就手动定义状态为DOWN
    status_dict = {'status':'DOWN'}

data = {}
keys_list = []


for key in status_dict.keys():
    key_dict = {}
    key_dict['{#JVM_KEY}'] = key
    keys_list.append(key_dict)

data['data'] = keys_list
jsonStr = json.dumps(data, sort_keys=True, indent=4)
print jsonStr
