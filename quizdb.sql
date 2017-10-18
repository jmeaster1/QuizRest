LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` (name) VALUES ('States2');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (quiz_id, questionText) VALUES
(10,'What is the smallest state in the US'),
(10,'What is the Colorado state bird?'),
(10,'What is the capital of Colorado?'),
(10,'What is the Colorado state flower?'),
(10,'What is the official state dance of Colorado?');

/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` (question_id, answerText, isCorrect) VALUES (1,'Deleware',0),
(1,'Rhode Island',1),
(1,'Texas',0),
(1,'Maine',0),
(2,'Lark bunting',1),
(2,'Northern mockingbird',0),
(2,'Brown pelican',0),
(2,'Willow ptarmigan',0),
(3,'Vail',0),
(3,'Denver',1),
(3,'Aspen',0),
(3,'Parker',0),
(4,'Carnation',0),
(4,'Rocky Mountain Columbine',1),
(4,'Rhododendron',0),
(4,'Saguaro',0),
(5,'Clogging',0),
(5,'Square Dance',1),
(5,'Lindy Hop',0),
(5,'Two step',0);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;
