select * from CUSTOMER;

create table board
(
	boardnum		number			primary key,
	custid			varchar2(20)	not null,
	title			varchar2(100)	not null,
	content			varchar2(2000)	not null,
	inputdate		date 			default sysdate,
	hits			number			default 0,
	originalfile	varchar2(200),
	savedfile		varchar2(200)
);

create squence board_seq
[start with 1 increment by 1]

create squence board_seq;

create table reply
(
	replynum	number			primary key,
	boardnum	number			not null,
	custid		varchar2(20)	not null,
	text		varchar2(200)	not null,
	inputdate	date			default sysdate,
	constraint reply_fk foreign key(boardnum)
	references board(boardnum) on delete cascade
);

create squence reply_seq;

select * from customer;
