USE StackEcho;

CREATE TABLE Users (
	user_id integer auto_increment PRIMARY KEY,
    username varchar(25) unique NOT NULL, 
    firstname varchar(50) NOT NULL,
    lastname varchar (50) NOT NULL,
    email varchar(50) NOT NULL,
    password_hash  varchar(100)NOT NULL,
    created_at timestamp
);

CREATE TABLE Posts (
	post_id integer auto_increment PRIMARY KEY,
	title varchar(75) NOT NULL,
    body text NOT NULL,
    user_id integer,
    created_at timestamp,
    
    foreign key (user_id) references Users(user_id)
		on update cascade
        on delete set null
) ENGINE=InnoDB;

CREATE TABLE Comments (
	comment_id integer auto_increment PRIMARY KEY,
    comments text NOT NULL,
    user_id integer,
    post_id integer,
    created_at timestamp,
    
    foreign key (user_id) references users(user_id)
		on update cascade 
        on delete set null,
	foreign key (post_id) references posts(post_id)
		on update cascade 
        on delete set null
) ENGINE=InnoDB;

INSERT INTO Users (username, firstname, lastname, email, password_hash) VALUES 
('kchauntell', 'Kendra', 'Miller', 'kchauntell@stackecho.org', SHA2('P@$$word89',256)),
('carrie_awesome','Carrie','Priester','cpriester@stackecho.org',SHA2('C@rr1e',256));


 