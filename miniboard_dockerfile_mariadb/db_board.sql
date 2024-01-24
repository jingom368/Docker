CREATE TABLE tbl_board (
    seqno INT NOT NULL AUTO_INCREMENT,
    writer VARCHAR(50) NOT NULL,
    title VARCHAR(200) NOT NULL,
    content text NOT NULL,
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    userid VARCHAR(50) NOT NULL,
    hitno INT NULL,
    likecnt INT NULL,
    dislikecnt INT NULL,
    PRIMARY KEY (seqno)
);