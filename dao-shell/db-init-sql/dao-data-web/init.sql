CREATE TABLE `dot_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '埋点标记主键唯一.绝对禁止修改',
  `event_type` varchar(50) NOT NULL COMMENT '事件类型',
  `analysis_message` varchar(2000) DEFAULT NULL COMMENT '参数信息',
  `trigger_time` datetime NOT NULL COMMENT '触发时间点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打点数据表'