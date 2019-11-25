CREATE TABLE EVENT_DATA
(
    ID int IDENTITY NOT_NULL PRIMARY KEY,
    EventName varchar(50) NOT_NULL,
    EventDateTime varchar(80) NOT_NULL,
    EventLocation int NOT_NULL
);