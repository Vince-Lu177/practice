#coding = utf-8
from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com")
#browser.maximize_window()
browser.find_element_by_id("kw").send_keys("阿里巴巴")
browser.find_element_by_id("su").click()
time.sleep(2)
js1 = "var q = document.documentElement.scrollTop=10000"
browser.execute_script(js1)
time.sleep(2)
js2 = "var p = document.documentElement.scrollTop=0"
browser.execute_script(js2)
time.sleep(2)
js3 = "window.scrollTo(100,200)"
browser.execute_script(js3)
browser.quit()