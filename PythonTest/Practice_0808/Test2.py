from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import os
import time
driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
driver.maximize_window()
driver.find_element_by_id("kw").send_keys("alibaba")
time.sleep(3)
#driver.find_element_by_id("kw").send_keys(Keys.ENTER)
driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'a')
time.sleep(3)
driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'x')
time.sleep(3)
driver.find_element_by_id("kw").send_keys("ByteDance")
time.sleep(3)
driver.find_element_by_id("kw").send_keys(Keys.ENTER)
time.sleep(3)
target = driver.find_element_by_id("su")
ActionChains(driver).context_click(target).perform()
time.sleep(3)
driver.quit()