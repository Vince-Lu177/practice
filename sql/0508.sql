update exam_result set math = math + 20 where name = 'liubei';
update exam_result set math = 80,chinese = 80 where name = 'tangsanzang';
update exam_result set math = math + 10 order by math limit 3;