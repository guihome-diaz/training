-- Handy SQL queries
-- version 1.0
-- author: Guillaume Diaz


--
-- View all books, authors and publisher.
-- filter rows with ALL content only: BOOK + AUTHORS + PUBLISHER
--
-- Expect: 5 results
--
SELECT
  book.book_id,
  book.title       AS "Book title",
  author.author_id,
  author.last_name AS "Author",
  publisher.name   AS "Publisher"
FROM book
  INNER JOIN author_book ON author_book.book_id = book.book_id
  INNER JOIN author ON author_book.author_id = author.author_id
  INNER JOIN publisher ON publisher.publisher_id = book.publisher_id;

--
-- View all books, authors and publisher.
-- keep all books, NO MATTER the optional content
--
-- Expect: 6 results
--
SELECT
  book.book_id,
  book.title       AS "Book title",
  author.author_id,
  author.last_name AS "Author",
  publisher.name   AS "Publisher"
FROM book
  LEFT JOIN author_book ON author_book.book_id = book.book_id
  LEFT JOIN author ON author_book.author_id = author.author_id
  LEFT JOIN publisher ON publisher.publisher_id = book.publisher_id;