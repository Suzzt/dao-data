道可道,非常道.乘天地之正气,而御六气之辩.
# 项目愿景
屏蔽大数据分析重复造轮子的痛点，构建一套大数据生态带来的繁琐？好！这里就来实现一套面向olap自主灵活分析开箱即用的一站式服务。现实人人是数据分析师愿景，每一个微小的念头，都值得用数据浇灌，赋能业务。

# 技术要求
SpringBoot(2.4.5)、kafka(2.8)、zookeeper、redis、mysql、Hadoop、Spark、Hive、Hbase、phoenix、Elasticsearch、Flink、Flink-cdc、Canal、Kylin、clickhouse

备注：上述所用版本经过本人实践适配

# 代码架构分层介绍
dao-common --- 公共层

dao-data-web --- web交互

analysis --- 分析层：调度分析

dao-core-calculate --- 计算层：核心计算

dao-task-butler --- 任务管家：协调任务

dao-shell --- 执行脚本

dao-data-factory --- 数据工厂

# 架构分层
![img_5](https://user-images.githubusercontent.com/27397567/215265706-e12177a1-512c-45ef-9c58-daf6838aa666.png)

# 技术架构
![img_4](https://user-images.githubusercontent.com/27397567/215265602-68f03cf5-5a51-4225-88b0-245547aa0279.png)

# 服务架构
![img_3](https://user-images.githubusercontent.com/27397567/215265585-3f39de75-ed61-47cc-a3bf-a6a928b451d4.png)

# 模型构建介绍
星型：

雪花：
# 部署方案


