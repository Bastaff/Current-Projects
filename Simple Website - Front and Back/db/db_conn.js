const mysql = require('mysql');



    const db = mysql.createConnection({
        host    : 'localhost',
        user    : 'root',
        password: 'xxxxx',
        database: 'nodejs_simple_web'
    });


    function MySQLConnect() {
    db.connect((err) => {
    if(err){
        throw err;
    }
    console.log('MySQL Connected')
})};

module.exports = {
    MySQLConnect,
    db
};