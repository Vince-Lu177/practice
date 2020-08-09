#coding = utf-8
from selenium import webdriver
import os
import time
driver = webdriver.Chrome()
path = 'file:///C:/Users/LQQ2632469293/Desktop/selenium2html/selenium2html/checkbox.html'
driver.get(path)
inputs = driver.find_elements_by_tag_name('input')
# for input in inputs:
#     if input.get_attribute('type') == 'checkbox':
#         input.click()
inputs[0].click()
inputs[1].click()
inputs[2].click()
driver.quit()