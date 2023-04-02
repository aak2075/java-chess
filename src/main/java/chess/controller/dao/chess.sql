-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: chess
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL,
  `piece_file` varchar(255) NOT NULL,
  `piece_rank` varchar(255) NOT NULL,
  `piece_color` varchar(255) NOT NULL,
  PRIMARY KEY (`game_id`,`piece_file`,`piece_rank`),
  CONSTRAINT `board_ibfk_1` FOREIGN KEY (`game_id`) REFERENCES `chess_game` (`game_id`),
  CONSTRAINT `board_ibfk_2` FOREIGN KEY (`game_id`) REFERENCES `chess_game` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (9,'chess.domain.piece.Rook','A','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','A','FIVE','NONE'),(9,'chess.domain.piece.Empty','A','FOUR','NONE'),(9,'chess.domain.piece.Rook','A','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','A','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','A','SIX','NONE'),(9,'chess.domain.piece.Empty','A','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','A','TWO','WHITE'),(9,'chess.domain.piece.Knight','B','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','B','FIVE','NONE'),(9,'chess.domain.piece.WhitePawn','B','FOUR','WHITE'),(9,'chess.domain.piece.Knight','B','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','B','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','B','SIX','NONE'),(9,'chess.domain.piece.Empty','B','THREE','NONE'),(9,'chess.domain.piece.Empty','B','TWO','NONE'),(9,'chess.domain.piece.Bishop','C','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','C','FIVE','NONE'),(9,'chess.domain.piece.Empty','C','FOUR','NONE'),(9,'chess.domain.piece.Bishop','C','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','C','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','C','SIX','NONE'),(9,'chess.domain.piece.Empty','C','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','C','TWO','WHITE'),(9,'chess.domain.piece.Queen','D','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','D','FIVE','NONE'),(9,'chess.domain.piece.Empty','D','FOUR','NONE'),(9,'chess.domain.piece.Queen','D','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','D','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','D','SIX','NONE'),(9,'chess.domain.piece.Empty','D','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','D','TWO','WHITE'),(9,'chess.domain.piece.King','E','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','E','FIVE','NONE'),(9,'chess.domain.piece.Empty','E','FOUR','NONE'),(9,'chess.domain.piece.King','E','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','E','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','E','SIX','NONE'),(9,'chess.domain.piece.Empty','E','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','E','TWO','WHITE'),(9,'chess.domain.piece.Bishop','F','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','F','FIVE','NONE'),(9,'chess.domain.piece.Empty','F','FOUR','NONE'),(9,'chess.domain.piece.Bishop','F','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','F','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','F','SIX','NONE'),(9,'chess.domain.piece.Empty','F','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','F','TWO','WHITE'),(9,'chess.domain.piece.Knight','G','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','G','FIVE','NONE'),(9,'chess.domain.piece.Empty','G','FOUR','NONE'),(9,'chess.domain.piece.Knight','G','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','G','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','G','SIX','NONE'),(9,'chess.domain.piece.Empty','G','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','G','TWO','WHITE'),(9,'chess.domain.piece.Rook','H','EIGHT','BLACK'),(9,'chess.domain.piece.Empty','H','FIVE','NONE'),(9,'chess.domain.piece.Empty','H','FOUR','NONE'),(9,'chess.domain.piece.Rook','H','ONE','WHITE'),(9,'chess.domain.piece.BlackPawn','H','SEVEN','BLACK'),(9,'chess.domain.piece.Empty','H','SIX','NONE'),(9,'chess.domain.piece.Empty','H','THREE','NONE'),(9,'chess.domain.piece.WhitePawn','H','TWO','WHITE'),(10,'chess.domain.piece.Rook','A','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','A','FIVE','NONE'),(10,'chess.domain.piece.WhitePawn','A','FOUR','WHITE'),(10,'chess.domain.piece.Rook','A','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','A','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','A','SIX','NONE'),(10,'chess.domain.piece.Empty','A','THREE','NONE'),(10,'chess.domain.piece.Empty','A','TWO','NONE'),(10,'chess.domain.piece.Knight','B','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','B','FIVE','NONE'),(10,'chess.domain.piece.Empty','B','FOUR','NONE'),(10,'chess.domain.piece.Knight','B','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','B','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','B','SIX','NONE'),(10,'chess.domain.piece.Empty','B','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','B','TWO','WHITE'),(10,'chess.domain.piece.Bishop','C','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','C','FIVE','NONE'),(10,'chess.domain.piece.Empty','C','FOUR','NONE'),(10,'chess.domain.piece.Bishop','C','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','C','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','C','SIX','NONE'),(10,'chess.domain.piece.Empty','C','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','C','TWO','WHITE'),(10,'chess.domain.piece.Queen','D','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','D','FIVE','NONE'),(10,'chess.domain.piece.Empty','D','FOUR','NONE'),(10,'chess.domain.piece.Queen','D','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','D','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','D','SIX','NONE'),(10,'chess.domain.piece.Empty','D','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','D','TWO','WHITE'),(10,'chess.domain.piece.King','E','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','E','FIVE','NONE'),(10,'chess.domain.piece.Empty','E','FOUR','NONE'),(10,'chess.domain.piece.King','E','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','E','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','E','SIX','NONE'),(10,'chess.domain.piece.Empty','E','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','E','TWO','WHITE'),(10,'chess.domain.piece.Bishop','F','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','F','FIVE','NONE'),(10,'chess.domain.piece.Empty','F','FOUR','NONE'),(10,'chess.domain.piece.Bishop','F','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','F','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','F','SIX','NONE'),(10,'chess.domain.piece.Empty','F','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','F','TWO','WHITE'),(10,'chess.domain.piece.Knight','G','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','G','FIVE','NONE'),(10,'chess.domain.piece.Empty','G','FOUR','NONE'),(10,'chess.domain.piece.Knight','G','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','G','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','G','SIX','NONE'),(10,'chess.domain.piece.Empty','G','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','G','TWO','WHITE'),(10,'chess.domain.piece.Rook','H','EIGHT','BLACK'),(10,'chess.domain.piece.Empty','H','FIVE','NONE'),(10,'chess.domain.piece.Empty','H','FOUR','NONE'),(10,'chess.domain.piece.Rook','H','ONE','WHITE'),(10,'chess.domain.piece.BlackPawn','H','SEVEN','BLACK'),(10,'chess.domain.piece.Empty','H','SIX','NONE'),(10,'chess.domain.piece.Empty','H','THREE','NONE'),(10,'chess.domain.piece.WhitePawn','H','TWO','WHITE'),(11,'chess.domain.piece.Rook','A','EIGHT','BLACK'),(11,'chess.domain.piece.Empty','A','FIVE','NONE'),(11,'chess.domain.piece.WhitePawn','A','FOUR','WHITE'),(11,'chess.domain.piece.Rook','A','ONE','WHITE'),(11,'chess.domain.piece.Empty','A','SEVEN','NONE'),(11,'chess.domain.piece.Empty','A','SIX','NONE'),(11,'chess.domain.piece.Empty','A','THREE','NONE'),(11,'chess.domain.piece.Empty','A','TWO','NONE'),(11,'chess.domain.piece.Knight','B','EIGHT','BLACK'),(11,'chess.domain.piece.BlackPawn','B','FIVE','BLACK'),(11,'chess.domain.piece.BlackPawn','B','FOUR','BLACK'),(11,'chess.domain.piece.Knight','B','ONE','WHITE'),(11,'chess.domain.piece.Empty','B','SEVEN','NONE'),(11,'chess.domain.piece.Empty','B','SIX','NONE'),(11,'chess.domain.piece.Empty','B','THREE','NONE'),(11,'chess.domain.piece.Empty','B','TWO','NONE'),(11,'chess.domain.piece.Bishop','C','EIGHT','BLACK'),(11,'chess.domain.piece.BlackPawn','C','FIVE','BLACK'),(11,'chess.domain.piece.WhitePawn','C','FOUR','WHITE'),(11,'chess.domain.piece.Bishop','C','ONE','WHITE'),(11,'chess.domain.piece.Empty','C','SEVEN','NONE'),(11,'chess.domain.piece.Empty','C','SIX','NONE'),(11,'chess.domain.piece.Empty','C','THREE','NONE'),(11,'chess.domain.piece.Empty','C','TWO','NONE'),(11,'chess.domain.piece.Queen','D','EIGHT','BLACK'),(11,'chess.domain.piece.Empty','D','FIVE','NONE'),(11,'chess.domain.piece.WhitePawn','D','FOUR','WHITE'),(11,'chess.domain.piece.Queen','D','ONE','WHITE'),(11,'chess.domain.piece.BlackPawn','D','SEVEN','BLACK'),(11,'chess.domain.piece.Empty','D','SIX','NONE'),(11,'chess.domain.piece.Empty','D','THREE','NONE'),(11,'chess.domain.piece.Empty','D','TWO','NONE'),(11,'chess.domain.piece.King','E','EIGHT','BLACK'),(11,'chess.domain.piece.Empty','E','FIVE','NONE'),(11,'chess.domain.piece.WhitePawn','E','FOUR','WHITE'),(11,'chess.domain.piece.King','E','ONE','WHITE'),(11,'chess.domain.piece.BlackPawn','E','SEVEN','BLACK'),(11,'chess.domain.piece.Empty','E','SIX','NONE'),(11,'chess.domain.piece.Empty','E','THREE','NONE'),(11,'chess.domain.piece.Empty','E','TWO','NONE'),(11,'chess.domain.piece.Bishop','F','EIGHT','BLACK'),(11,'chess.domain.piece.Empty','F','FIVE','NONE'),(11,'chess.domain.piece.Empty','F','FOUR','NONE'),(11,'chess.domain.piece.Bishop','F','ONE','WHITE'),(11,'chess.domain.piece.BlackPawn','F','SEVEN','BLACK'),(11,'chess.domain.piece.Empty','F','SIX','NONE'),(11,'chess.domain.piece.Empty','F','THREE','NONE'),(11,'chess.domain.piece.WhitePawn','F','TWO','WHITE'),(11,'chess.domain.piece.Knight','G','EIGHT','BLACK'),(11,'chess.domain.piece.Empty','G','FIVE','NONE'),(11,'chess.domain.piece.Empty','G','FOUR','NONE'),(11,'chess.domain.piece.Knight','G','ONE','WHITE'),(11,'chess.domain.piece.BlackPawn','G','SEVEN','BLACK'),(11,'chess.domain.piece.Empty','G','SIX','NONE'),(11,'chess.domain.piece.Empty','G','THREE','NONE'),(11,'chess.domain.piece.WhitePawn','G','TWO','WHITE'),(11,'chess.domain.piece.Rook','H','EIGHT','BLACK'),(11,'chess.domain.piece.Empty','H','FIVE','NONE'),(11,'chess.domain.piece.Empty','H','FOUR','NONE'),(11,'chess.domain.piece.Rook','H','ONE','WHITE'),(11,'chess.domain.piece.BlackPawn','H','SEVEN','BLACK'),(11,'chess.domain.piece.Empty','H','SIX','NONE'),(11,'chess.domain.piece.Empty','H','THREE','NONE'),(11,'chess.domain.piece.WhitePawn','H','TWO','WHITE'),(12,'chess.domain.piece.Rook','A','EIGHT','BLACK'),(12,'chess.domain.piece.WhitePawn','A','FIVE','WHITE'),(12,'chess.domain.piece.Empty','A','FOUR','NONE'),(12,'chess.domain.piece.Rook','A','ONE','WHITE'),(12,'chess.domain.piece.Empty','A','SEVEN','NONE'),(12,'chess.domain.piece.Empty','A','SIX','NONE'),(12,'chess.domain.piece.Empty','A','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','A','TWO','WHITE'),(12,'chess.domain.piece.Knight','B','EIGHT','BLACK'),(12,'chess.domain.piece.BlackPawn','B','FIVE','BLACK'),(12,'chess.domain.piece.Empty','B','FOUR','NONE'),(12,'chess.domain.piece.Knight','B','ONE','WHITE'),(12,'chess.domain.piece.Empty','B','SEVEN','NONE'),(12,'chess.domain.piece.Empty','B','SIX','NONE'),(12,'chess.domain.piece.Empty','B','THREE','NONE'),(12,'chess.domain.piece.Empty','B','TWO','NONE'),(12,'chess.domain.piece.Bishop','C','EIGHT','BLACK'),(12,'chess.domain.piece.Empty','C','FIVE','NONE'),(12,'chess.domain.piece.Empty','C','FOUR','NONE'),(12,'chess.domain.piece.Bishop','C','ONE','WHITE'),(12,'chess.domain.piece.BlackPawn','C','SEVEN','BLACK'),(12,'chess.domain.piece.Empty','C','SIX','NONE'),(12,'chess.domain.piece.Empty','C','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','C','TWO','WHITE'),(12,'chess.domain.piece.Queen','D','EIGHT','BLACK'),(12,'chess.domain.piece.Empty','D','FIVE','NONE'),(12,'chess.domain.piece.Empty','D','FOUR','NONE'),(12,'chess.domain.piece.Queen','D','ONE','WHITE'),(12,'chess.domain.piece.BlackPawn','D','SEVEN','BLACK'),(12,'chess.domain.piece.Empty','D','SIX','NONE'),(12,'chess.domain.piece.Empty','D','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','D','TWO','WHITE'),(12,'chess.domain.piece.King','E','EIGHT','BLACK'),(12,'chess.domain.piece.Empty','E','FIVE','NONE'),(12,'chess.domain.piece.Empty','E','FOUR','NONE'),(12,'chess.domain.piece.King','E','ONE','WHITE'),(12,'chess.domain.piece.BlackPawn','E','SEVEN','BLACK'),(12,'chess.domain.piece.Empty','E','SIX','NONE'),(12,'chess.domain.piece.Empty','E','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','E','TWO','WHITE'),(12,'chess.domain.piece.Bishop','F','EIGHT','BLACK'),(12,'chess.domain.piece.Empty','F','FIVE','NONE'),(12,'chess.domain.piece.Empty','F','FOUR','NONE'),(12,'chess.domain.piece.Bishop','F','ONE','WHITE'),(12,'chess.domain.piece.BlackPawn','F','SEVEN','BLACK'),(12,'chess.domain.piece.Empty','F','SIX','NONE'),(12,'chess.domain.piece.Empty','F','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','F','TWO','WHITE'),(12,'chess.domain.piece.Knight','G','EIGHT','BLACK'),(12,'chess.domain.piece.Empty','G','FIVE','NONE'),(12,'chess.domain.piece.Empty','G','FOUR','NONE'),(12,'chess.domain.piece.Knight','G','ONE','WHITE'),(12,'chess.domain.piece.BlackPawn','G','SEVEN','BLACK'),(12,'chess.domain.piece.Empty','G','SIX','NONE'),(12,'chess.domain.piece.Empty','G','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','G','TWO','WHITE'),(12,'chess.domain.piece.Rook','H','EIGHT','BLACK'),(12,'chess.domain.piece.Empty','H','FIVE','NONE'),(12,'chess.domain.piece.Empty','H','FOUR','NONE'),(12,'chess.domain.piece.Rook','H','ONE','WHITE'),(12,'chess.domain.piece.BlackPawn','H','SEVEN','BLACK'),(12,'chess.domain.piece.Empty','H','SIX','NONE'),(12,'chess.domain.piece.Empty','H','THREE','NONE'),(12,'chess.domain.piece.WhitePawn','H','TWO','WHITE');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chess_game`
--

DROP TABLE IF EXISTS `chess_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chess_game` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `game_turn` varchar(255) NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chess_game`
--

LOCK TABLES `chess_game` WRITE;
/*!40000 ALTER TABLE `chess_game` DISABLE KEYS */;
INSERT INTO `chess_game` VALUES (9,'maco','BLACK'),(10,'maco2','BLACK'),(11,'maco3','BLACK'),(12,'maco4','WHITE');
/*!40000 ALTER TABLE `chess_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chessGame`
--

DROP TABLE IF EXISTS `chessGame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chessGame` (
  `square_file` varchar(255) NOT NULL,
  `square_rank` varchar(255) NOT NULL,
  `piece_color` varchar(255) NOT NULL,
  `piece_kind` varchar(255) NOT NULL,
  `class_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chessGame`
--

LOCK TABLES `chessGame` WRITE;
/*!40000 ALTER TABLE `chessGame` DISABLE KEYS */;
/*!40000 ALTER TABLE `chessGame` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 13:37:30
