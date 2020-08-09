#coding = utf-8
from selenium import webdriver
import os
import time
driver = webdriver.Chrome()
driver.maximize_window()
path = 'file:///C:/Users/LQQ2632469293/Desktop/selenium2html/alert.html'
driver.get(path)
driver.find_element_by_id("tooltip").click()
alert = driver.switch_to.alert
text = alert.text
print(text)
time.sleep(5)
alert.accept()
time.sleep(5)
driver.quit()