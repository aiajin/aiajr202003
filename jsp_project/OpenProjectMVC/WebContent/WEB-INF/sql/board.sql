DROP TABLE IF EXISTS project.`board3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE project.`board3` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `readnum` int(11) NOT NULL,
  `ref` int(11) NOT NULL,
  `step` int(11) NOT NULL,
  `low` int(11) NOT NULL,
  `isdel` int(11) NOT NULL,
  `write_idx` varchar(12) NOT NULL,
  `writer_id` varchar(12) NOT NULL,
  `writer_name` varchar(10) NOT NULL,
  `writedate` date NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;