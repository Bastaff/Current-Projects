
const sql = require('./db/db_conn');
const express = require('express');
const session = require('express-session');
const path = require('path');
const app = express();
const bodyParser = require('body-parser');

app.use(express.static(path.join(__dirname, 'public')));


// Connect to SQL database
sql.MySQLConnect();
app.use(bodyParser.urlencoded({extended: true}));

app.use(session({
    secret: 'secret',
    resave: true,
    saveUninitialized: true,
    maxAge: 24 * 60 * 60 * 1000
}));




app.get('/', (req, res) =>{
    res.sendFile(path.join(__dirname, 'public/views/login.html'));
});

app.get('/register', (req, res) =>{
    res.sendFile(path.join(__dirname, 'public/views/register.html'));
});

app.post('/register', (req, res) => {
    console.log('Got Body = ', req.body);

    let qry = "INSERT INTO user (firstName, lastName, userName, email, password) VALUES (?,?,?,?,?)";
    let values = [  
       req.body.firstName,
       req.body.lastName,
       req.body.userName,
       req.body.email,
       req.body.password
    ];
    sql.db.query(qry, values, (err) => {
        if (err) throw err;
       // console.log("Num logs " + result.affectedRows);
    });
    res.redirect('/home');
    res.end();
});


app.post('/login', function(req, res) {

    let querry = 'SELECT * FROM user WHERE userName = ? AND password = ?';
    let username = req.body.userName;
    let password = req.body.password;

	if (username && password) {
        console.log(username, password)
		sql.db.query(querry, [username, password], function(error, results, fields) {
			if (results.length > 0) {   
				req.session.loggedin = true;
				req.session.username = username;
				res.redirect('/home');
			} else {
                res.redirect('/login');
			}			
			res.end();
		});
	} else {
		res.send('Please enter Username and Password!');
		res.end();
	}
});


app.get('/home', (req, res) =>{
    res.sendFile(path.join(__dirname, 'public/views/home.html'));
})






const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server started on: ${PORT}`));