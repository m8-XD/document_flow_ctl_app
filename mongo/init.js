db.createUser(
        {
            user: "mongo",
            pwd: "mongo",
            roles: [
                {
                    role: "readWrite",
                    db: "document_db"
                }
            ]
        }
);
