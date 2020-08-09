#coding = utf-8
import time
import os
from selenium import webdriver
driver = webdriver.Chrome()
driver.maximize_window()
path = 'file:///C:/Users/LQQ2632469293/Desktop/selenium2html/drop_down.html'
driver.get(path)
#m = driver.find_element_by_id("ShippingMethod")
#m.find_element_by_xpath("//*[@id='ShippingMethod']/option[4]").click()
#m[4].click()
lists = driver.find_elements_by_tag_name("option")
# for list in lists:
#     if list.get_attribute("value") == '9.03':
#         list.click()
lists[4].click()
time.sleep(2)
driver.quit()