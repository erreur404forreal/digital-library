-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 27 déc. 2018 à 17:34
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `elibrary`
--

--
-- Déchargement des données de la table `library`
--
USE elibrary
INSERT INTO `library` (`libId`, `city`, `libName`) VALUES
(100, 'Paris', 'PlaisirDeLire'),
(200, 'Toulouse', 'Infini');

--
-- Déchargement des données de la table `work`
--

INSERT INTO `work` (`worksId`, `author`, `bookDescription`, `imgUrl`, `literaryGenre`, `publicationYear`, `title`, `copies`, `library_libId`) VALUES
(1, 'Victor Hugo', 'Je m\'appelle Jean Valjean. Je suis un galérien. J\'ai passé dix-neuf ans au bagne. Je suis libéré depuis quatre jours et en route pour Pontarlier qui est ma destination. Quatre jours que je marche depuis Toulon. Aujourd\'hui j\'ai fait douze lieues à pied. ', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', ' Roman', 2013, 'LES MISÉRABLES ', 1, 100),
(2, 'Daniel Keyes', 'Quand la police de l’Ohio arrête l’auteur présumé de trois, voire quatre, viols de jeunes femmes, elle pense que l’affaire est entendue : les victimes reconnaissent formellement le coupable, et celui-ci possède chez lui la totalité de ce qui leur a été vo', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Thriller', 2009, 'LES MILLES ET UNES VIES DE BILLY MILLIGAN', 1, 100),
(3, 'Chris Voss', 'A former international hostage negotiator for the FBI offers a new, field-tested approach to high-stakes negotiations—whether in the boardroom or at home.', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Business', 2016, 'NEVER SPLIT THE DIFFERENCE', 1, 100),
(4, 'John C. Sanford', 'Genetic Entropy presents compelling scientific evidence that the genomes of all living creatures are slowly degenerating - due to the accumulation of slightly harmful mutations. This is happening in spite of natural selection...', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Science', 2005, 'GENETIC ENTROPY  & THE MYSTERY OF THE GENOME', 1, 100),
(5, 'Daniel Keyes', 'Lorsque Billy Milligan est transféré à l\'hôpital d\'État pour malades mentaux criminels de Lima, dans l\'Ohio, il ne sait pas encore que débute pour lui une effroyable descente aux enfers. Passages à tabac, racket, camisole chimique, électrochocs...', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Romans policiers', 2009, 'LES MILLES ET UNES GUERRES DE BILLY MILLIGAN ', 1, 100),
(6, 'Daniel Keyes', 'Algernon est une souris dont le traitement du Pr Nemur et du Dr Strauss vient de décupler l\'intelligence. Enhardis par cette réussite, les savants tentent, avec l\'assistance de la psychologue Alice Kinnian, d\'appliquer leur découverte à Charlie Gordon...', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Science-Fiction', 2012, 'DES FLEURS POUR ALGERNON ', 1, 100),
(8, 'Voltaire ', 'Le plus célèbre conte philosophique de Voltaire est une oeuvre drôle et féroce dans laquelle l’auteur nous mène avec son héros à la recherche du meilleur des mondes…', 'http://localhost:8080/xampp/htdocs/e-library/img/c.jpg', 'Satire, conte philosophique', 2013, 'CANDIDE', 1, 100),
(11, 'Émile Zola ', 'Octave Mouret affole les femmes de désir. Son grand magasin parisien, Au Bonheur des Dames, est un paradis pour les sens. Les tissus s\'amoncellent, éblouissants, délicats, de faille ou de soie. Tout ce qu\'une femme peut acheter en 1883...', 'http://localhost:8080/xampp/htdocs/e-library/img/c.jpg', 'Roman', 1997, 'AU BONHEUR DES DAMES', 1, 100),
(12, 'Dostoïevski', 'A Saint-Pétersbourg, en 1865, Raskolnikov, un jeune noble sombre et altier, renfermé mais aussi généreux, a interrompu ses études faute d\'argent. Endetté auprès de sa logeuse qui lui loue une étroite mansarde, il se sent écrasé par sa pauvreté...', 'http://localhost:8080/xampp/htdocs/e-library/img/c.jpg', 'Roman', 2008, 'CRIME ET CHATIMENT', 1, 100),
(13, 'Hunter S. Thompson', 'Le journaliste Raoul Duke et son avocat, le célèbre Docteur Gonzo, partent pour Las Vegas. Après soixante-dix heures sans sommeil, un enlèvement, de sauvages poursuites sur l\'autoroute et deux chambres d\'hôtel dévastées, trouveront-ils le Rêve Américain ?', 'http://localhost:8080/xampp/htdocs/e-library/img/c.jpg', 'Roman', 2010, 'LAS VEGAS PARANO', 1, 100),
(15, 'Antoine de Saint-Exupéry', 'J\'ai ainsi vécu seul, sans personne avec qui parler véritablement, jusqu\'à une panne dans le désert du Sahara, il y a six ans. Quelque chose s\'était cassé dans mon moteur.\r\nEt comme je n\'avais avec moi ni mécanicien, ni passagers, je me préparai à...', 'http://localhost:8080/xampp/htdocs/e-library/img/c.jpg', 'Roman', 1999, 'LE PETIT PRINCE', 1, 100),
(17, 'Alexandre Dumas', 'Aux trois gentilshommes mousquetaires Athos, Porthos et Aramis, toujours prêts à en découdre avec les gardes du Cardinal de Richelieu, s\'associe le jeune gascon d\'Artagnan fraîchement débarqué de sa province avec pour ambition de servir le roi Louis XIII.', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Roman', 2002, 'LES TROIS MOUSQUETAIRES', 1, 100),
(61, 'TA-NEHISI COATES', 'Le corps des Noirs, marqué par l\'esclavage, continue d\'être violenté au nom du rêve américain. Avec cet appel criant à l\'adresse de son fils, un écrivain est né.', 'http://localhost:8080/xampp/htdocs/e-library/img/mvbm.jpg', 'Essai', 2016, 'UNE COLÈRE NOIRE LETTRE A MON FILS', 1, 100);



--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`bookId`, `isAvailable`, `borrowing_idborrow`, `work_worksId`) VALUES
(1, b'1', NULL, 17),
(2, b'1', NULL, 15),
(3, b'1', NULL, 3),
(4, b'1', NULL, 12),
(5, b'1', NULL, 2),
(6, b'1', NULL, 5),
(7, b'1', NULL, 6),
(8, b'1', NULL, 11),
(9, b'1', NULL, 13),
(10, b'1', NULL, 4),
(11, b'1', NULL, 61),
(12, b'1', NULL, 8),
(13, b'1', NULL, 1);

--
-- Déchargement des données de la table `work_book`
--

INSERT INTO `work_book` (`Work_worksId`, `books_bookId`) VALUES
(1, 13),
(2, 5),
(3, 3),
(4, 10),
(5, 6),
(6, 7),
(8, 12),
(11, 8),
(12, 4),
(13, 9),
(15, 2),
(17, 1),
(61, 11);

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`iduser`, `password`, `username`) VALUES
(99, 'pierre1', 'Pierre'),
(100, 'step2', 'Stephanie'),
(101, '1234', 'josue');

--
-- Déchargement des données de la table `member`
--

INSERT INTO `member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES
('2329 Round Table Drive\r\nCincinnati, Ohio\r\n45236', 'pierre.levy@gmaile.com', 'Pierre', 'LEVY', 99),
('1770 Charla Lane\r\nDallas,Texas\r\n75244', 'steph-lefe@gmaile.com', 'Stéphanie', 'LEFEBVRE', 100),
('123 rue de l\'alphabet, \r\n75006 PARIS', 'ceremej@gmail.com', 'Josué', 'CEREME', 101);


--
-- Déchargement des données de la table `borrowing`
--

INSERT INTO `borrowing` (`idborrow`, `isExtended`, `issueDate`, `returnDate`, `status`, `book_bookId`, `member_iduser`) VALUES
(15, b'1', '2018-12-27 00:00:00.000000', '2018-12-27 00:00:00.000000', 'Prêt terminé', 13, 99),
(16, b'1', '2018-12-27 00:00:00.000000', '2019-02-21 00:00:00.000000', 'En Cours et Prolongé', 3, 99),
(17, b'0', '2018-12-27 00:00:00.000000', '2019-01-24 00:00:00.000000', 'En Cours', 12, 99);

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);



--
-- Déchargement des données de la table `seq_borrow`
--

INSERT INTO `seq_borrow` (`next_val`) VALUES
(18);

--
-- Déchargement des données de la table `seq_user`
--

INSERT INTO `seq_user` (`next_val`) VALUES
(1);

--
-- Déchargement des données de la table `seq_work`
--

INSERT INTO `seq_work` (`next_val`) VALUES
(1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
