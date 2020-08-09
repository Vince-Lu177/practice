# #coding = utf-8
# from selenium import webdriver
# import os
# import time
# from selenium.webdriver import ActionChains
#
# driver = webdriver.Chrome()
# driver.maximize_window()
# path = 'file:///C:/Users/LQQ2632469293/Desktop/selenium2html/level_locate.html'
# driver.get(path)
# driver.find_element_by_link_text("Link1").click()
# button = driver.find_element_by_link_text("Another action")
# ActionChains(driver).move_to_element(button).perform()
# time.sleep(3)
# driver.quit()

#coding = utf-8
from selenium import webdriver
import os
import time
from selenium.webdriver.common.action_chains import ActionChains
driver = webdriver.Chrome()
driver.maximize_window()
path = 'file:///C:/Users/LQQ2632469293/Desktop/selenium2html/level_locate.html'
driver.get(path)
driver.find_element_by_link_text("Link1").click()
button = driver.find_element_by_link_text("Something else here")
ActionChains(driver).move_to_element(button).perform()
time.sleep(3)
driver.quit()