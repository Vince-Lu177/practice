#coding = utf-8
from selenium import webdriver
import os
import time
driver = webdriver.Chrome()
driver.maximize_window()
path = 'file:///C:/Users/LQQ2632469293/Desktop/selenium2html/frame.html'
driver.get(path)
driver.switch_to.frame("f1")
driver.switch_to.frame("f2")
driver.find_element_by_id("kw").send_keys("SmartX")
driver.find_element_by_id("su").click()
time.sleep(3)
driver.find_element_by_id("kw").clear()
time.sleep(3)
driver.switch_to.default_content()
driver.switch_to.frame("f1")
# driver.switch_to.frame("f2")
# # driver.find_element_by_id("kw").send_keys("Boss")
# # driver.find_element_by_id("su").click()
driver.find_element_by_link_text("click").click()
time.sleep(5)
driver.quit()