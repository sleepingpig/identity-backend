sqlite3 identity.sqlite \
"CREATE TABLE account(uid INTEGER PRIMARY KEY, firstname VARCHAR(20), lastname VARCHAR(20), username VARCHAR(20), email VARCHAR(20), verified BOOLEAN, password VARCHAR(30), create_ts BIGINT, update_ts BIGINT, description VARCHAR); INSERT INTO account (firstname, lastname, username, email, verified, password, create_ts, update_ts, description) VALUES('Ada', 'Lovelace', 'Alice', 'firstprogrammer@gmail.com', true, 'PASSWORD', 124213412132132131231, 532421321321312312, 'Test account');"
echo "===> successfully create identity.sqlite!"
